package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.up.models.Equipamento;
import br.edu.up.views.ViewEquipamento;
import br.edu.up.daos.*;

public class ControleDeEquipamento {
    private List<Equipamento> equipamentos;
    private GerenciadorDeEquipamentoDAO daoEquipamento;
    private int maiorId;

    public ControleDeEquipamento(List<Equipamento> equipamentos) {
        daoEquipamento = new GerenciadorDeEquipamentoDAO();
        if (equipamentos == null) {
            this.equipamentos = new ArrayList<>();
        } else {
            this.equipamentos = equipamentos;
        }
        this.equipamentos = daoEquipamento.getEquipamentos();
        this.maiorId = 0;

        for (Equipamento equipamento : this.equipamentos) {
            if (equipamento.getEquipamentoId() > maiorId) {
                maiorId = equipamento.getEquipamentoId();
            }
        }
    }

    public int getProximoId() {
        return ++maiorId;
    }

    public void adicionarEquipamento(Equipamento equipamento){
        equipamentos.add(equipamento);
        daoEquipamento.gravarArquivo();
    }

    public void alterarEquipamento(ViewEquipamento viewEquipamento){
        Integer id = viewEquipamento.getId();
        for (Equipamento equipamento : equipamentos) {
            if(equipamento.getEquipamentoId().equals(id)){
                Equipamento equipamentoAlterado = viewEquipamento.alterarEquipamento();
                equipamento.setNomeEquipamento(equipamentoAlterado.getNomeEquipamento());
                equipamento.setDescricao(equipamentoAlterado.getDescricao());
                break;
            }
        }
        daoEquipamento.gravarArquivo();
    }

    public void deletarEquipamento(ViewEquipamento viewEquipamento){
        Integer id = viewEquipamento.getId();
        Iterator<Equipamento> iterator = equipamentos.iterator();
        while (iterator.hasNext()) {
            Equipamento equipamento = iterator.next();
            if (equipamento.getEquipamentoId().equals(id)) {
                iterator.remove();
                break;
            }
        }
        daoEquipamento.gravarArquivo();
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }
    
}
