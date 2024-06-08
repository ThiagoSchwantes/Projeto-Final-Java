package br.edu.up.controllers;

import java.util.Iterator;
import java.util.List;
import br.edu.up.models.*;
import br.edu.up.daos.*;

public class ControleDeAcabamento {
    private List<Acabamento> acabamentos;
    private GerenciadorDeAcabamentoDAO daoAcabamento;
    private int maiorId;

    public ControleDeAcabamento() {
        daoAcabamento = new GerenciadorDeAcabamentoDAO();

        this.acabamentos = daoAcabamento.getAcabamentos();
        this.maiorId = 0;

        for (Acabamento acabamento : this.acabamentos) {
            if (acabamento.getAcabamentoId() > maiorId) {
                maiorId = acabamento.getAcabamentoId();
            }
        }
    }

    public int getProximoId() {
        return ++maiorId;
    }

    public void adicionarAcabamento(Acabamento acabamento){
        acabamentos.add(acabamento);
        daoAcabamento.gravarArquivo();
    }

    public Acabamento buscar(Integer acabamentoId){
        for (Acabamento acabamento : acabamentos) {
            if(acabamento.getAcabamentoId() == acabamentoId){
                return acabamento;
            }
        }
        return null;
    }

    public String listar(){
        String lista = "";
        int contador = 1;

        for (Acabamento acabamento : acabamentos) {
            if(acabamentos.indexOf(acabamento) == 0){
                lista = contador + " - " + acabamento.toString();
            }else{
                lista += "\n\n" + contador + " - " +acabamento.toString();
            }
            
            contador++;
        }

        return lista;
    }

    public Acabamento buscar(String nome){
        for (Acabamento acabamento : acabamentos) {
            if(acabamento.getNomeAcabamento().toLowerCase().equals(nome.toLowerCase())){
                return acabamento;
            }
        }
        return null;
    }

    public void alterarAcabamento(Integer id, Acabamento acabamentoAlterado){
        for (Acabamento acabamento : acabamentos) {
            if(acabamento.getAcabamentoId().equals(id)){
                acabamento.setNomeAcabamento(acabamentoAlterado.getNomeAcabamento());
                acabamento.setDescricao(acabamentoAlterado.getDescricao());
                break;
            }
        }
        daoAcabamento.gravarArquivo();
    }

    public void deletarAcabamento(Integer id){
        Iterator<Acabamento> iterator = acabamentos.iterator();
        while (iterator.hasNext()) {
            Acabamento acabamento = iterator.next();
            if (acabamento.getAcabamentoId().equals(id)) {
                iterator.remove();
                break;
            }
        }
        daoAcabamento.gravarArquivo();
    }

    public List<Acabamento> getAcabamentos() {
        return acabamentos;
    }

    public void setAcabamentos(List<Acabamento> acabamentos) {
        this.acabamentos = acabamentos;
    }
}