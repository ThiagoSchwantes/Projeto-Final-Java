package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.up.models.*;
import br.edu.up.views.ViewAcabamento;
import br.edu.up.daos.*;

public class ControleDeAcabamento {
    private List<Acabamento> acabamentos;
    private GerenciadorDeAcabamentoDAO daoAcabamento;
    private int maiorId;

    public ControleDeAcabamento(List<Acabamento> acabamentos) {
        daoAcabamento = new GerenciadorDeAcabamentoDAO();
        if (acabamentos == null) {
            this.acabamentos = new ArrayList<>();
        } else {
            this.acabamentos = acabamentos;
        }
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

    public void alterarAcabamento(ViewAcabamento viewAcabamento){
        Integer id = viewAcabamento.getId();
        for (Acabamento acabamento : acabamentos) {
            if(acabamento.getAcabamentoId().equals(id)){
                Acabamento acabamentoAlterado = viewAcabamento.alterarAcabamento();
                acabamento.setNomeAcabamento(acabamentoAlterado.getNomeAcabamento());
                acabamento.setDescricao(acabamentoAlterado.getDescricao());
                break;
            }
        }
        daoAcabamento.gravarArquivo();
    }

    public void deletarAcabamento(ViewAcabamento viewAcabamento){
        Integer id = viewAcabamento.getId();
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
