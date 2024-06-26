package br.edu.up.models;

public class Pagamento {
    private Integer pagamentoId;
    private String nomePagamento;

    public Pagamento() {
    }

    public Pagamento(Integer pagamentoId, String nomePagamento) {
        this.pagamentoId = pagamentoId;
        this.nomePagamento = nomePagamento;
    }

    public Pagamento(String nomePagamento) {
        this.nomePagamento = nomePagamento;
    }
    

    public Integer getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Integer pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public String getNomePagamento() {
        return nomePagamento;
    }

    public void setNomePagamento(String nomePagamento) {
        if (nomePagamento == null || nomePagamento.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do pagamento não pode ser nulo ou vazio");
        }
        this.nomePagamento = nomePagamento;
    }



    @Override
    public String toString() {
        return "Pagamento [pagamentoId=" + pagamentoId + ", nomePagamento=" + nomePagamento + "]";
    }

    public String toCSV(){
        return pagamentoId + ";" + nomePagamento;
    }
}
