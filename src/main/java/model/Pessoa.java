package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
public class Pessoa implements Serializable{
    
    @Id
    @Column(name = "pessoa_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome não pode ser vazio!")
    private String nome;
    
    @NotBlank(message = "O Sobnrenome não pode ser vazio!")
    private String sobrenome;
    
    @CPF(message = "O CPF não é válido!")
    private String cpf;
    
    @Embedded
    private Endereco endereco;
    
    //Relacionando dados
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Usuario access;
    
    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String sobrenome, String cpf, Usuario user, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.access = user;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getAccess() {
        return access;
    }

    public void setAccess(Usuario access) {
        this.access = access;
    }
    
}
