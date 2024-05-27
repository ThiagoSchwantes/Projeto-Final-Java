package br.edu.up.views;

import br.edu.up.util.Prompt;
import br.edu.up.models.*;
import br.edu.up.controllers.*;

public class ViewAcabamento {
    ControleDeAcabamento controleDeAcabamento = new ControleDeAcabamento(null);

    public Acabamento cadastrarAcabamento(){

        Integer acabamentoId = controleDeAcabamento.getProximoId();
        String nomeAcabamento = Prompt.lerLinha("Informe o nome do acabamento: ");
        String descricao = Prompt.lerLinha("Informe a descrição do acabamento: ");
        
        Acabamento acabamento = new Acabamento(acabamentoId,nomeAcabamento,descricao);
        controleDeAcabamento.adicionarAcabamento(acabamento);
        
        return acabamento;
    }
    
    public Integer getId(){
        Integer id = Prompt.lerInteiro("Informe o Id: ");
        return id;
    }

    public Acabamento alterarAcabamento(){
        
        String nomeAcabamento = Prompt.lerLinha("Informe o nome do acabamento: ");
        String descricao = Prompt.lerLinha("Informe a descrição do acabamento: ");

        Acabamento acabamentoAlterado = new Acabamento(nomeAcabamento,descricao);

        return acabamentoAlterado;
    }
}
