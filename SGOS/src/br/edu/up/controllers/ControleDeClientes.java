package br.edu.up.controllers;

import java.util.List;
import br.edu.up.models.Cliente;
import br.edu.up.views.ViewCliente;
import br.edu.up.daos.GereciadorDeArquivosDAO;

public class ControleDeClientes {
    private List<Cliente> clientes;
    private GereciadorDeArquivosDAO dao;

    public ControleDeClientes(List<Cliente> clientes) {
        dao = new GereciadorDeArquivosDAO();
        this.clientes = dao.getClientes();
    }
    public int getProximoId() {
        return this.clientes.size() + 1;
    }
    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
        dao.gravarArquivo();
    }

    public void alterarCliente(ViewCliente viewCliente){
        String cpf = viewCliente.getcpf();
        for (Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)){
                Cliente clienteAlterado = viewCliente.alterarCliente();
                cliente.setNomeCliente(clienteAlterado.getNomeCliente());
                cliente.setRg(clienteAlterado.getRg());
                cliente.setCep(clienteAlterado.getCep());
                cliente.setEndereco(clienteAlterado.getEndereco());
                cliente.setBairro(clienteAlterado.getBairro());
                cliente.setCidade(clienteAlterado.getCidade());
                break;
            }
        }
        dao.gravarArquivo();
    }

    public void deletarCliente(ViewCliente viewCliente){
        String cpf = viewCliente.getcpf();
        for (Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)){
                clientes.remove(cliente);
            }
        }
        dao.gravarArquivo();
    }
}
