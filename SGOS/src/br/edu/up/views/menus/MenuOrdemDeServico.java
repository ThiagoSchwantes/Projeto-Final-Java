package br.edu.up.views.menus;

import br.edu.up.controllers.ControleDeOrdemDeServico;
import br.edu.up.util.Prompt;

public class MenuOrdemDeServico {
    ControleDeOrdemDeServico controleOS = new ControleDeOrdemDeServico();

    public void mostrar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("MENU DE MOVIMENTAÇÃO DE ORDEM DE SERVIÇO");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar Ordem de Servico");
        Prompt.imprimir("\t2 - Listar Ordem de Servico");
        Prompt.imprimir("\t3 - Alterar Ordem de Servico");
        Prompt.imprimir("\t4 - Deletar Ordem de Servico");
        Prompt.imprimir("\t5 - Voltar para o menu principal");

        int opcao1 = Prompt.lerInteiro("Digite aqui:");
        Prompt.limparConsole();

        boolean sair = false;
        switch (opcao1) {
            case 1:
                cadastrar();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                sair = true;
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }

        if(!sair){
            mostrar();
        }
    }


    public void cadastrar(){
        Prompt.separador();
        Prompt.imprimir("CADASTRAR ORDEM DE SERVIÇO");
        Prompt.separador();
    }
}