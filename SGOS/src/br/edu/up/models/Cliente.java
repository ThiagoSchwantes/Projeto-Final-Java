package br.edu.up.models;

public abstract class Cliente {

    private Integer clienteId;
    private String nomeCliente;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;

    public Cliente() {
    }

    public Cliente(Integer clienteId, String nomeCliente, String cep, String endereco,
                   String bairro, String cidade) {
        setClienteId(clienteId);
        setNomeCliente(nomeCliente);
        setCep(cep);
        setEndereco(endereco);
        setBairro(bairro);
        setCidade(cidade);
    }

    public Cliente(String nomeCliente, String cep, String endereco, String bairro,
                   String cidade) {
        setNomeCliente(nomeCliente);
        setCep(cep);
        setEndereco(endereco);
        setBairro(bairro);
        setCidade(cidade);
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
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser nulo ou vazio");
        }
        this.nomeCliente = nomeCliente;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep == null || cep.trim().isEmpty() || !isValidCEP(cep)) {
            throw new IllegalArgumentException("CEP inválido");
        }
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser nulo ou vazio");
        }
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if (bairro == null || bairro.trim().isEmpty()) {
            throw new IllegalArgumentException("Bairro não pode ser nulo ou vazio");
        }
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if (cidade == null || cidade.trim().isEmpty()) {
            throw new IllegalArgumentException("Cidade não pode ser nula ou vazia");
        }
        this.cidade = cidade;
    }

    public String toStringBasico() {
        return "Cliente [Id=" + clienteId + ", nome=" + nomeCliente + "]";
    }

    @Override
    public String toString() {
        return "Cliente [Id=" + clienteId + ", nome=" + nomeCliente + ", cep=" + cep
                + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + "]";
    }

    public String toCSV() {
        return clienteId + ";" + nomeCliente + ";" + cep + ";" + endereco + ";" + bairro + ";" + cidade;
    }

    private boolean isValidCEP(String cep) {
        return cep != null && cep.matches("\\d{5}-\\d{3}");
    }
}
