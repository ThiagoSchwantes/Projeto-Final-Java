package br.edu.up.views;

import br.edu.up.controllers.ControleDeProduto;
import br.edu.up.models.Produto;
import br.edu.up.util.Prompt;

public class ViewProduto {

    ControleDeProduto controleDeProduto = new ControleDeProduto(null);

    public Produto cadastrarProduto(){

        Integer produtoId = controleDeProduto.getProximoId();
        String nomeProduto = Prompt.lerLinha("Informe o nome do Produto: ");
        String descrição = Prompt.lerLinha("Informe a descrição do Produto: ");
        
        Produto produto = new Produto(produtoId, nomeProduto, descrição);
        controleDeProduto.adicionarProduto(produto);
        return produto;
    }
    
    public Integer getId(){
        Integer id = Prompt.lerInteiro("Informe o Id: ");
        return id;
    }

    public Produto alterarProduto(){
        
        
        String nomeProduto = Prompt.lerLinha("Informe o nome do Produto: ");
        String descricao = Prompt.lerLinha("Informe a descrição do Produto: ");

        Produto produtoAlterado = new Produto(nomeProduto,descricao);
        
        return produtoAlterado;
    }
}
