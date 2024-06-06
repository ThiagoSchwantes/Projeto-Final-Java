package br.edu.up.models;

public class Produto {

    private Integer produtoId;
    private String nomeProduto;
    private String descricao;
    private Categoria categoria;
    
    public Produto() {
    }

    public Produto(Integer produtoId, String nomeProduto, String descricao, Categoria categoria) {
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Produto(String nomeProduto, String descricao, Categoria categoria) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNomeProduto(String nomeProduto) {
        if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto não pode ser nulo ou vazio");
        }
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toStringBasico(){
        return "Produto [Id=" +  produtoId + ", nome=" + nomeProduto + ", categoria= "+ categoria.getNomeCategoria() + "]";
    }
    
    @Override
    public String toString() {
        return "Produto [produtoId=" + produtoId + ", nomeProduto=" + nomeProduto + ", descricao=" + descricao
                + ", categoria=" + categoria.getNomeCategoria() + "]";
    }

    public String toCSV(){
        return produtoId + ";" + nomeProduto + ";" + descricao + ";" + categoria.getNomeCategoria();
    }
    
}
