package br.edu.up.views;

import br.edu.up.util.Prompt;
import br.edu.up.views.menus.MenuCadastro;

public class MenuPrincipal {
    MenuCadastro menuCadastro = new MenuCadastro();

    public void mostrar(){
        Prompt.limparConsole();
        
        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastros");
        Prompt.imprimir("\t2 - Movimentação de Ordem de Serviço");
        Prompt.imprimir("\t3 - Relatórios");
        Prompt.imprimir("\t4 - Configuração");
        Prompt.imprimir("\t5 - Sair");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                menuCadastro.mostrar();   
                break;
            case 2:
                //menuOrdemServico();
                break;
            case 3:
                //menuRelatorio();
                break;
            case 4:
                //menuConfiguração();
                break;
            case 5:
                encerrarPrograma();
                break;
            default:
                Prompt.imprimir("Valor Inválido.");
                break;
        }
        
        mostrar();
    }

    public void encerrarPrograma(){
        Prompt.separador();
        Prompt.imprimir("Encerrando o programa...");
        System.exit(5);
    }
}