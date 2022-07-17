package controller;

public interface CadastrarProdutosForm {
    public Long getEditedItemId();
    public String getNome();
    public String getTipo();
    public String getDesc();
    public String getPreco();
    public String getEstoque();
    public String getImgPath();
    public void setNome(String v);
    public void setTipo(String v);
    public void setDesc(String v);
    public void setPreco(String v);
    public void setEstoque(String v);
    public void setImgPath(String v);
}
