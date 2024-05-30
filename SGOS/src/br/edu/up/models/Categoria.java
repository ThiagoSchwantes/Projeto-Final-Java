package br.edu.up.models;

public class Categoria {
    private Integer categoriaId;
    private String nomeCategoria;
    private String descricao;

    public Categoria() {
    }

    public Categoria(Integer categoriaId, String nomeCategoria, String descricao) {
        this.categoriaId = categoriaId;
        this.nomeCategoria = nomeCategoria;
        this.descricao = descricao;
    }

    public Categoria(String nomeCategoria, String descricao) {
        this.nomeCategoria = nomeCategoria;
        this.descricao = descricao;
    }
    
    public Integer getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        if (nomeCategoria == null || nomeCategoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do categoria não pode ser nulo ou vazio");
        }
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public String toString() {
        return "Categoria [categoriaId=" + categoriaId + ", nomeCategoria=" + nomeCategoria + ", descricao=" + descricao
                + "]";
    }

    public String toStringBasico(){
        return "Acabamento [Id=" +  categoriaId + "  nome=" + nomeCategoria + "]";
    }

    public String toCSV(){
        return categoriaId + ";" + nomeCategoria + ";" + descricao;
    }
}
