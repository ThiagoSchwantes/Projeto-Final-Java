package br.edu.up.views;

import br.edu.up.controllers.ControleDeClientes;
import br.edu.up.models.Cliente;
import br.edu.up.util.Prompt;

public class ViewCliente {
    
    ControleDeClientes controle = new ControleDeClientes(null);

    public Cliente cadastrarCliente(){

        Integer clienteId = controle.getProximoId();
        String nomeCliente = Prompt.lerLinha("Informe o nome do cliente: ");
        String rg = Prompt.lerLinha("Informe o RG do cliente: ");
        String cpf = Prompt.lerLinha("Informe o CPF do cliente: ");
        String cep = Prompt.lerLinha("Informe o CEP do cliente: ");
        String endereco = Prompt.lerLinha("Informe o endereço do cliente: ");
        String bairro = Prompt.lerLinha("Informe o bairro do cliente: ");
        String cidade = Prompt.lerLinha("Informe a cidade do cliente: ");

        Cliente cliente = new Cliente(clienteId, nomeCliente, rg, cpf, cep, endereco, bairro, cidade);
        controle.adicionarCliente(cliente);
        return cliente;
    }

    public String getcpf(){
        String cpf = Prompt.lerLinha("Informe o CPF: ");
        return cpf;
    }

    public Cliente alterarCliente(){
        
        String nomeCliente = Prompt.lerLinha("Informe o nome do cliente: ");
        String rg = Prompt.lerLinha("Informe o RG do cliente: ");
        String cpf = Prompt.lerLinha("Informe o CPF do cliente: ");
        String cep = Prompt.lerLinha("Informe o CEP do cliente: ");
        String endereco = Prompt.lerLinha("Informe o endereço do cliente: ");
        String bairro = Prompt.lerLinha("Informe o bairro do cliente: ");
        String cidade = Prompt.lerLinha("Informe a cidade do cliente: ");

        Cliente clientealterado = new Cliente(nomeCliente, rg, cpf, cep, endereco, bairro, cidade);
        
        return clientealterado;
    }
}
