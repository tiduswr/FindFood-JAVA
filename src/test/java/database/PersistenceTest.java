package database;

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
import model.Venda;
import model.VendaProduto;
import model.repository.ConcreteRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersistenceTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public PersistenceTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        System.out.println("##################################");
        System.out.println("Connecting to database...");
        System.out.println("##################################");
        emf = Persistence.createEntityManagerFactory("teste_persistence_xml");
        em = emf.createEntityManager();
        System.out.println("!!!!!!!!!! SUCCESS !!!!!!!!!!!\n\n");
        
        System.out.println("##################################");
        System.out.println("Inserting a sample User...");
        System.out.println("##################################");
        ConcreteRepository<Pessoa> pv = new ConcreteRepository(emf, em);
        Pessoa p1 = new Pessoa(null, "Harllem", "Alves", "12679692454", null, 
                new Endereco("rua", "bairro", "cidade", "estado", 12));
        Usuario user = new Usuario(null, 100d, "xxx", TipoUsuario.Cliente);
        p1.setAccess(user);
        pv.persist(p1);
        Pessoa p2 = new Pessoa(null, "Neto", "Alves", "69741558082", null, 
                new Endereco("rua", "bairro", "cidade", "estado", 12));
        Usuario user2 = new Usuario(null, 100d, "xxx", TipoUsuario.Cliente);
        p1.setAccess(user2);
        pv.persist(p2);
        System.out.println("!!!!!!!!!! SUCCESS !!!!!!!!!!!\n\n");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("##################################");
        System.out.println("Closing Connection with database...");
        System.out.println("##################################");
        em.close();
        emf.close();
        System.out.println("!!!!!!!!!! SUCCESS !!!!!!!!!!!\n\n");
    }

    @Test
    public void findUserTest(){
        System.out.println("##################################");
        System.out.println("Testing search of an User...");
        System.out.println("##################################");
        ConcreteRepository<Pessoa> pv = new ConcreteRepository(emf, em);
        Query q = em.createQuery("FROM Pessoa WHERE cpf = :cpf");
        q.setParameter("cpf", "12679692454");
        Pessoa p1 = pv.retrieve(q);
        
        assertNotNull(p1);
        assertNotNull(p1.getAccess());
        System.out.println("!!!!!!!!!! SUCCESS !!!!!!!!!!!\n\n");
    }
    
    @Test 
    public void errorExpectedFindingUser(){
        System.out.println("##################################");
        System.out.println("Testing an expected error in search of a user...");
        System.out.println("##################################");
        ConcreteRepository<Pessoa> pv = new ConcreteRepository(emf, em);
        Query q = em.createQuery("FROM Pessoa WHERE cpf = :cpf");
        q.setParameter("cpf", "2222");
        Pessoa p1 = null;
        try{p1 = pv.retrieve(q);}catch(NoResultException e){}
        
        assertNull(p1);
        System.out.println("!!!!!!!!!! SUCCESS !!!!!!!!!!!\n\n");
    }
    
    @Test
    public void persistenceAndSearchVendaTest(){
        System.out.println("##################################");
        System.out.println("Product and Seeling tests(Persistence and Search)...");
        System.out.println("##################################");
        ConcreteRepository<Venda> rv = new ConcreteRepository(emf, em);
        ConcreteRepository<Pessoa> pv = new ConcreteRepository(emf, em);
        
        Query q = em.createQuery("FROM Pessoa WHERE cpf = :cpf");
        q.setParameter("cpf", "12679692454");
        Pessoa p1 = pv.retrieve(q);
        
        q = em.createQuery("FROM Pessoa WHERE cpf = :cpf");
        q.setParameter("cpf", "69741558082");
        Pessoa p2 = pv.retrieve(q);
        
        Venda v = new Venda(null, p1);
        
        v.addProduto(new VendaProduto(new Produto(null, p2, "Burger", "Carne", "Hamburger", "img", 25d, 10)));
        v.addProduto(new VendaProduto(new Produto(null, p2, "XBurger", "Carne", "Hamburger", "img", 25d, 10)));
        v.addProduto(new VendaProduto(new Produto(null, p2, "ZBurger", "Carne", "Hamburger", "img", 25d, 10)));
        System.out.println("----------Persisting...");
        rv.persist(v);
        
        System.out.println("----------Searching...");
        q = em.createQuery("FROM Venda WHERE user_id = :uid");
        q.setParameter("uid", 1l);
        v = rv.retrieve(q);
        
        assertNotNull(v);
        assertTrue(v.getProdutos().size() == 3);
        assertTrue(v.getProdutos().get(0).getProduto().getOwner().getCpf().equals(p1.getCpf()));
        System.out.println("!!!!!!!!!! SUCCESS !!!!!!!!!!!\n\n");
    }
    
}
