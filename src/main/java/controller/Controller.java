package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Endereco;
import model.Pessoa;
import model.TipoUsuario;
import model.Usuario;
import model.Util;
import model.ValidateClass;
import model.Venda;
import model.repository.ConcreteRepository;

public final class Controller {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private Venda carrinho;
    private Pessoa logged;
    
    public Controller(){
        createNewDatabaseConnection();
        carrinho = null;
    }
    
    public void closeDatabaseConnection(){
        if(em != null) emf.close();
        if(emf != null)em.close();
    }
    
    public void createNewDatabaseConnection(){
        closeDatabaseConnection();
        emf = Persistence.createEntityManagerFactory("persistence_xml");
        em = emf.createEntityManager();
    }
    
    public void createNewUser(CadastroForm form) throws NumberFormatException, IllegalArgumentException {
        ConcreteRepository<Usuario> repUser = new ConcreteRepository(emf, em);
        ConcreteRepository<Pessoa> repPessoa = new ConcreteRepository(emf, em);
        
        //Trata o tipo de usuário
        TipoUsuario tipo;
        if(form.getTipoUsuario().equalsIgnoreCase("administrador")){
            tipo = TipoUsuario.Administrador;
        }else if(form.getTipoUsuario().equalsIgnoreCase("cliente")){
            tipo = TipoUsuario.Cliente;
        }else{
            throw new IllegalArgumentException("Erro ao identificar o tipo de Usuario!");
        }
        
        //Trata o numero da casa
        int numero;
        try{
            numero = Integer.parseInt(form.getNumero());
        }catch(NumberFormatException e){
            throw new NumberFormatException("Numero da casa aceita apenas numeros!");
        }
        
        //Trata o CPF
        String cpf = form.getCPF();
        if(form.getCPF() != null) cpf = form.getCPF().replace(".", "").replace("-", "");
        
        //Monta os objetos
        Usuario user = new Usuario(null, 0d, form.getSenha(), tipo);
        Endereco end = new Endereco(form.getRua(), form.getBairro(), form.getCidade(), form.getEstado(), numero);
        Pessoa p = new Pessoa(null, form.getNome(), form.getSobrenome(), cpf, user, end);
        
        //Valida os dados
        ValidateClass<Usuario> vUser = new ValidateClass<>();
        ValidateClass<Pessoa> vPessoa = new ValidateClass<>();
        ValidateClass<Endereco> vEndereco = new ValidateClass<>();
        String violation = vUser.getFirstViolation(user);
        if(violation != null) throw new IllegalArgumentException(violation);
        violation = vPessoa.getFirstViolation(p);
        if(violation != null) throw new IllegalArgumentException(violation);
        violation = vEndereco.getFirstViolation(p.getEndereco());
        if(violation != null) throw new IllegalArgumentException(violation);
        
        //Persiste os dados
        //Primeiro verifica se essa pessoa ja existe
        Query q = em.createQuery("FROM Pessoa WHERE cpf = :cpf");
        q.setParameter("cpf", p.getCpf());
        Pessoa teste;
        try{
            teste = repPessoa.retrieve(q);
            if(teste != null) throw new IllegalArgumentException("Usuário já cadastrado!");
        }catch(NoResultException e){}
        //Depois grava no banco de dados
        repUser.persist(user);
        repPessoa.persist(p);
    }
    
    public boolean login(LoginForm form){
        ConcreteRepository<Pessoa> repPessoa = new ConcreteRepository(emf, em);
        
        Query q = em.createQuery("FROM Pessoa WHERE cpf = :cpf");
        q.setParameter("cpf", form.getLogin());
        Pessoa p = null;
        try{
            p = repPessoa.retrieve(q);
        }catch(NoResultException e){}
        if(p != null){
            if(Util.md5Cript(form.getSenha()).equalsIgnoreCase(p.getAccess().getSenha())){
                logged = p;
                return true;
            }
        }
        logged = null;
        return false;
    }
    
    public String getLogged() throws JsonProcessingException{
        return Util.toJson(logged);
    }
    
}
