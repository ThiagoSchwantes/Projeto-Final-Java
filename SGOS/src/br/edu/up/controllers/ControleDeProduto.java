package br.edu.up.controllers;

import java.util.Iterator;
import java.util.List;
import br.edu.up.daos.GerenciadorDeProdutosDAO;
import br.edu.up.models.Produto;

public class ControleDeProduto {
    private List<Produto> produtos;
    private GerenciadorDeProdutosDAO daoProduto;
    private int maiorId;

    public ControleDeProduto() {
        daoProduto = new GerenciadorDeProdutosDAO();

        this.produtos = daoProduto.getProdutos();
        this.maiorId = 0;

        for (Produto produto : this.produtos) {
            if (produto.getProdutoId() > maiorId) {
                maiorId = produto.getProdutoId();
            }
        }
    }

    public int getProximoId() {
        return ++maiorId;
    }

    public void adicionarProduto(Produto produto){
        produtos.add(produto);
        daoProduto.gravarArquivo();
    }

    public void alterarProduto(Integer id, Produto produtoAlterado){
        for (Produto produto : produtos) {
            if(produto.getProdutoId().equals(id)){
                produto.setNomeProduto(produtoAlterado.getNomeProduto());
                produto.setDescricao(produtoAlterado.getDescricao());
                break;
            }
        }
        daoProduto.gravarArquivo();
    }

    public void deletarProduto(Integer id){
        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
            if (produto.getProdutoId().equals(id)) {
                iterator.remove();
                break;
            }
        }
        daoProduto.gravarArquivo();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    
}
