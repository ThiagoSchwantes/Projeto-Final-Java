package br.edu.up.views;
import java.util.List;
import java.util.Scanner;

import br.edu.up.controllers.ControleDeClientes;
import br.edu.up.models.Cliente;
import br.edu.up.util.Prompt;

public class MenuPrincipal {
    
    Scanner scanner = new Scanner(System.in);

    public void mostrarMenu(){

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
                Prompt.limparConsole();
                menuCadastro();   
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
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                mostrarMenu(); 
                break;
        }
    }

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
        Prompt.imprimir("\t7 - Voltar para o menu principal");


        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                Prompt.limparConsole();
                menuCliente();   
                break;
            case 2:
                Prompt.limparConsole();
                menuProduto();
                break;
            case 3:
                Prompt.limparConsole();
                menuAcabamento();
                break;
            case 4:
                Prompt.limparConsole();
                menuEquipamento();
                break;
            case 5:
                Prompt.limparConsole();
                menuCategoria();
                break;
            case 6:
                Prompt.limparConsole();
                menuPagamento();
                break;
            case 7:
                Prompt.limparConsole();
                mostrarMenu();
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                mostrarMenu();
                break;
        }
    }

    public void menuCliente(){

        ViewCliente viewCliente = new ViewCliente();
        ControleDeClientes controleDeClientes = new ControleDeClientes(null);

        Prompt.separador();
        Prompt.imprimir("MENU DE CLIENTE");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar cliente");
        Prompt.imprimir("\t2 - Listar clientes");
        Prompt.imprimir("\t3 - Alterar cliente");
        Prompt.imprimir("\t4 - Deletar cliente");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                viewCliente.cadastrarCliente();
                continuar(); 
                break;
            case 2:
                List<Cliente> clientes = controleDeClientes.getClientes();
                if(clientes.isEmpty()){
                    Prompt.imprimir("Não há clientes cadastrados.");
                }else{
                    for (Cliente cliente : clientes) {
                        Prompt.imprimir(cliente.toStringBasico());
                    }
                }
                continuar();
                break;
            case 3:
                //alterarCliente();
                break;
            case 4:
                controleDeClientes.deletarCliente(viewCliente);
                break;
            case 5:
                Prompt.limparConsole();
                menuCadastro();
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                mostrarMenu();
                break;
        }
    }

    public void menuProduto(){
        Prompt.separador();
        Prompt.imprimir("MENU DE PRODUTO");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar produto");
        Prompt.imprimir("\t2 - Listar produtos");
        Prompt.imprimir("\t3 - Alterar produto");
        Prompt.imprimir("\t4 - Deletar produto");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                //cadastrarProduto();  
                break;
            case 2:
                //listarProduto();
                break;
            case 3:
                //alterarProduto();
                break;
            case 4:
                //deletarProduto();
                break;
            case 5:
                Prompt.limparConsole();
                menuCadastro();
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                mostrarMenu();
                break;
        }
    }

    public void menuAcabamento(){
        Prompt.separador();
        Prompt.imprimir("MENU DE ACABAMENTO");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar acabamento");
        Prompt.imprimir("\t2 - Listar acabamentos");
        Prompt.imprimir("\t3 - Alterar acabamento");
        Prompt.imprimir("\t4 - Deletar acabamento");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                //cadastrarAcabamento();  
                break;
            case 2:
                //listarAcabamento();
                break;
            case 3:
                //alterarAcabamento();
                break;
            case 4:
                //deletarAcabamento();
                break;
            case 5:
                Prompt.limparConsole();
                menuCadastro();
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                mostrarMenu();
                break;
        }
    }
    
    public void menuEquipamento(){
        Prompt.separador();
        Prompt.imprimir("MENU DE EQUIPAMENTO");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar equipamento");
        Prompt.imprimir("\t2 - Listar equipamentos");
        Prompt.imprimir("\t3 - Alterar equipamento");
        Prompt.imprimir("\t4 - Deletar equipamento");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                //cadastrarEquipamento();  
                break;
            case 2:
                //listarEquipamento();
                break;
            case 3:
                //alterarEquipamento();
                break;
            case 4:
                //deletarEquipamento();
                break;
            case 5:
                Prompt.limparConsole();
                menuCadastro();
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                mostrarMenu();
                break;
        }
    }
    public void menuCategoria(){
        Prompt.separador();
        Prompt.imprimir("MENU DE CATEGORIA");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar categoria");
        Prompt.imprimir("\t2 - Listar categorias");
        Prompt.imprimir("\t3 - Alterar categoria");
        Prompt.imprimir("\t4 - Deletar categoria");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");

        switch (opcao1) {
            case 1:
                //cadastrarCategoria();  
                break;
            case 2:
                //listarCategoria();
                break;
            case 3:
                //alterarCategoria();
                break;
            case 4:
                //deletarCategoria();
                break;
            case 5:
                Prompt.limparConsole();
                menuCadastro();
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                mostrarMenu();
                break;
        }
    }

    public void menuPagamento(){
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

        switch (opcao1) {
            case 1:
                //cadastrarPagamento();  
                break;
            case 2:
                //listarPagamento();
                break;
            case 3:
                //alterarPagamento();
                break;
            case 4:
                //deletarPagamento();
                break;
            case 5:
                Prompt.limparConsole();
                menuCadastro();
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                mostrarMenu();
                break;
        }
    }

    public void encerrarPrograma(){
        Prompt.imprimir("Encerrando o programa...");
        System.exit(5);
    }

    public void continuar(){
        Prompt.imprimir("Pressione qualquer tecla para continuar...");
        scanner.nextLine();
        mostrarMenu();
    }
}


