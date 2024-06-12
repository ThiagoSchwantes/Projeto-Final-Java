package br.edu.up.controllers;

import java.util.List;

import br.edu.up.models.Cliente;
import br.edu.up.models.ClienteEmpresa;
import br.edu.up.models.ClientePessoa;
import br.edu.up.daos.GerenciadorDeClientesDAO;

public class ControleDeClientes {
    private List<Cliente> clientes;
    private GerenciadorDeClientesDAO dao;
    private int maiorId;

    public ControleDeClientes() {
        dao = new GerenciadorDeClientesDAO();
        this.clientes = dao.getClientes();
        this.maiorId = 0;

        for (Cliente cliente : clientes) {
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

    public void adicionarCliente(Cliente cliente) {
        cliente.setClienteId(getProximoId());
        clientes.add(cliente);
        dao.gravarArquivo();
    }
      
     public Cliente buscar(Integer clienteId){
        for (Cliente cliente : clientes) {
            if(cliente.getClienteId() == clienteId){
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscar(String identificacao){
        for (Cliente cliente : clientes) {
            if(cliente instanceof ClientePessoa && ((ClientePessoa)cliente).getCpf().toLowerCase().equals(identificacao.toLowerCase())){
                return cliente;
            }
            else if(cliente instanceof ClienteEmpresa && ((ClienteEmpresa)cliente).getCnpj().toLowerCase().equals(identificacao.toLowerCase())){
                return cliente;
            }
        }
        return null;
    }

    public void alterarCliente(String identificacao, Cliente clienteAlterado){
        for (Cliente cliente : clientes) {
            if(cliente instanceof ClientePessoa && ((ClientePessoa)cliente).getCpf().toLowerCase().equals(identificacao.toLowerCase())){
                cliente.setNomeCliente(clienteAlterado.getNomeCliente());
                cliente.setCep(clienteAlterado.getCep());
                cliente.setEndereco(clienteAlterado.getEndereco());
                cliente.setBairro(clienteAlterado.getBairro());
                cliente.setCidade(clienteAlterado.getCidade());
                ((ClientePessoa)cliente).setCpf(((ClientePessoa)clienteAlterado).getCpf());
                ((ClientePessoa)cliente).setRg(((ClientePessoa)clienteAlterado).getRg());
            }
            else if(cliente instanceof ClienteEmpresa && ((ClienteEmpresa)cliente).getCnpj().toLowerCase().equals(identificacao.toLowerCase())){
                cliente.setNomeCliente(clienteAlterado.getNomeCliente());
                cliente.setCep(clienteAlterado.getCep());
                cliente.setEndereco(clienteAlterado.getEndereco());
                cliente.setBairro(clienteAlterado.getBairro());
                cliente.setCidade(clienteAlterado.getCidade());
                ((ClienteEmpresa)cliente).setCNPJ(((ClienteEmpresa)clienteAlterado).getCnpj());
                ((ClienteEmpresa)cliente).setInscricaoEstadual(((ClienteEmpresa)clienteAlterado).getInscricaoEstadual());
                ((ClienteEmpresa)cliente).setAnoFundacao(((ClienteEmpresa)clienteAlterado).getAnoFundacao());
            }
        }
        dao.gravarArquivo();
    }

    public void deletarCliente(int clienteId) {
        clientes.removeIf(cliente -> cliente.getClienteId() == clienteId);
        dao.gravarArquivo();
    }
}
