package br.edu.up.controllers;

import java.util.Iterator;
import java.util.List;

import br.edu.up.models.Funcionario;
import br.edu.up.daos.GerenciadorDeFuncionariosDAO;

public class ControleDeFuncionarios {

    private List<Funcionario> funcionarios;
    private GerenciadorDeFuncionariosDAO daoFuncionario;
    private int maiorId;

    public ControleDeFuncionarios() {
        daoFuncionario = new GerenciadorDeFuncionariosDAO();
        funcionarios = daoFuncionario.getFuncionarios();
        maiorId = 0;

        for(Funcionario funcionario : this.funcionarios) {
            if (funcionario.getFuncionarioId() > maiorId) {
                maiorId = funcionario.getFuncionarioId();
            }
        }

    }

    public int getProximoId() {
        return ++maiorId;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> Funcionarios) {
        this.funcionarios = Funcionarios;
    }

     public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        daoFuncionario.gravarArquivo();
    }

    public Funcionario buscar(String cpf){
        for (Funcionario funcionario : funcionarios) {
            if(funcionario.getCpf().equals(cpf)){
                return funcionario;
            }
        }
        return null;
    }

    public Funcionario buscar(Integer index){
        for (Funcionario funcionario : funcionarios) {
            if(funcionario.getFuncionarioId() == index){
                return funcionario;
            }
        }
        return null;
    }

    public void deletarFuncionario(String cpf) {
        Iterator<Funcionario> iterator = funcionarios.iterator();

        while(iterator.hasNext()){
            Funcionario funcionario = iterator.next();
            if(funcionario instanceof Funcionario){
                Funcionario funcionarioG = (Funcionario) funcionario;
                if(funcionarioG.getCpf().equals(cpf)){
                    iterator.remove();
                    break;
                }
            }
        }
        daoFuncionario.gravarArquivo();


    }


    public void alterarFuncionario(String cpf, Funcionario funcionarioAlterado) {
        for (Funcionario funcionario : funcionarios) {
            if(funcionario.getCpf().equals(cpf)){
                funcionario.setNomeFuncionario(funcionarioAlterado.getNomeFuncionario());
                funcionario.setRg(funcionarioAlterado.getRg());
                funcionario.setCep(funcionarioAlterado.getCep());
                funcionario.setEndereco(funcionarioAlterado.getEndereco());
                funcionario.setBairro(funcionarioAlterado.getBairro());
                funcionario.setCidade(funcionarioAlterado.getCidade());
                break;
            }
        }
        daoFuncionario.gravarArquivo();
    }


    
}

