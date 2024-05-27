package br.edu.up.views;

import br.edu.up.controllers.ControleDePagamento;
import br.edu.up.models.Pagamento;
import br.edu.up.util.Prompt;

public class ViewPagamento {

    ControleDePagamento controleDePagamento = new ControleDePagamento(null);
    public Pagamento cadastrarPagamento(){

        Integer pagamentoId = controleDePagamento.getProximoId();
        String nomePagamento = Prompt.lerLinha("Informe o nome do pagamento: ");

        Pagamento pagamento = new Pagamento(pagamentoId,nomePagamento);
        controleDePagamento.adicionarPagamento(pagamento);
        
        return pagamento;
    }
    
    public Integer getId(){
        Integer id = Prompt.lerInteiro("Informe o Id: ");
        return id;
    }

    public Pagamento alterarPagamento(){
        
        String nomePagamento = Prompt.lerLinha("Informe o nome do pagamento: ");

        Pagamento pagamentoAlterado = new Pagamento(nomePagamento);

        return pagamentoAlterado;
    }
}
