package br.edu.up.views.menus;

import br.edu.up.util.Prompt;
import br.edu.up.views.menus.cadastos.MenuAcabamento;
import br.edu.up.views.menus.cadastos.MenuCategoria;
import br.edu.up.views.menus.cadastos.MenuCliente;
import br.edu.up.views.menus.cadastos.MenuEquipamento;
import br.edu.up.views.menus.cadastos.MenuPagamento;
import br.edu.up.views.menus.cadastos.MenuProduto;

public class MenuCadastro {
    private MenuCliente menuCliente = new MenuCliente();
    private MenuProduto menuProduto = new MenuProduto();
    private MenuAcabamento menuAcabamento = new MenuAcabamento();
    private MenuEquipamento menuEquipamento = new MenuEquipamento();
    private MenuCategoria menuCategoria = new MenuCategoria();
    private MenuPagamento menuPagamento = new MenuPagamento();

    public void mostrar(){
        Prompt.limparConsole();

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
        Prompt.imprimir("\t7 - Voltar para o menu principal");


        int opcao1 = Prompt.lerInteiro("Digite aqui: ");
        Prompt.limparConsole();

        boolean sair = false;
        switch (opcao1) {
            case 1:
                menuCliente.mostrar();   
                break;
            case 2:
                menuProduto.mostrar();
                break;
            case 3:
                menuAcabamento.mostrar();
                break;
            case 4:
                menuEquipamento.mostrar();
                break;
            case 5:
                menuCategoria.mostrar();
                break;
            case 6:
                menuPagamento.mostrar();
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
