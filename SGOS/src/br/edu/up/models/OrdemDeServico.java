package br.edu.up.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.edu.up.util.Prompt;

public class OrdemDeServico {
    private int codigo;
    private LocalDateTime dataEHoraAbertura;
    private Cliente cliente;
    private Funcionario funcionario;
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

    public OrdemDeServico(Cliente cliente, Funcionario funcionario,
        String comentario, ProdutoOrdemServico produtoOS) {
        this.dataEHoraAbertura = LocalDateTime.now();
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.comentario = comentario;
        this.produtoOS = produtoOS;
        this.status = Status.EM_PRODUCAO;
    }

    public OrdemDeServico(int codigo, LocalDateTime dataEHoraAbertura, Cliente cliente, Funcionario funcionario,
    String comentario, ProdutoOrdemServico produtoOS) {
    this.codigo = codigo;
    this.dataEHoraAbertura = dataEHoraAbertura;
    this.cliente = cliente;
    this.funcionario = funcionario;
    this.comentario = comentario;
    this.produtoOS = produtoOS;
    this.status = Status.EM_PRODUCAO;
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
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public ProdutoOrdemServico getProdutoOS() {
        return produtoOS;
    }
    public void setProdutoOS(ProdutoOrdemServico produtoOS) {
        this.produtoOS = produtoOS;
    }

    @Override
    public String toString() {
        return "OrdemDeServico [codigo=" + codigo + ", dataEHoraAbertura=" + dataEHoraAbertura + ", cliente=" + cliente
                + ", funcionario=" + funcionario + ", comentario=" + comentario + ", produtoOS=" + produtoOS
                + ", status=" + status + "]";
    }

    public String getDataEHoraAberturaToString(){
        LocalDateTime dataEHoraAbertura = LocalDateTime.parse("2024-06-12T19:00:29.713865400");
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dataEHoraAbertura.format(formatador);

        return dataFormatada;
    }

    public String toStringInfoOs(){
        return  
            "Ordem de Serviço: \n" + 
                "\tCliente: " + cliente.getNomeCliente() + "\n" +
                "\tFuncionario: "+ funcionario.getNomeFuncionario() + "\n" +
                "\tData de abertura: " + getDataEHoraAberturaToString() + "\n" + 
                "\tStatus: " + status.toString() + "\n" +
                "\tComentário: " + comentario;
    }

    public String toStringBasico(){
        return  
            "Ordem de Serviço: \n" + 
                "\tCliente: " + cliente.getNomeCliente() + "\n" +
                "\tFuncionario: "+ funcionario.getNomeFuncionario() + "\n" +
                "\tData de abertura: " + getDataEHoraAberturaToString() + "\n" + 
                "\tStatus: " + status.toString() + "\n" +
                "\tComentário: " + comentario + "\n\n" +  
        
            "Detalhes do Produto da Os: \n" +
                "\tProduto: " + produtoOS.getProduto().getNomeProduto() + "\n"+
                "\tQuantidade: " + produtoOS.getQuantidade() + "\n" +
                "\tlargura: " + produtoOS.getLargura() + "\n" +
                "\taltura: " + produtoOS.getAltura() + "\n" +
                "\tvalor do metro quadrado: " + produtoOS.getValorM2() + "\n" +
                "\ttotal do metro quadrado: " + produtoOS.getTotalM2() + "\n" +
                "\tvalor unitário: " + produtoOS.getValorUnitario() + "\n" +
                "\tsubTotal: " + produtoOS.getSubTtotal() + "\n" + 
                "\tequipamento: " + produtoOS.getEquipamento().getNomeEquipamento() + "\n" +
                "\tacabamento: " + produtoOS.getAcabamento().getNomeAcabamento() + "\n"; 
    }
    
    public String toCSV(){
        Prompt.imprimir(funcionario);
        return codigo + ";" + dataEHoraAbertura + ";" + cliente.getClienteId() + ";" + funcionario.getFuncionarioId() + ";" + comentario + ";" + produtoOS.getProdutoOrdemServicoId();
    }
}