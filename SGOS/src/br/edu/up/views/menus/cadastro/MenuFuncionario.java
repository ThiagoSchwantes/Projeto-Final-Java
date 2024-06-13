package br.edu.up.views.menus.cadastro;

import java.util.List;

import br.edu.up.controllers.ControleDeFuncionarios;
import br.edu.up.models.Funcionario;
import br.edu.up.util.Prompt;

public class MenuFuncionario {


    ControleDeFuncionarios controleDeFuncionarios = new ControleDeFuncionarios();

    public void mostrar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("MENU DE FUNCIONÁRIO");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar funcionário");
        Prompt.imprimir("\t2 - Listar funcionários");
        Prompt.imprimir("\t3 - Alterar funcionário");
        Prompt.imprimir("\t4 - Deletar funcionário");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");
        boolean sair = false;

        switch (opcao1) {
            case 1:
                cadastrarFuncionario();
                break;
            case 2:
                List<Funcionario> funcionarios = controleDeFuncionarios.getFuncionarios();
                if(funcionarios.isEmpty()){
                    Prompt.imprimir("Não há funcionários cadastrados.");
                }else{
                    for (Funcionario funcionario : funcionarios) {
                        Prompt.imprimir(funcionario.toStringBasico());
                    }
                }
                break;
            case 3:
                String cpfAlterar = getCpf();

                if(controleDeFuncionarios.buscar(cpfAlterar) == null){
                    Prompt.imprimir("cpf digitado inexistente ou invalido!");
                }else{
                    Funcionario funcionarioAlterado = alterarFuncionario();

                    controleDeFuncionarios.alterarFuncionario(cpfAlterar, funcionarioAlterado);
                }
                break;
            case 4:
                String cpfDeletar = getCpf();

                if(controleDeFuncionarios.buscar(cpfDeletar) == null){
                    Prompt.imprimir("cpf digitado inexistente ou invalido!");
                }else{
                    controleDeFuncionarios.deletarFuncionario(cpfDeletar);
                }

                break;
            case 5:
                sair = true;
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                break;
        }
        if(!sair){
            Prompt.separador();
            Prompt.pressionarEnter();
            mostrar();
        }
    }


    public Funcionario cadastrarFuncionario() {
        Integer clienteId = controleDeFuncionarios.getProximoId();
        String nomeCliente = lerNomeFuncionario();
        String rg = lerRg();
        String cpf = lerCpf();
        String cep = lerCep();
        String endereco = lerEndereco();
        String bairro = lerBairro();
        String cidade = lerCidade();

        Funcionario cliente = new Funcionario(clienteId, nomeCliente, rg, cpf, cep, endereco, bairro, cidade);
        controleDeFuncionarios.adicionarFuncionario(cliente);
        return cliente;
    }
    

    private String lerNomeFuncionario() {
        while (true) {
            String nomeFuncionario = Prompt.lerLinha("Informe o nome do funcionário: ");
            try {
                Funcionario funcionario = new Funcionario();
                funcionario.setNomeFuncionario(nomeFuncionario);
                return nomeFuncionario;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerRg() {
        while (true) {
            String rg = Prompt.lerLinha("Informe o RG do funcionario: ");
            try {
                Funcionario funcionario = new Funcionario();
                funcionario.setRg(rg);
                return rg;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerCpf() {
        while (true) {
            String cpf = Prompt.lerLinha("Informe o CPF do funcionario (formato: 123.456.789-00): ");
            try {
                Funcionario funcionario = new Funcionario();
                funcionario.setCpf(cpf);
                return cpf;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerCep() {
        while (true) {
            String cep = Prompt.lerLinha("Informe o CEP do funcionario: ");
            try {
                Funcionario funcionario = new Funcionario();
                funcionario.setCep(cep);
                return cep;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerEndereco() {
        while (true) {
            String endereco = Prompt.lerLinha("Informe o endereço do funcionario: ");
            try {
                Funcionario funcionario = new Funcionario();
                funcionario.setEndereco(endereco);
                return endereco;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerBairro() {
        while (true) {
            String bairro = Prompt.lerLinha("Informe o bairro do funcionario: ");
            try {
                Funcionario funcionario = new Funcionario();
                funcionario.setBairro(bairro);
                return bairro;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerCidade() {
        while (true) {
            String cidade = Prompt.lerLinha("Informe a cidade do funcionario: ");
            try {
                Funcionario funcionario = new Funcionario();
                funcionario.setCidade(cidade);
                return cidade;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }



    public String getCpf() {
        return lerCpf();
    }

    public Funcionario alterarFuncionario() {
        String nomeFuncionario = lerNomeFuncionario();
        String rg = lerRg();
        String cpf = lerCpf();
        String cep = lerCep();
        String endereco = lerEndereco();
        String bairro = lerBairro();
        String cidade = lerCidade();

        Funcionario funcionarioAlterado = new Funcionario(nomeFuncionario, rg, cpf, cep, endereco, bairro, cidade);
        return funcionarioAlterado;
    }

}
