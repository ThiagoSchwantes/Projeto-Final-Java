package br.edu.up.views;

import java.util.Scanner;

import br.edu.up.util.Prompt;

public class MenuDeCadastro {
    MenuPrincipal menuPrincipal  = new MenuPrincipal();
    Scanner scanner = new Scanner(System.in);
    public void menuCadastro(){

        Prompt.separador();
        Prompt.imprimir("MENU DE CADASTRO");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cliente");
        Prompt.imprimir("\t2 - Produto");
        Prompt.imprimir("\t3 - Acabamento");
        Prompt.imprimir("\t4 - Equipamento");
        Prompt.imprimir("\t5 - Categorias");
        Prompt.imprimir("\t6 - Formas de pagamento");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                //menuCliente();   
                break;
            case 2:
                //menuProduto();
                break;
            case 3:
                //menuAcabamento();
                break;
            case 4:
                //menuEquipamento();
                break;
            case 5:
                //menuCategoria();
                break;
            case 6:
                //menuPagamento();
            default:
                Prompt.imprimir("Valor Inválido.");
                menuPrincipal.mostrarMenu();
                break;
        }
    }
    public void continuar(){
        Prompt.imprimir("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        menuPrincipal.mostrarMenu();
    }
}
