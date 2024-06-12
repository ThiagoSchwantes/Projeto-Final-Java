package br.edu.up.models;

public class ClienteEmpresa extends Cliente{
    private String cnpj;
    private String inscricaoEstadual;
    private int anoFundacao;
    
    public ClienteEmpresa(Integer clienteId, String nomeCliente, String cep, String endereco, String bairro,
            String cidade) {
        super(clienteId, nomeCliente, cep, endereco, bairro, cidade);
    }

    public ClienteEmpresa(Integer clienteId, String nomeCliente, String cep, String endereco, String bairro,
            String cidade, String cnpj, String inscricaoEstadual, int anoFundacao) {
        super(clienteId, nomeCliente, cep, endereco, bairro, cidade);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.anoFundacao = anoFundacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCNPJ(String cnpj) {
        if (cnpj == null || cnpj.trim().isEmpty() || !isValidCNPJ(cnpj)) {
            throw new IllegalArgumentException("CNPJ inválido. O formato deve ser 00.000.000/0000-00.");
        }
        this.cnpj = cnpj;
    }
    

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    private boolean isValidCNPJ(String cnpj) {
        if (cnpj == null || cnpj.length() != 18 || !cnpj.matches("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")) {
            return false;
        }
    
        // Remove pontos, barra e hífen
        cnpj = cnpj.replace(".", "").replace("/", "").replace("-", "");
    
        if (cnpj.chars().distinct().count() == 1) {
            return false;
        }
    
        int[] weights = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (cnpj.charAt(i) - '0') * weights[i + 1];
        }
    
        int checkDigit1 = 11 - (sum % 11);
        if (checkDigit1 >= 10) {
            checkDigit1 = 0;
        }
    
        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += (cnpj.charAt(i) - '0') * weights[i];
        }
    
        int checkDigit2 = 11 - (sum % 11);
        if (checkDigit2 >= 10) {
            checkDigit2 = 0;
        }
    
        return checkDigit1 == (cnpj.charAt(12) - '0') && checkDigit2 == (cnpj.charAt(13) - '0');
    }
    

    @Override
    public String toString() {
        return "ClienteEmpresa [cnpj=" + cnpj + ", inscricaoEstadual=" + inscricaoEstadual + ", anoFundacao="
                + anoFundacao + ", ClienteId=" + getClienteId() + ", nomeCliente=" + getNomeCliente() + "]";
    }

    @Override
    public String toCSV() {
        return getClienteId() + ";" + getNomeCliente() + ";" + getCep() + ";" + getEndereco() + ";" + getBairro() 
        + ";" + getCidade() + ";" + cnpj + ";" + inscricaoEstadual + ";" + anoFundacao + ";;" ;
    }

    
}
