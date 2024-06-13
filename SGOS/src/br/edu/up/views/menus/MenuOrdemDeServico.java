package br.edu.up.views.menus;

import br.edu.up.controllers.ControleDeOrdemDeServico;
import br.edu.up.models.OrdemDeServico;
import br.edu.up.util.Prompt;
import br.edu.up.views.menus.ordem_de_servicos.MenuDeCadastroOS;
import br.edu.up.views.menus.ordem_de_servicos.MenuGerenciamentoOs;

public class MenuOrdemDeServico {
    
    MenuDeCadastroOS menuDeCadastroOS = new MenuDeCadastroOS();

    public void mostrar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("MENU DE MOVIMENTAÇÃO DE ORDEM DE SERVIÇO");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar Ordem de Servico");
        Prompt.imprimir("\t2 - Listar Ordem de Servico");
        Prompt.imprimir("\t3 - Gerenciar uma ordem de Serviço");
        Prompt.imprimir("\t4 - Voltar para o menu principal");

        int opcao1 = Prompt.lerInteiro("Digite aqui:");
        Prompt.limparConsole();

        boolean sair = false;
        switch (opcao1) {
            case 1:
                menuDeCadastroOS.mostrar();
                break;
            case 2:
                listar();
                break;
            case 3:
                gerenciar();
                break;
            case 4:
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

    public void listar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("LISTAGEM DE ORDENS DE SERVIÇOS");
        Prompt.separador();

        ControleDeOrdemDeServico controleOS = new ControleDeOrdemDeServico();
        Prompt.imprimir(controleOS.listar());
        Prompt.pressionarEnter();
    }

    public void gerenciar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("GERENCIAR UMA ORDEM DE SERVIÇO - Selecione");
        Prompt.separador();

        ControleDeOrdemDeServico controleOS = new ControleDeOrdemDeServico();
        Prompt.imprimir(controleOS.listar());
        
        Integer opcao = Prompt.lerInteiro("Digite o número da OS que deseja gerenciar:");

        OrdemDeServico ordemDeServico = controleOS.buscarIndex(opcao); 

        if(ordemDeServico == null){
            Prompt.limparConsole();
            Prompt.imprimir("Nenhuma ordem de serviço encontrada com esse número!");
            Prompt.separador();
            Prompt.pressionarEnter();
        }else{
            Prompt.limparConsole();
            MenuGerenciamentoOs menuGerenciamentoOs = new MenuGerenciamentoOs();
            menuGerenciamentoOs.mostrar(ordemDeServico);
        }
    }
}