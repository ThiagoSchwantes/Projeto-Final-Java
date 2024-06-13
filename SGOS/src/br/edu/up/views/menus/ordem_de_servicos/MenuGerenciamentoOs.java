package br.edu.up.views.menus.ordem_de_servicos;

import br.edu.up.controllers.ControleDeOrdemDeServico;
import br.edu.up.models.OrdemDeServico;
import br.edu.up.models.OrdemDeServico.Status;
import br.edu.up.util.Prompt;

public class MenuGerenciamentoOs {
    private OrdemDeServico ordemDeServico;

    public void mostrar(OrdemDeServico os){
        Prompt.limparConsole();
        ordemDeServico = os;

        Prompt.separador();
        Prompt.imprimir("GERENCIAR UMA ORDEM DE SERVIÇO - Selecione");
        Prompt.separador();

        Prompt.imprimir(os.toStringInfoOs());
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Alterar informações");
        Prompt.imprimir("\t2 - Mudar Status");
        Prompt.imprimir("\t3 - Deletar ");
        Prompt.imprimir("\t4 - Voltar para o menu principal");

        int opcao1 = Prompt.lerInteiro("Digite aqui:");
        Prompt.limparConsole();

        boolean sair = false;
        switch (opcao1) {
            case 1:
                MenuDeAlteracaoOs menuDeAlteracaoOs = new MenuDeAlteracaoOs();
                menuDeAlteracaoOs.mostrar(os);
                break;
            case 2:
                mudarStatus();
                break;
            case 3:
                sair = deletar();
                break;
            case 4:
                sair = true;
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }

        if(!sair){
            mostrar(ordemDeServico);
        }
    }

    public void mudarStatus(){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("GERENCIAR UMA ORDEM DE SERVIÇO");
        Prompt.separador();

        if(ordemDeServico.getStatus() == Status.BAIXADA){
            Prompt.limparConsole();

            Prompt.separador();
            Prompt.imprimir("GERENCIAR UMA ORDEM DE SERVIÇO");
            Prompt.separador();

            Prompt.imprimir("A ordem de serviço já foi baixada");
            Prompt.separador();

            Prompt.pressionarEnter();
        }else{
            

            int novoStatus = ordemDeServico.getStatus().ordinal()+1;
            Status[] status = Status.values();
            
            ordemDeServico.setStatus(status[novoStatus]);

            ControleDeOrdemDeServico controleDeOrdemDeServico = new ControleDeOrdemDeServico();
            controleDeOrdemDeServico.alterar(ordemDeServico);

            Prompt.imprimir("Status alterado para: " + status[novoStatus]);
            Prompt.separador();
            Prompt.pressionarEnter();
        }        
    }

    public boolean deletar(){
        boolean excluiu = false;

        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("GERENCIAR UMA ORDEM DE SERVIÇO - Deletar OS");
        Prompt.separador();

        boolean digitouIncorretamente = true;
        Character resposta = 'n';
        do {
            resposta = Prompt.lerCaractere("Tem certeza que deseja excluir (s/n)");
            
            if(Character.toLowerCase(resposta) == 's' || Character.toLowerCase(resposta) == 'n'){
                digitouIncorretamente = false;
            }else{
                Prompt.separador();
                Prompt.imprimir("Digite corretamente (s/n)!!!");
                Prompt.separador();
                Prompt.pressionarEnter();

                Prompt.limparConsole();
                Prompt.separador();
                Prompt.imprimir("GERENCIAR UMA ORDEM DE SERVIÇO - Deletar OS");
                Prompt.separador();
            }
        } while (digitouIncorretamente);
        
        if (Character.toLowerCase(resposta) == 's') {
            ControleDeOrdemDeServico controleDeOrdemDeServico = new ControleDeOrdemDeServico();
            controleDeOrdemDeServico.deletar(ordemDeServico.getCodigo());

            Prompt.limparConsole();
            Prompt.imprimir("Ordem de Serviço foi deletada!");
            Prompt.imprimir("Voltando para o menu de Ordens de Serviço...");
            Prompt.separador();
            Prompt.pressionarEnter();
            excluiu = true;

        }else if(Character.toLowerCase(resposta) == 'n'){
            Prompt.limparConsole();
            Prompt.imprimir("Ordem de Serviço NÃO foi deletada!");
            Prompt.separador();
            Prompt.pressionarEnter();
        }

        return excluiu;
    }
}
