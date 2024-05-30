package br.edu.up.views;

import br.edu.up.controllers.ControleDeClientes;
import br.edu.up.models.Cliente;
import br.edu.up.util.Prompt;

public class ViewCliente {
    
    ControleDeClientes controle = new ControleDeClientes(null);

    public Cliente cadastrarCliente() {
        Integer clienteId = controle.getProximoId();
        String nomeCliente = lerNomeCliente();
        String rg = lerRg();
        String cpf = lerCpf();
        String cep = lerCep();
        String endereco = lerEndereco();
        String bairro = lerBairro();
        String cidade = lerCidade();

        Cliente cliente = new Cliente(clienteId, nomeCliente, rg, cpf, cep, endereco, bairro, cidade);
        controle.adicionarCliente(cliente);
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
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
            }
        }
    }
}
