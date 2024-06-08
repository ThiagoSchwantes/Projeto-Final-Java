package br.edu.up.views.menus.ordem_de_servicos;

import br.edu.up.controllers.ControleDeAcabamento;
import br.edu.up.controllers.ControleDeClientes;
import br.edu.up.controllers.ControleDeEquipamento;
import br.edu.up.controllers.ControleDeOrdemDeServico;
import br.edu.up.controllers.ControleDeProduto;
import br.edu.up.controllers.ControleProdutoDeOrdemServico;
import br.edu.up.models.Acabamento;
import br.edu.up.models.Cliente;
import br.edu.up.models.Equipamento;
import br.edu.up.models.OrdemDeServico;
import br.edu.up.models.Produto;
import br.edu.up.models.ProdutoOrdemServico;
import br.edu.up.util.Prompt;

public class MenuDeCadastroOS {
    private ControleDeOrdemDeServico controleOS = new ControleDeOrdemDeServico();
    private ControleProdutoDeOrdemServico controleProdutoDeOrdemServico = new ControleProdutoDeOrdemServico();
    private ControleDeClientes controleDeClientes = new ControleDeClientes();
    private ControleDeAcabamento controleDeAcabamento = new ControleDeAcabamento();
    private ControleDeEquipamento controleDeEquipamento = new ControleDeEquipamento();
    private ControleDeProduto controleDeProduto = new ControleDeProduto();

    public void mostrar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("CADASTRANDO UMA ORDEM DE SERVICO - informações iniciais");
        Prompt.separador();

        String identificacao = Prompt.lerLinha("Digite o cpf/cnpj do cliente:");
        Cliente cliente = controleDeClientes.buscar(identificacao);
        String funcionario = Prompt.lerLinha("Digite qual funcionário está responsavel pela OS:");
        ProdutoOrdemServico produtoOrdemServico = adicionarProduto();
        String comentario = Prompt.lerLinha("Digite um comentário sobre a OS:");

        OrdemDeServico ordemDeServico = new OrdemDeServico(cliente, funcionario, comentario, produtoOrdemServico);
        controleOS.adicionar(ordemDeServico);

        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("ORDEM DE SERVICO CADASTRADA COM SUCESSO");
        Prompt.separador();

        Prompt.imprimir(ordemDeServico.toString());
        Prompt.pressionarEnter();
    }

    public ProdutoOrdemServico adicionarProduto(){
        ProdutoOrdemServico produtoOrdemServico = null;

        Produto produto = escolherProduto();
        etapa("Etapa 2/4 - Digite as informações do produto:");

        int quantidade = Prompt.lerInteiro("Digite a quantidade do produto:");
        Double largura = Prompt.lerDecimal("Digite a largura do produto:");
        Double altura = Prompt.lerDecimal("Digite a altura do produto:");
        Double valorM2 = Prompt.lerDecimal("Digite o valor do metro quadrado:");
        Equipamento equipamento = escolherEquipamento();
        Acabamento acabamento = escolherAcabamento();

        produtoOrdemServico = new ProdutoOrdemServico(produto, quantidade, largura, altura, valorM2, equipamento, acabamento);
        controleProdutoDeOrdemServico.adicionar(produtoOrdemServico);

        etapa("Produto adicionado:\n" + produtoOrdemServico.toString());
            
        return produtoOrdemServico;
    }

    public void etapa(String etapa){
        Prompt.limparConsole();
        Prompt.separador();
        Prompt.imprimir("CADASTRANDO UMA ORDEM DE SERVICO" +
            "\nadicionando produto!");
        Prompt.separador();
        Prompt.imprimir(etapa);
        Prompt.separador();
    }


    public Produto escolherProduto(){
        Produto produto = null;
        do{
            etapa("Etapa 1/4 - Selecione qual produto deseja adicionar na Ordem de Servico");   
            Prompt.imprimir(controleDeProduto.listar());
            Prompt.separador();
    
            int opcao = Prompt.lerInteiro("Digite qual produto deseja adicionar?");
            produto = controleDeProduto.buscar(opcao-1);
        }while(produto == null);
        
        return produto;
    }

    public Equipamento escolherEquipamento(){
        Equipamento equipamento = null;
        do{
            etapa("Etapa 3/4 - Selecione qual equipamento deseja adicionar na Ordem de Servico");    
            Prompt.imprimir(controleDeEquipamento.listar());
            Prompt.separador();
    
            int opcao = Prompt.lerInteiro("Digite qual equipamento deseja adicionar:");
            equipamento = controleDeEquipamento.buscar(opcao-1);
        }while(equipamento == null);
        
        return equipamento;
    }

    public Acabamento escolherAcabamento(){
        Acabamento acabamento = null;
        do{
            etapa("Etapa 4/4 - Selecione qual acabamento deseja adicionar na Ordem de Servico");
            Prompt.imprimir(controleDeAcabamento.listar());
            Prompt.separador();
    
            int opcao = Prompt.lerInteiro("Digite qual equipamento deseja adicionar:");
            acabamento = controleDeAcabamento.buscar(opcao-1);
        }while(acabamento == null);
        
        return acabamento;
    }
}