package br.edu.up.views.menus;

import br.edu.up.controllers.ControleDeOrdemDeServico;
import br.edu.up.util.Prompt;
import br.edu.up.views.menus.ordem_de_servicos.MenuDeCadastroOS;

public class MenuOrdemDeServico {
    
    private ControleDeOrdemDeServico controleOS = new ControleDeOrdemDeServico();
    
    MenuDeCadastroOS menuDeCadastroOS = new MenuDeCadastroOS();

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
                menuDeCadastroOS.mostrar();
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
}