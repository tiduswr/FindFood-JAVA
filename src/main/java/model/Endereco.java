package model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class Endereco implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @NotBlank(message = "A rua não pode ser vazia!")
    private String rua;
    
    @NotBlank(message = "O bairro não pode ser vazia!")
    private String bairro;
    
    @NotBlank(message = "A cidade não pode ser vazia!")
    private String cidade;
    
    @NotBlank(message = "O estado não pode ser vazia!")
    private String estado;
    
    private int numero;
    
    public Endereco(String rua, String bairro, String cidade, String estado, int numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public Endereco() {
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
