package br.edu.up.views.menus.cadastos;

import java.util.List;

import br.edu.up.controllers.ControleDeClientes;
import br.edu.up.models.Cliente;
import br.edu.up.util.Prompt;

public class MenuCliente {
    private ControleDeClientes controleDeClientes = new ControleDeClientes();

    public void mostrar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("MENU DE CLIENTE");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar cliente");
        Prompt.imprimir("\t2 - Listar clientes");
        Prompt.imprimir("\t3 - Alterar cliente");
        Prompt.imprimir("\t4 - Deletar cliente");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");
        boolean sair = false;

        switch (opcao1) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                List<Cliente> clientes = controleDeClientes.getClientes();
                if(clientes.isEmpty()){
                    Prompt.imprimir("Não há clientes cadastrados.");
                }else{
                    for (Cliente cliente : clientes) {
                        Prompt.imprimir(cliente.toStringBasico());
                    }
                }
                break;
            case 3:
                String cpfAlterar = getCpf();
                Cliente clienteAlterado = alterarCliente();

                controleDeClientes.alterarCliente(cpfAlterar, clienteAlterado);
                break;
            case 4:
                String cpfDeletar = getCpf();

                controleDeClientes.deletarCliente(cpfDeletar);
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

    public Cliente cadastrarCliente() {
        Integer clienteId = controleDeClientes.getProximoId();
        String nomeCliente = lerNomeCliente();
        String rg = lerRg();
        String cpf = lerCpf();
        String cep = lerCep();
        String endereco = lerEndereco();
        String bairro = lerBairro();
        String cidade = lerCidade();

        Cliente cliente = new Cliente(clienteId, nomeCliente, rg, cpf, cep, endereco, bairro, cidade);
        controleDeClientes.adicionarCliente(cliente);
        return cliente;
    }

    public String getCpf() {
        return lerCpf();
    }

    public Cliente alterarCliente() {
        String nomeCliente = lerNomeCliente();
        String rg = lerRg();
        String cpf = lerCpf();
        String cep = lerCep();
        String endereco = lerEndereco();
        String bairro = lerBairro();
        String cidade = lerCidade();

        Cliente clienteAlterado = new Cliente(nomeCliente, rg, cpf, cep, endereco, bairro, cidade);
        return clienteAlterado;
    }

    private String lerNomeCliente() {
        while (true) {
            String nomeCliente = Prompt.lerLinha("Informe o nome do cliente: ");
            try {
                Cliente cliente = new Cliente();
                cliente.setNomeCliente(nomeCliente);
                return nomeCliente;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerRg() {
        while (true) {
            String rg = Prompt.lerLinha("Informe o RG do cliente: ");
            try {
                Cliente cliente = new Cliente();
                cliente.setRg(rg);
                return rg;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerCpf() {
        while (true) {
            String cpf = Prompt.lerLinha("Informe o CPF do cliente (formato: 123.456.789-00): ");
            try {
                Cliente cliente = new Cliente();
                cliente.setCpf(cpf);
                return cpf;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerCep() {
        while (true) {
            String cep = Prompt.lerLinha("Informe o CEP do cliente: ");
            try {
                Cliente cliente = new Cliente();
                cliente.setCep(cep);
                return cep;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerEndereco() {
        while (true) {
            String endereco = Prompt.lerLinha("Informe o endereço do cliente: ");
            try {
                Cliente cliente = new Cliente();
                cliente.setEndereco(endereco);
                return endereco;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerBairro() {
        while (true) {
            String bairro = Prompt.lerLinha("Informe o bairro do cliente: ");
            try {
                Cliente cliente = new Cliente();
                cliente.setBairro(bairro);
                return bairro;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerCidade() {
        while (true) {
            String cidade = Prompt.lerLinha("Informe a cidade do cliente: ");
            try {
                Cliente cliente = new Cliente();
                cliente.setCidade(cidade);
                return cidade;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }
}
