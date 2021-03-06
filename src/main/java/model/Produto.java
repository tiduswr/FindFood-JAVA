package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Produto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "produto_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected Long id;
    
    @NotBlank(message = "O nome não pode ser vazio!")
    protected String nome;
    
    @NotBlank(message = "A descrição não pode ser vazio!")
    protected String descricao;
    
    @NotBlank(message = "O tipo não pode ser vazio!")
    protected String tipo;
    
    //Relacionando dados
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    protected Pessoa owner;
    
    protected String imgPath;
    protected Double price;
    protected int estoque;

    public Produto(Long id, Pessoa owner, String nome, String descricao, String tipo, String imgPath, Double price, int estoque) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imgPath = imgPath;
        this.price = price;
        this.estoque = estoque;
        this.owner = owner;
        this.tipo = tipo;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long l) {
        id = l;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Pessoa getOwner() {
        return owner;
    }

    public void setOwner(Pessoa owner) {
        this.owner = owner;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
