package br.edu.up.models;

public class Funcionario {

    private Integer funcionarioId;
    private String nomeFuncionario;
    private String rg;
    private String cpf;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;

    public Integer getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        if (nomeFuncionario == null || nomeFuncionario.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do funcionário não pode ser nulo ou vazio");
        }
        this.nomeFuncionario = nomeFuncionario;
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
            throw new IllegalArgumentException("CPF inválido. O formato deve ser 123.456.789-00.");
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

    public Funcionario(Integer funcionarioId, String nomeFuncionario, String rg, String cpf, String cep,
                       String endereco, String bairro, String cidade) {
        setFuncionarioId(funcionarioId);
        setNomeFuncionario(nomeFuncionario);
        setRg(rg);
        setCpf(cpf);
        setCep(cep);
        setEndereco(endereco);
        setBairro(bairro);
        setCidade(cidade);
    }

    public Funcionario(String nomeFuncionario, String rg, String cpf, String cep,
                       String endereco, String bairro, String cidade) {
        setNomeFuncionario(nomeFuncionario);
        setRg(rg);
        setCpf(cpf);
        setCep(cep);
        setEndereco(endereco);
        setBairro(bairro);
        setCidade(cidade);
    }

    public Funcionario() {
    }

    public String toStringBasico() {
        return "Funcionário [Id=" + funcionarioId + ", nome=" + nomeFuncionario + "]";
    }

    @Override
    public String toString() {
        return "Funcionário [Id=" + funcionarioId + ", nome=" + nomeFuncionario + ", rg=" + rg + ", cpf=" + cpf + ", cep=" + cep
                + ", endereco=" + endereco + ", bairro=" + bairro + ", cidade=" + cidade + "]";
    }

    public String toCSV() {
        return funcionarioId + ";" + nomeFuncionario + ";" + rg + ";" + cpf + ";" + cep + ";" + endereco + ";" + bairro + ";" + cidade;
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

    private boolean isValidCEP(String cep) {
        return cep != null && cep.matches("\\d{5}-\\d{3}");
    }
}