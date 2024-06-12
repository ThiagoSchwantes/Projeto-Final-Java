package br.edu.up.views.menus.cadastos;

import java.util.List;

import br.edu.up.controllers.ControleDePagamento;
import br.edu.up.models.Pagamento;
import br.edu.up.util.Prompt;

public class MenuPagamento {
    private ControleDePagamento controleDePagamento = new ControleDePagamento();

    public void mostrar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("MENU DE PAGAMENTO");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar pagamento");
        Prompt.imprimir("\t2 - Listar pagamentos");
        Prompt.imprimir("\t3 - Alterar pagamento");
        Prompt.imprimir("\t4 - Deletar pagamento");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");
        Prompt.limparConsole();

        boolean sair = false;
        switch (opcao1) {
            case 1:
                cadastrarPagamento();
                break;
            case 2:
                List<Pagamento> pagamentos = controleDePagamento.getPagamentos();
                if(pagamentos.isEmpty()){
                    Prompt.imprimir("Não há pagamentos cadastrados.");
                }else{
                    for (Pagamento pagamento : pagamentos) {
                        Prompt.imprimir(pagamento.toString());
                    }
                }
                break;
            case 3:
                Integer idAlterar = getId();
                Pagamento pagamentoAlterado = alterarPagamento();
                controleDePagamento.alterarPagamento(idAlterar, pagamentoAlterado);
                break;
            case 4:
                Integer idDeletar = getId();
                controleDePagamento.deletarPagamento(idDeletar);
                break;
            case 5:
                sair = true;
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                break;
        }

        if(!sair){
            Prompt.separador();
            Prompt.pressionarEnter();
            mostrar();
        }
    }

    public Pagamento cadastrarPagamento(){

        Integer pagamentoId = controleDePagamento.getProximoId();
        String nomePagamento = lerNomePagamento();

        Pagamento pagamento = new Pagamento(pagamentoId,nomePagamento);
        controleDePagamento.adicionarPagamento(pagamento);
        
        return pagamento;
    }
    
    public Integer getId(){
        Integer id = Prompt.lerInteiro("Informe o Id: ");
        return id;
    }

    public Pagamento alterarPagamento(){
        
        String nomePagamento = lerNomePagamento();

        Pagamento pagamentoAlterado = new Pagamento(nomePagamento);

        return pagamentoAlterado;
    }

    private String lerNomePagamento() {
        while (true) {
            String nomePagamento = Prompt.lerLinha("Informe o nome do pagamento: ");
            try {
                Pagamento pagamento = new Pagamento();
                pagamento.setNomePagamento(nomePagamento);
                return nomePagamento;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }
}