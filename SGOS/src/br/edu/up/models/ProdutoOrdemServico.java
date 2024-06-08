package br.edu.up.models;

public class ProdutoOrdemServico {
    private Integer produtoOrdemServicoId;
    private Produto produto;
    private Integer quantidade;
    private Double largura;
    private Double altura;
    private Double totalM2;
    private Double valorM2;
    private Double valorUnitario;
    private Double subTtotal;
    private Equipamento equipamento;
    private Acabamento acabamento;

    public ProdutoOrdemServico() {
        
    }

    public ProdutoOrdemServico(Produto produto, Integer quantidade, Double largura, Double altura,
            Double valorM2, Equipamento equipamento, Acabamento acabamento) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.largura = largura;
        this.altura = altura;
        this.totalM2 = (largura * altura);
        this.valorM2 = valorM2;
        this.valorUnitario = (largura * altura) * valorM2;
        this.subTtotal = valorUnitario * quantidade;
        this.equipamento = equipamento;
        this.acabamento = acabamento;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Double getLargura() {
        return largura;
    }
    public void setLargura(Double largura) {
        this.largura = largura;
    }
    public Double getAltura() {
        return altura;
    }
    public void setAltura(Double altura) {
        this.altura = altura;
    }
    public Double getTotalM2() {
        return totalM2;
    }
    public void setTotalM2(Double totalM2) {
        this.totalM2 = totalM2;
    }
    public Double getValorM2() {
        return valorM2;
    }
    public void setValorM2(Double valorM2) {
        this.valorM2 = valorM2;
    }
    public Double getValorUnitario() {
        return valorUnitario;
    }
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public Double getSubTtotal() {
        return subTtotal;
    }
    public void setSubTtotal(Double subTtotal) {
        this.subTtotal = subTtotal;
    }
    public Equipamento getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
    public Acabamento getAcabamento() {
        return acabamento;
    }
    public void setAcabamento(Acabamento acabamento) {
        this.acabamento = acabamento;
    }

    public Integer getProdutoOrdemServicoId() {
        return produtoOrdemServicoId;
    }

    public void setProdutoOrdemServicoId(Integer produtoOrdemServicoId) {
        this.produtoOrdemServicoId = produtoOrdemServicoId;
    }

    @Override
    public String toString() {
        return "ProdutoOrdemServico [produtoOrdemServicoId=" + produtoOrdemServicoId + ", produto=" + produto
                + ", quantidade=" + quantidade + ", largura=" + largura + ", altura=" + altura + ", totalM2=" + totalM2
                + ", valorM2=" + valorM2 + ", valorUnitario=" + valorUnitario + ", subTtotal=" + subTtotal
                + ", equipamento=" + equipamento + ", acabamento=" + acabamento + "]";
    }
    
    public String toCSV(){
        return produtoOrdemServicoId + ";" + produto.getProdutoId() + ";" + quantidade + ";" + largura + ";" + altura + ";" + valorM2 + ";" + equipamento.getEquipamentoId() + ";" + acabamento.getAcabamentoId();
    }
}