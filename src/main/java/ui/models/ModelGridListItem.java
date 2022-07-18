package ui.models;

import org.json.JSONObject;

public class ModelGridListItem {
    private long id;
    private String nome, imgPath;
    private double preco;

    public ModelGridListItem(long id, String nome, String imgPath, double preco) {
        this.id = id;
        this.nome = nome;
        this.imgPath = imgPath;
        this.preco = preco;
    }
    
    public ModelGridListItem(String json) {
        JSONObject obj = new JSONObject(json);
        this.id = obj.getLong("id");
        this.nome = obj.getString("nome");
        this.imgPath = obj.getString("imgPath");
        this.preco = obj.getDouble("price");
    }
    
    public ModelGridListItem() {
        this.id = -1;
        this.nome = "";
        this.imgPath = "";
        this.preco = 0;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
