package br.edu.up.models;

public class ClientePessoa extends Cliente {
    private String rg;
    private String cpf;

    public ClientePessoa(){

    }
    public ClientePessoa(Integer clienteId, String nomeCliente, String cep, String endereco, String bairro,
            String cidade) {
        super(clienteId, nomeCliente, cep, endereco, bairro, cidade);
    }

    public ClientePessoa(Integer clienteId, String nomeCliente, String cep, String endereco, String bairro,
            String cidade, String rg, String cpf) {
        super(clienteId, nomeCliente, cep, endereco, bairro, cidade);
        this.rg = rg;
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        if (rg == null || rg.trim().isEmpty() || !isValidRG(rg)) {
            throw new IllegalArgumentException("RG não pode ser nulo ou vazio");
        }
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty() || !isValidCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido. O formato deve ser 123.456.789-00.");
        }
        this.cpf = cpf;
    }

    private boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.length() != 14 || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            return false;
        }
    
        // Remove pontos e hífen
        cpf = cpf.replace(".", "").replace("-", "");
    
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }
    
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

    private boolean isValidRG(String rg) {
        if (rg == null || !rg.matches("\\d{2}\\.\\d{3}\\.\\d{3}-\\d{1}")) {
            return false;
        }
    
        // Remove os pontos e o hífen
        rg = rg.replace(".", "").replace("-", "");
    
        int sum = 0;
        for (int i = 0; i < rg.length() - 1; i++) {
            sum += (rg.charAt(i) - '0') * (rg.length() - i);
        }
    
        int checkDigit = sum % 11;
        if (checkDigit == 10) {
            checkDigit = 'X';
        } else {
            checkDigit += '0'; // Converte para o código ASCII correspondente
        }
    
        return checkDigit == rg.charAt(rg.length() - 1);
    }

    @Override
    public String toString() {
        return "ClientePessoa [rg=" + rg + ", cpf=" + cpf + ", getClienteId()=" + getClienteId() + ", getNomeCliente()="
                + getNomeCliente() + "]";
    }

    @Override
    public String toCSV() {
        return getClienteId() + ";" + getNomeCliente() + ";" + getCep() + ";" + getEndereco() + ";" + getBairro() 
        + ";" + getCidade() + ";;;;" +  rg + ";" + cpf;
    }
}
