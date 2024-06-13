package br.edu.up.views.menus.cadastro;

import java.util.List;

import br.edu.up.controllers.ControleDeClientes;
import br.edu.up.models.Cliente;
import br.edu.up.models.ClienteEmpresa;
import br.edu.up.models.ClientePessoa;
import br.edu.up.util.Prompt;

public class MenuCliente {
    private ControleDeClientes controleDeClientes = new ControleDeClientes();

    public void mostrar() {
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("MENU DE CLIENTE");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar cliente Pessoa");
        Prompt.imprimir("\t2 - Cadastrar cliente Empresa");
        Prompt.imprimir("\t3 - Listar clientes");
        Prompt.imprimir("\t4 - Alterar cliente");
        Prompt.imprimir("\t5 - Deletar cliente");
        Prompt.imprimir("\t6 - Voltar para o menu de cadastro");

        int opcao = Prompt.lerInteiro("Digite aqui: ");
        boolean sair = false;

        switch (opcao) {
            case 1:
                cadastrarClientePessoa();
                break;
            case 2:
                cadastrarClienteEmpresa();
                break;
            case 3:
                listarClientes();
                break;
            case 4:
                alterarCliente();
                break;
            case 5:
                deletarCliente();
                break;
            case 6:
                sair = true;
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                break;
        }
        if (!sair) {
            Prompt.separador();
            Prompt.pressionarEnter();
            mostrar();
        }
    }

    private void cadastrarClientePessoa() {
        String nomeCliente = lerNomeCliente();
        String rg = lerRg();
        String cpf = lerCpf();
        String cep = lerCep();
        String endereco = lerEndereco();
        String bairro = lerBairro();
        String cidade = lerCidade();

        ClientePessoa cliente = new ClientePessoa(null, nomeCliente, cep, endereco, bairro, cidade, rg, cpf);
        controleDeClientes.adicionarCliente(cliente);
    }

    private void cadastrarClienteEmpresa() {
        String nomeCliente = lerNomeCliente();
        String cnpj = lerCnpj();
        String inscricaoEstadual = lerInscricaoEstadual();
        int anoFundacao = lerAnoFundacao();
        String cep = lerCep();
        String endereco = lerEndereco();
        String bairro = lerBairro();
        String cidade = lerCidade();

        ClienteEmpresa cliente = new ClienteEmpresa(null, nomeCliente, cep, endereco, bairro, cidade, cnpj, inscricaoEstadual, anoFundacao);
        controleDeClientes.adicionarCliente(cliente);
    }

    private void listarClientes() {
        List<Cliente> clientes = controleDeClientes.getClientes();
        if (clientes.isEmpty()) {
            Prompt.imprimir("Não há clientes cadastrados.");
        } else {
            for (Cliente cliente : clientes) {
                Prompt.imprimir(cliente.toStringBasico());
            }
        }
    }

    private void alterarCliente() {
        String identificacao = Prompt.lerLinha("Informe o cpf ou cnpj do cliente: ");
        if(identificacao.length() == 14){
            ClientePessoa clienteExistente = null;

            for (Cliente cliente : controleDeClientes.getClientes()) {
                if(cliente instanceof ClientePessoa){
                    if (((ClientePessoa)cliente).getCpf().equals(identificacao)) {
                        clienteExistente = (ClientePessoa) cliente;
                    }
                }
            }

            if (clienteExistente == null) {
                Prompt.imprimir("Cliente não encontrado.");
                return;
            }else{
                Integer clienteId = clienteExistente.getClienteId();
                String nomeCliente = lerNomeCliente();
                String cep = lerCep();
                String endereco = lerEndereco();
                String bairro = lerBairro();
                String cidade = lerCidade();
                String rg = lerRg();
                String cpf = lerCpf();

                ClientePessoa clienteAlterado = new ClientePessoa(clienteId, nomeCliente, cep, endereco, bairro, cidade, rg, cpf);
                controleDeClientes.alterarCliente(identificacao, clienteAlterado);
            }

        }else if(identificacao.length() == 18){
            ClienteEmpresa clienteExistente = null;

            for (Cliente cliente : controleDeClientes.getClientes()) {
                if(cliente instanceof ClienteEmpresa && ((ClienteEmpresa)cliente).getCnpj().equals(identificacao)){
                    clienteExistente = (ClienteEmpresa) cliente;
                }
            }

            if (clienteExistente == null) {
                Prompt.imprimir("Cliente não encontrado.");
                return;
            }else{
                Integer clienteId = clienteExistente.getClienteId();
                String nomeCliente = lerNomeCliente();
                String cep = lerCep();
                String endereco = lerEndereco();
                String bairro = lerBairro();
                String cidade = lerCidade();
                String cnpj = lerCnpj();
                String inscricaoEstadual = lerInscricaoEstadual();
                int anoFundacao = lerAnoFundacao();
                
                ClienteEmpresa clienteAlterado = new ClienteEmpresa(clienteId, nomeCliente, cep, endereco, bairro, cidade, cnpj, inscricaoEstadual, anoFundacao);
                controleDeClientes.alterarCliente(identificacao, clienteAlterado);
            }
        }else{
            Prompt.imprimir("Cnpj ou cpf digitado inexistente!");
        }       
    }

    private void deletarCliente() {
        String identificacao = Prompt.lerLinha("Informe o cpf ou cnpj do cliente que deseja excluir: ");

        if(identificacao.length() == 14){
            ClientePessoa clienteExistente = null;
            boolean achou = false;

            for (Cliente cliente : controleDeClientes.getClientes()) {
                if(cliente instanceof ClientePessoa){
                    if (((ClientePessoa)cliente).getCpf().equals(identificacao)) {
                        clienteExistente = (ClientePessoa) cliente;
                        controleDeClientes.deletarCliente(clienteExistente.getClienteId());
                        achou = true;
                        break;
                    }
                }
            }

            if(!achou){
                Prompt.imprimir("CPF digitado invalido!");
            }

        }else if(identificacao.length() == 18){
            ClienteEmpresa clienteExistente = null;
            boolean achou = false;

            for (Cliente cliente : controleDeClientes.getClientes()) {
                if(cliente instanceof ClienteEmpresa){
                    if(((ClienteEmpresa)cliente).getCnpj().equals(identificacao)){
                        clienteExistente = (ClienteEmpresa) cliente;
                        controleDeClientes.deletarCliente(clienteExistente.getClienteId());
                        achou = true;
                        break;
                    }
                }
            }

            if(!achou){
                Prompt.imprimir("CNPJ digitado invalido!");
            }

        }else{
            Prompt.imprimir("Cnpj ou cpf digitado inexistente!");
        }            
    }

    private String lerNomeCliente() {
        while (true) {
            String nomeCliente = Prompt.lerLinha("Informe o nome do cliente: ");
            if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
                Prompt.imprimir("Nome do cliente não pode ser nulo ou vazio.");
            } else {
                return nomeCliente;
            }
        }
    }
    private String lerRg() {
        while (true) {
            String rg = Prompt.lerLinha("Informe o RG do cliente: ");
            try {
                ClientePessoa cliente = new ClientePessoa();
                cliente.setRg(rg);
                return rg;
            } catch (IllegalArgumentException g) {
                Prompt.imprimir(g.getMessage());
            }
        }
    }


    private String lerCpf() {
        while (true) {
            String cpf = Prompt.lerLinha("Informe o CPF do cliente (formato: 123.456.789-00): ");
            try {
                ClientePessoa cliente = new ClientePessoa();
                cliente.setCpf(cpf);
                return cpf;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerCnpj() {
        while (true) {
            String cnpj = Prompt.lerLinha("Informe o CNPJ do cliente (formato: 00.000.000/0000-00): ");
            try {
                ClienteEmpresa cliente = new ClienteEmpresa();
                cliente.setCNPJ(cnpj);
                return cnpj;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }

    private String lerInscricaoEstadual() {
        return Prompt.lerLinha("Informe a inscrição estadual do cliente: ");
    }

    private int lerAnoFundacao() {
        return Prompt.lerInteiro("Informe o ano de fundação do cliente: ");
    }

    private String lerCep() {
        while (true) {
            String cep = Prompt.lerLinha("Informe o CEP do cliente: ");
            try {
                Cliente cliente = new ClientePessoa();
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
            if (endereco == null || endereco.trim().isEmpty()) {
                Prompt.imprimir("Endereço não pode ser nulo ou vazio.");
            } else {
                return endereco;
            }
        }
    }

    private String lerBairro() {
        while (true) {
            String bairro = Prompt.lerLinha("Informe o bairro do cliente: ");
            if (bairro == null || bairro.trim().isEmpty()) {
                Prompt.imprimir("Bairro não pode ser nulo ou vazio.");
            } else {
                return bairro;
            }
        }
    }

    private String lerCidade() {
        while (true) {
            String cidade = Prompt.lerLinha("Informe a cidade do cliente: ");
            if (cidade == null || cidade.trim().isEmpty()) {
                Prompt.imprimir("Cidade não pode ser nula ou vazia.");
            } else {
                return cidade;
            }
        }
    }
}
