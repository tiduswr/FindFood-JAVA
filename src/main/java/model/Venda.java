package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Venda implements Serializable{

    @Id
    @Column(name = "venda_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private double total;
    @NotNull
    private LocalDate date;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Pessoa owner;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private List<VendaProduto> produtos;

    public Venda(Long id, Pessoa owner) {
        this.id = id;
        this.total = 0;
        this.date = Util.convertToLocalDateViaInstant(new Date());
        this.owner = owner;
        this.produtos = new ArrayList<>();
    }

    public Venda() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Pessoa getOwner() {
        return owner;
    }

    public void setOwner(Pessoa owner) {
        this.owner = owner;
    }

    public VendaProduto getProduto(Long id) {
        Optional<VendaProduto> opt = produtos.stream().filter(e -> Objects.equals(e.getProduto().getId(), id)).findFirst();
        if(opt.isPresent()) return opt.get();
        return null;
    }
    
    public VendaProduto removeProduto(Long id) {
        Optional<VendaProduto> opt = produtos.stream().filter(e -> Objects.equals(e.getProduto().getId(), id)).findFirst();
        if(opt.isPresent()) {
            produtos.remove(opt.get());
            return opt.get();
        }
        return null;
    }
    
    public void clearProdutos(){
        produtos.clear();
    }
    
    public void addProduto(VendaProduto produto) {
        produto.setVenda(this);
        this.produtos.add(produto);
        this.total += produto.getProduto().getPrice();
    }
    
    public List<VendaProduto> getProdutos(){
        return produtos;
    }
    
    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", total=" + total + ", date=" + date + ", owner=" + owner + '}';
    }
    
}
