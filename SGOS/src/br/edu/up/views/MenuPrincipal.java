package br.edu.up.views;
import java.util.List;
import java.util.Scanner;

import br.edu.up.controllers.ControleDeAcabamento;
import br.edu.up.controllers.ControleDeCategoria;
import br.edu.up.controllers.ControleDeClientes;
import br.edu.up.controllers.ControleDeEquipamento;
import br.edu.up.controllers.ControleDePagamento;
import br.edu.up.controllers.ControleDeProduto;
import br.edu.up.models.Acabamento;
import br.edu.up.models.Categoria;
import br.edu.up.models.Cliente;
import br.edu.up.models.Equipamento;
import br.edu.up.models.Pagamento;
import br.edu.up.models.Produto;
import br.edu.up.util.Prompt;

public class MenuPrincipal {
    
    Scanner scanner = new Scanner(System.in);

    public void mostrarMenu(){
        Prompt.linhaEmBranco();
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
                menuCliente(); 
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
                menuCliente(); 
                break;
            case 3:
                controleDeClientes.alterarCliente(viewCliente);
                continuar();
                menuCliente(); 
                break;
            case 4:
                controleDeClientes.deletarCliente(viewCliente);
                continuar();
                menuCliente(); 
                break;
            case 5:
                Prompt.limparConsole();
                menuCadastro();
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                continuar();
                menuCliente(); 
                break;
        }
    }

    public void menuProduto(){

        ViewProduto viewProduto = new ViewProduto();
        ControleDeProduto controleDeProduto = new ControleDeProduto(null);

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
                viewProduto.cadastrarProduto();
                continuar();
                menuProduto();  
                break;
            case 2:
                List<Produto> produtos = controleDeProduto.getProdutos();
                if(produtos.isEmpty()){
                    Prompt.imprimir("Não há produtos cadastrados.");
                }else{
                    for (Produto produto : produtos) {
                        Prompt.imprimir(produto.toStringBasico());
                    }
                }
                continuar();
                menuProduto();  
                break;
            case 3:
                controleDeProduto.alterarProduto(viewProduto);
                continuar();
                menuProduto();  
                break;
            case 4:
                controleDeProduto.deletarProduto(viewProduto);
                continuar();
                menuProduto();  
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

        ViewAcabamento viewAcabamento = new ViewAcabamento();
        ControleDeAcabamento controleDeAcabamento = new ControleDeAcabamento(null);

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
                viewAcabamento.cadastrarAcabamento();
                continuar();
                menuAcabamento();  
                break;
            case 2:
                List<Acabamento> acabamentos = controleDeAcabamento.getAcabamentos();
                if(acabamentos.isEmpty()){
                    Prompt.imprimir("Não há acabamentos cadastrados.");
                }else{
                    for (Acabamento acabamento : acabamentos) {
                        Prompt.imprimir(acabamento.toStringBasico());
                    }
                }
                continuar();
                menuAcabamento(); 
                break;
            case 3:
                controleDeAcabamento.alterarAcabamento(viewAcabamento);
                continuar();
                menuAcabamento(); 
                break;
            case 4:
                controleDeAcabamento.deletarAcabamento(viewAcabamento);
                continuar();
                menuAcabamento(); 
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

        ViewEquipamento viewEquipamento = new ViewEquipamento();
        ControleDeEquipamento controleDeEquipamento = new ControleDeEquipamento(null);

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
                viewEquipamento.cadastrarEquipamento();
                continuar();
                menuEquipamento();  
                break;
            case 2:
                List<Equipamento> equipamentos = controleDeEquipamento.getEquipamentos();
                if(equipamentos.isEmpty()){
                    Prompt.imprimir("Não há equipamentos cadastrados.");
                }else{
                    for (Equipamento equipamento : equipamentos) {
                        Prompt.imprimir(equipamento.toStringBasico());
                    }
                }
                continuar();
                menuEquipamento();
                break;
            case 3:
                controleDeEquipamento.alterarEquipamento(viewEquipamento);
                continuar();
                menuEquipamento();
                break;
            case 4:
                controleDeEquipamento.deletarEquipamento(viewEquipamento);
                continuar();
                menuEquipamento();
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

        ViewCategoria viewCategoria = new ViewCategoria();
        ControleDeCategoria controleDeCategoria = new ControleDeCategoria(null);

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
                viewCategoria.cadastrarCategoria();
                continuar();
                menuCategoria();  
                break;
            case 2:
                List<Categoria> categorias = controleDeCategoria.getCategorias();
                if(categorias.isEmpty()){
                    Prompt.imprimir("Não há categorias cadastradas.");
                }else{
                    for (Categoria categoria : categorias) {
                        Prompt.imprimir(categoria.toStringBasico());
                    }
                }
                continuar();
                menuCategoria(); 
                break;
            case 3:
                controleDeCategoria.alterarCategoria(viewCategoria);
                continuar();
                menuCategoria(); 
                break;
            case 4:
                controleDeCategoria.deletarCategoria(viewCategoria);
                continuar();
                menuCategoria(); 
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

        ViewPagamento viewPagamento = new ViewPagamento();
        ControleDePagamento controleDePagamento = new ControleDePagamento(null);

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
                viewPagamento.cadastrarPagamento();
                continuar();
                menuPagamento();  
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
                continuar();
                menuPagamento();
                break;
            case 3:
                controleDePagamento.alterarPagamento(viewPagamento);
                continuar();
                menuPagamento();
                break;
            case 4:
                controleDePagamento.deletarPagamento(viewPagamento);
                continuar();
                menuPagamento();
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

    }
}


