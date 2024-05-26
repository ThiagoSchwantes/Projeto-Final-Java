package br.edu.up.models;

public class Cliente {

    private Integer clienteId;
    private String nomeCliente;
    private String rg;
    private String cpf;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    
    public Cliente(Integer clienteId, String nomeCliente, String rg, String cpf, String cep, String endereco,
            String bairro, String cidade) {
        this.clienteId = clienteId;
        this.nomeCliente = nomeCliente;
        this.rg = rg;
        this.cpf = cpf;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Cliente(String nomeCliente, String rg, String cpf, String cep, String endereco, String bairro,
            String cidade) {
        this.nomeCliente = nomeCliente;
        this.rg = rg;
        this.cpf = cpf;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
    }


    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String toStringBasico(){
        return "Cliente [Id=" +  clienteId + "nome=" + nomeCliente + "]";
    }

    @Override
    public String toString() {
        return "Cliente [Id=" + clienteId + ", nome=" + nomeCliente + ", rg=" + rg + ", cpf=" + cpf + ", cep=" + cep + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + "]";
    }

    public String toCSV(){
        return clienteId + ";" + nomeCliente + ";" + rg + ";" + cpf + ";" + cep + ";" + endereco + ";" + bairro + ";" + cidade;
    }

    
}
