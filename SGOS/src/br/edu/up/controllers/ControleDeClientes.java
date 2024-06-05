package br.edu.up.controllers;

import java.util.Iterator;
import java.util.List;
import br.edu.up.models.Cliente;
import br.edu.up.daos.GerenciadorDeClientesDAO;

public class ControleDeClientes {
    private List<Cliente> clientes;
    private GerenciadorDeClientesDAO dao;
    private int maiorId;

    public ControleDeClientes() {
        dao = new GerenciadorDeClientesDAO();
        clientes = dao.getClientes();
        maiorId = 0;

        for (Cliente cliente : this.clientes) {
            if (cliente.getClienteId() > maiorId) {
                maiorId = cliente.getClienteId();
            }
        }
    }

    public int getProximoId() {
        return ++maiorId;
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

    public void alterarCliente(String cpf, Cliente clienteAlterado){
        for (Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)){
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

    public void deletarCliente(String cpf){
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getCpf().equals(cpf)) {
                iterator.remove();
                break;
            }
        }
        dao.gravarArquivo();
    }
}