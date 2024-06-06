package br.edu.up.models;

import java.time.LocalDateTime;

public class OrdemDeServico {
    private int codigo;
    private LocalDateTime dataEHoraAbertura;
    private Cliente cliente;
    private String funcionario;
    private String comentario;
    private ProdutoOrdemServico produtoOS;
    private Status status;

    public enum Status{
        EM_PRODUCAO,
        EM_ACABAMENTO,
        FINALIZADA,
        SOLICITADO_BAIXA,
        BAIXADA
    }
    
    public OrdemDeServico() {
    }

    public OrdemDeServico(int codigo, LocalDateTime dataEHoraAbertura, Cliente cliente, String funcionario,
        String comentario, ProdutoOrdemServico produtoOS, Status status) {
        this.codigo = codigo;
        this.dataEHoraAbertura = dataEHoraAbertura;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.comentario = comentario;
        this.produtoOS = produtoOS;
        this.status = status;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public LocalDateTime getDataEHoraAbertura() {
        return dataEHoraAbertura;
    }
    public void setDataEHoraAbertura(LocalDateTime dataEHoraAbertura) {
        this.dataEHoraAbertura = dataEHoraAbertura;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public ProdutoOrdemServico getProdutoOS() {
        return produtoOS;
    }
    public void setProdutoOS(ProdutoOrdemServico produtoOS) {
        this.produtoOS = produtoOS;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrdemDeServico [codigo=" + codigo + ", dataEHoraAbertura=" + dataEHoraAbertura + ", cliente=" + cliente
                + ", funcionario=" + funcionario + ", comentario=" + comentario + ", produtoOS=" + produtoOS
                + ", status=" + status + "]";
    }


    
}