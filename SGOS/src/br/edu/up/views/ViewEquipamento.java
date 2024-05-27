package br.edu.up.views;

import br.edu.up.controllers.ControleDeEquipamento;
import br.edu.up.models.Equipamento;
import br.edu.up.util.Prompt;

public class ViewEquipamento {

    ControleDeEquipamento controleDeEquipamento = new ControleDeEquipamento(null);

    public Equipamento cadastrarEquipamento(){

        Integer equipamentoId = controleDeEquipamento.getProximoId();
        String nomeEquipamento = Prompt.lerLinha("Informe o nome do equipamento: ");
        String descricao = Prompt.lerLinha("Informe a descrição do equipamento: ");

        Equipamento equipamento = new Equipamento(equipamentoId,nomeEquipamento,descricao);
        controleDeEquipamento.adicionarEquipamento(equipamento);
        
        return equipamento;
    }
    
    public Integer getId(){
        Integer id = Prompt.lerInteiro("Informe o Id: ");
        return id;
    }

    public Equipamento alterarEquipamento(){
        
        String nomeEquipamento = Prompt.lerLinha("Informe o nome do equipamento: ");
        String descricao = Prompt.lerLinha("Informe a descrição do equipamento: ");

        Equipamento equipamentoAlterado = new Equipamento(nomeEquipamento,descricao);

        return equipamentoAlterado;
    }
}
