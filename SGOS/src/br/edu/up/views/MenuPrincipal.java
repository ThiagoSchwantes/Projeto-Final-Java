package br.edu.up.views;
import java.util.Scanner;

import br.edu.up.util.Prompt;

public class MenuPrincipal {

    Scanner scanner = new Scanner(System.in);
    public void mostrarMenu(){

        Prompt.separador();
        Prompt.imprimir("MENU PRINCIPAL");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Incluir seguro");
        Prompt.imprimir("\t2 - Localizar seguro");
        Prompt.imprimir("\t3 - Excluir seguro");
        Prompt.imprimir("\t4 - Excluir todos os seguros");
        Prompt.imprimir("\t5 - Listar todos os seguros");
        Prompt.imprimir("\t6 - Ver quantidade de seguros");
        Prompt.imprimir("\t7 - Sair");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                //menuCadastro();   
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
                mostrarMenu();
                break;
        }
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(7);
    }
    public void continuar(){
        Prompt.imprimir("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        mostrarMenu();
    }
}


