package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Usuario implements Serializable{
    
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double saldo;
    
    @NotBlank(message = "A senha não pode ser vazio!")
    private String senha;
    
    //Relacionando dados
    @OneToOne(mappedBy = "access")
    private Pessoa owner;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Produto> produtos;
    
    //Persistindo uma ENUM
    //Valor para ser salvo na tabela
    @Basic
    private int tipoValue;
    //Valor Enum
    @Transient //Indica que esse atributo não será criado no banco de dados
    private TipoUsuario tipo;
    //Função para atribuir o valor ao Enumerador
    @PostLoad //Anotação que executa a função abaixo após o objeto ser recuperado do banco de dados
    public void fillTransient(){
        if(tipoValue > 0) this.tipo = TipoUsuario.of(tipoValue);
    }
    //Transforma o valor Enum para inteiro e salva na coluna tipoValue
    @PrePersist //Antes de persistir um dado a função abaixo é executada
    public void fillPersistent(){
        if(tipo != null) this.tipoValue = tipo.getTipo();
    }

    public Usuario(Long id, Double saldo, String senha, TipoUsuario tipo) {
        this.id = id;
        this.saldo = saldo;
        this.senha = Util.md5Cript(senha);
        this.tipoValue = tipo.getTipo();
        this.tipo = tipo;
    }

    public Usuario() {
    }
    
    public Long getId() {
        return id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = Util.md5Cript(senha);
    }

    public int getTipoValue() {
        return tipoValue;
    }

    public void setTipoValue(int tipoValue) {
        this.tipoValue = tipoValue;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Pessoa getOwner() {
        return owner;
    }

    public void setOwner(Pessoa owner) {
        this.owner = owner;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
}

