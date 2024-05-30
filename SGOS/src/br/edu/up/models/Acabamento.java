package br.edu.up.models;

public class Acabamento {
    private Integer acabamentoId;
    private String nomeAcabamento;
    private String descricao;

    public Acabamento() {
    }

    public Acabamento(Integer acabamentoId, String nomeAcabamento, String descricao) {
        this.acabamentoId = acabamentoId;
        this.nomeAcabamento = nomeAcabamento;
        this.descricao = descricao;
    }

    public Acabamento(String nomeAcabamento, String descricao) {
        this.nomeAcabamento = nomeAcabamento;
        this.descricao = descricao;
    }

    public Integer getAcabamentoId() {
        return acabamentoId;
    }

    public void setAcabamentoId(Integer acabamentoId) {
        this.acabamentoId = acabamentoId;
    }

    public String getNomeAcabamento() {
        return nomeAcabamento;
    }

    public void setNomeAcabamento(String nomeAcabamento) {
        if (nomeAcabamento == null || nomeAcabamento.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do acabamento não pode ser nulo ou vazio");
        }
        this.nomeAcabamento = nomeAcabamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String toStringBasico(){
        return "Acabamento [Id=" +  acabamentoId + "  nome=" + nomeAcabamento + "]";
    }
    
    @Override
    public String toString() {
        return "Acabamento [acabamentoId=" + acabamentoId + ", nomeAcabamento=" + nomeAcabamento + ", descricao="
                + descricao + "]";
    }

    public String toCSV(){
        return acabamentoId + ";" + nomeAcabamento + ";" + descricao;
    }
}
