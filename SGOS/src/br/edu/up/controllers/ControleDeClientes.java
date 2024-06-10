package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.up.models.Cliente;
import br.edu.up.models.ClientePessoa;
import br.edu.up.daos.GerenciadorDeClientesDAO;

public class ControleDeClientes {
    private List<Cliente> clientes;
    private GerenciadorDeClientesDAO dao;
    private int maiorId;

    public ControleDeClientes() {
        dao = new GerenciadorDeClientesDAO();
        try {
            clientes = dao.getClientes();
            maiorId = clientes.stream().mapToInt(Cliente::getClienteId).max().orElse(0);
        } catch (Exception e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
            clientes = new ArrayList<>(); 
            maiorId = 0;
        }
    }

    public int getProximoId() {
        return ++maiorId;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarCliente(Cliente cliente) {
        cliente.setClienteId(getProximoId());
        clientes.add(cliente);
        dao.gravarArquivo();
    }

    public void alterarCliente(int clienteId, Cliente clienteAlterado) {
        for (Cliente cliente : clientes) {
            if (cliente.getClienteId() == clienteId) {
                cliente.setNomeCliente(clienteAlterado.getNomeCliente());
                cliente.setCep(clienteAlterado.getCep());
                cliente.setEndereco(clienteAlterado.getEndereco());
                cliente.setBairro(clienteAlterado.getBairro());
                cliente.setCidade(clienteAlterado.getCidade());
                if (cliente instanceof ClientePessoa) {
                    ((ClientePessoa) cliente).setRg(((ClientePessoa) clienteAlterado).getRg());
                }
                break;
            }
        }
        dao.gravarArquivo();
    }

    public void deletarCliente(int clienteId) {
        clientes.removeIf(cliente -> cliente.getClienteId() == clienteId);
        dao.gravarArquivo();
    }
}
