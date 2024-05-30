package br.edu.up.models;

public class Produto {

    private Integer produtoId;
    private String nomeProduto;
    private String descricao;
    
    public Produto() {
    }

    public Produto(Integer produtoId, String nomeProduto, String descricao) {
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
    }

    public Produto(String nomeProduto, String descricao) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
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
        return "Produto [Id=" +  produtoId + "nome=" + nomeProduto + "]";
    }

    @Override
    public String toString() {
        return "Produto [produtoId=" + produtoId + ", nomeProduto=" + nomeProduto + ", descricao=" + descricao + "]";
    }
    
    public String toCSV(){
        return produtoId + ";" + nomeProduto + ";" + descricao;
    }
    
}
