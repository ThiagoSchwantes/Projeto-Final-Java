package br.edu.up.controllers;

import java.util.Iterator;
import java.util.List;

import br.edu.up.models.Equipamento;
import br.edu.up.daos.*;

public class ControleDeEquipamento {
    private List<Equipamento> equipamentos;
    private GerenciadorDeEquipamentoDAO daoEquipamento;
    private int maiorId;

    public ControleDeEquipamento() {
        daoEquipamento = new GerenciadorDeEquipamentoDAO();
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

    public String listar(){
        String lista = "";
        int contador = 1;

        for (Equipamento equipamento : equipamentos) {
            if(equipamentos.indexOf(equipamento) == 0){
                lista = contador + " - " + equipamento.toString();
            }else{
                lista += "\n\n" + contador + " - " +equipamento.toString();
            }
            
            contador++;
        }

        return lista;
    }

    public Equipamento buscar(Integer equipamentoId){
        for (Equipamento equipamento : equipamentos) {
            if(equipamento.getEquipamentoId() == equipamentoId){
                return equipamento;
            }
        }
        return null;
    }

    public Equipamento buscar(String nome){
        for (Equipamento equipamento : equipamentos) {
            if(equipamento.getNomeEquipamento().toLowerCase().equals(nome.toLowerCase())){
                return equipamento;
            }
        }
        return null;
    }

    public void alterarEquipamento(Integer id, Equipamento equipamentoAlterado){
        for (Equipamento equipamento : equipamentos) {
            if(equipamento.getEquipamentoId().equals(id)){
                equipamento.setNomeEquipamento(equipamentoAlterado.getNomeEquipamento());
                equipamento.setDescricao(equipamentoAlterado.getDescricao());
                break;
            }
        }
        daoEquipamento.gravarArquivo();
    }

    public void deletarEquipamento(Integer id){
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

    public GerenciadorDeEquipamentoDAO getDaoEquipamento() {
        return daoEquipamento;
    }

    public void setDaoEquipamento(GerenciadorDeEquipamentoDAO daoEquipamento) {
        this.daoEquipamento = daoEquipamento;
    }

    public int getMaiorId() {
        return maiorId;
    }

    public void setMaiorId(int maiorId) {
        this.maiorId = maiorId;
    }


    
    
}
