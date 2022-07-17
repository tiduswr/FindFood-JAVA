package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Endereco;
import model.Pessoa;
import model.Produto;
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
    
    public void loadUserDataOnCadastroForm(CadastroForm f){
        if(logged != null){
            updateLogged();
            
            f.setCPF(logged.getCpf());
            f.setNome(logged.getNome());
            f.setSobrenome(logged.getSobrenome());
            
            f.setRua(logged.getEndereco().getRua());
            f.setBairro(logged.getEndereco().getBairro());
            f.setNumero(logged.getEndereco().getNumero());
            f.setCidade(logged.getEndereco().getCidade());
            f.setEstado(logged.getEndereco().getEstado());
            
            if(logged.getAccess().getTipo() == TipoUsuario.Administrador){
                f.setTipoUsuario("Administrador");
            }else if(logged.getAccess().getTipo() == TipoUsuario.Cliente){
                f.setTipoUsuario("Cliente");
            }
            
        }
    }
    
    public void updateHeader(HeaderComponent h){
        if(logged != null){
            updateLogged();
            
            h.setSaldo(logged.getAccess().getSaldo());
            String userName = logged.getNome() + " " + logged.getSobrenome();
            userName += "(" + logged.getAccess().getTipo().toValue().toUpperCase() + ")";
            h.setUserName(userName);
            
        }
    }
    
    public String getLogged() throws JsonProcessingException{
        if(logged != null) updateLogged();
        return Util.toJson(logged);
    }
    
    public String getProdutos() throws JsonProcessingException{
        if(logged != null){
            updateLogged();
            ConcreteRepository<Produto> rep = new ConcreteRepository(emf, em);
            Query q;
            if(logged.getAccess().getTipo() == TipoUsuario.Administrador){
                q = em.createQuery("FROM Produto WHERE user_id = :userId");
                q.setParameter("userId", logged.getId());
                List<Produto> l = rep.retriveMany(q);
                return Util.toJson(l);
            }else{
                q = em.createQuery("FROM Produto");
                List<Produto> l = rep.retriveMany(q);
                return Util.toJson(l);
            }
        }
        return null;
    }
    
    private void updateProduct(Produto p, CadastrarProdutosForm f){
        p.setNome(f.getNome());
        p.setDescricao(f.getDesc());
        p.setImgPath(f.getImgPath());
        p.setOwner(logged);
        p.setTipo(f.getTipo());

        double price = 0d;
        try{
            price = Double.parseDouble(f.getPreco());
        }catch(NumberFormatException e){
            throw new NumberFormatException("O preço precisa ser um numero Real.");
        }

        int estoque = 0;
        try{
            estoque = Integer.parseInt(f.getEstoque());
        }catch(NumberFormatException e){
            throw new NumberFormatException("O estoque precisa ser um numero Inteiro.");
        }
        
        p.setPrice(price);
        p.setEstoque(estoque);
    }
    
    private Produto createProduct(CadastrarProdutosForm f) throws NumberFormatException, IllegalArgumentException {
            Produto p = new Produto();
            
            p.setId(null);
            updateProduct(p, f);
            
            return p;
    }
    
    public void registerProducts(CadastrarProdutosForm f) throws NumberFormatException, IllegalArgumentException{
        if(logged != null && logged.getAccess().getTipo() == TipoUsuario.Administrador){ 
            
            ConcreteRepository<Produto> rep = new ConcreteRepository(emf, em);
            
            //Criando produto na memória
            Produto p = createProduct(f);
            
            //Validando dados
            ValidateClass<Produto> v = new ValidateClass();
            String violation = v.getFirstViolation(p);
            if(violation != null) throw new IllegalArgumentException(violation);
            if(p.getImgPath() == null || p.getImgPath().equalsIgnoreCase("")) 
                throw new IllegalArgumentException("Carregue uma imagem para o produto!");
            
            //Checa se produto ja existe
            if(searchProductByNome(p.getNome()) != null)
                throw new IllegalArgumentException("Esse produto ja está cadastrado!");
            
            //Copiando imagem para a pasta local
            File inputImage = new File(p.getImgPath());
            if(inputImage.exists()){
                try{
                    BufferedImage bufferedProducImage = ImageIO.read(inputImage);
                    
                    File file = new File("productimages" + File.separator + p.getNome() + ".png");
                    file.createNewFile();
                    
                    ImageIO.write(bufferedProducImage, "PNG", file);
                    p.setImgPath(file.getAbsolutePath());
                }catch(IOException e){
                    throw new IllegalArgumentException("Não foi possivel carregar/salvar a imagem!");
                }
            }else{
                throw new IllegalArgumentException("Imagem não encontrada!");
            }
            
            //Persistindo dados
            rep.persist(p);
        }
    }
    
    private Produto searchProduct(CadastrarProdutosForm f, ConcreteRepository<Produto> rep) throws IllegalArgumentException {
        //Criando produto na memória
        Query q = em.createQuery("FROM Produto WHERE id = :id");
        q.setParameter("id", f.getEditedItemId());
        Produto busca = null;
        try{
            busca = rep.retrieve(q);
        }catch(NoResultException e){}
        if(busca == null) throw new IllegalArgumentException("Produto não Encontrado!");
        return busca;
    }
    
    private Produto searchProductByNome(String nome){
        ConcreteRepository<Produto> rep = new ConcreteRepository(emf, em);
        Query q = em.createQuery("FROM Produto WHERE nome = :nome");
        q.setParameter("nome", nome);
        Produto busca = null;
        try{
            busca = rep.retrieve(q);
        }catch(NoResultException e){}
        return busca;
    }
    
    public String searchProduct(long id) throws IllegalArgumentException {
        ConcreteRepository<Produto> rep = new ConcreteRepository(emf, em);
        Query q = em.createQuery("FROM Produto WHERE id = :id");
        q.setParameter("id", id);
        Produto busca = null;
        try{
            busca = rep.retrieve(q);
        }catch(NoResultException e){}
        
        if(busca == null) throw new IllegalArgumentException("Produto não Encontrado!");
        
        try {
            return Util.toJson(busca);
        } catch (JsonProcessingException ex) {
            throw new IllegalArgumentException("Erro ao retornar Resposta!");
        }
    }
    
    public void updateProduct(CadastrarProdutosForm f) throws IllegalArgumentException {
        if(logged != null && logged.getAccess().getTipo() == TipoUsuario.Administrador){ 
            ConcreteRepository<Produto> rep = new ConcreteRepository(emf, em);
            
            //Criando produto na memória
            Produto busca = searchProduct(f, rep);
            String originalName = busca.getNome();
            updateProduct(busca, f);
            
            //Verifica se o nome foi alterado e esta disponivel
            if(!originalName.equals(busca.getNome())){
                Produto checkName = searchProductByNome(busca.getNome());
                if(checkName != null) throw new IllegalArgumentException("Ja existe um produto com esse Nome!");
                File file = new File("productimages" + File.separator + originalName + ".png");
                File renamed = new File("productimages" + File.separator + busca.getNome() + ".png");
                file.renameTo(renamed);
                busca.setImgPath(renamed.getAbsolutePath());
            }
            
            //Persistindo dados
            rep.update(busca);
        }
    }
    
    public void deleteProduct(CadastrarProdutosForm f) throws IllegalArgumentException {
        if(logged != null && logged.getAccess().getTipo() == TipoUsuario.Administrador){ 
            ConcreteRepository<Produto> rep = new ConcreteRepository(emf, em);
            
            //Criando produto na memória
            Produto busca = searchProduct(f, rep);
            
            //Deleta a imagem
            File file = new File("productimages" + File.separator + busca.getNome() + ".png");
            if(file.exists()) file.delete();
            
            //Persistindo dados
            rep.delete(busca.getId(), Produto.class);
        }
    }
    
    private void updateLogged(){
        ConcreteRepository<Pessoa> repPessoa = new ConcreteRepository(emf, em);
        Query q = em.createQuery("FROM Pessoa WHERE cpf = :cpf");
        q.setParameter("cpf", logged.getCpf());
        logged = repPessoa.retrieve(q);
    }
    
}
