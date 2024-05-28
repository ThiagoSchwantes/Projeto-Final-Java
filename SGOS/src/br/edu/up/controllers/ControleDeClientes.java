package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import br.edu.up.models.Cliente;
import br.edu.up.views.ViewCliente;
import br.edu.up.daos.GereciadorDeArquivosDAO;

public class ControleDeClientes {
    private List<Cliente> clientes;
    private GereciadorDeArquivosDAO dao;
    private int maiorId;

    public ControleDeClientes(List<Cliente> clientes) {
        dao = new GereciadorDeArquivosDAO();
        if (clientes == null) {
            this.clientes = new ArrayList<>();
        } else {
            this.clientes = clientes;
        }
        this.clientes = dao.getClientes();
        this.maiorId = 0;

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

    public void alterarCliente(ViewCliente viewCliente){
        String cpf = viewCliente.getCpf();
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
        String cpf = viewCliente.getCpf();
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