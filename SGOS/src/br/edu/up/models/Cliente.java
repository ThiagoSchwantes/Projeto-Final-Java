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

    public Cliente() {
    }

    public Cliente(Integer clienteId, String nomeCliente, String rg, String cpf, String cep, String endereco,
                   String bairro, String cidade) {
        setClienteId(clienteId);
        setNomeCliente(nomeCliente);
        setRg(rg);
        setCpf(cpf);
        setCep(cep);
        setEndereco(endereco);
        setBairro(bairro);
        setCidade(cidade);
    }

    public Cliente(String nomeCliente, String rg, String cpf, String cep, String endereco, String bairro,
                   String cidade) {
        setNomeCliente(nomeCliente);
        setRg(rg);
        setCpf(cpf);
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        if (rg == null || rg.trim().isEmpty()) {
            throw new IllegalArgumentException("RG não pode ser nulo ou vazio");
        }
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty() || !isValidCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.cpf = cpf;
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
        return "Cliente [Id=" + clienteId + ", nome=" + nomeCliente + ", rg=" + rg + ", cpf=" + cpf + ", cep=" + cep
                + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + "]";
    }

    public String toCSV() {
        return clienteId + ";" + nomeCliente + ";" + rg + ";" + cpf + ";" + cep + ";" + endereco + ";" + bairro + ";" + cidade;
    }

    // Validação de CPF
    private boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        // Cálculo do dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }

        int checkDigit1 = 11 - (sum % 11);
        if (checkDigit1 >= 10) {
            checkDigit1 = 0;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }

        int checkDigit2 = 11 - (sum % 11);
        if (checkDigit2 >= 10) {
            checkDigit2 = 0;
        }

        return checkDigit1 == (cpf.charAt(9) - '0') && checkDigit2 == (cpf.charAt(10) - '0');
    }

    // Validação de CEP
    private boolean isValidCEP(String cep) {
        return cep != null && cep.matches("\\d{5}-\\d{3}");
    }
}
