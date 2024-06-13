package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.List;
import br.edu.up.daos.GerenciadorDeProdutosOrdemServico;
import br.edu.up.models.ProdutoOrdemServico;

public class ControleProdutoDeOrdemServico {
    private List<ProdutoOrdemServico> produtosOrdemServicos = new ArrayList<>();
    private GerenciadorDeProdutosOrdemServico daoProdutoOrdemServico;
    private int indice = 0;

    public ControleProdutoDeOrdemServico(){
        daoProdutoOrdemServico = new GerenciadorDeProdutosOrdemServico();

        this.produtosOrdemServicos = daoProdutoOrdemServico.getProdutosOrdemServico();
        this.indice = 0;

        for (ProdutoOrdemServico produtoOrdemServico : this.produtosOrdemServicos) {
            if (produtoOrdemServico.getProdutoOrdemServicoId() > indice) {
                indice = produtoOrdemServico.getProdutoOrdemServicoId();
            }
        }
    }

    public void adicionar(ProdutoOrdemServico produtoOS){
        produtoOS.setProdutoOrdemServicoId(indice);
        indice++;

        produtosOrdemServicos.add(produtoOS);
        daoProdutoOrdemServico.gravarArquivo();
    }

    public String listar(){
        String lista = "";

        for (ProdutoOrdemServico produtoOS : produtosOrdemServicos) {
            if(produtosOrdemServicos.indexOf(produtoOS) == 0){
                lista = produtoOS.toString();
            }else{
                lista += "\n\n"+produtoOS.toString();
            }
        }
        return lista;
    }

    public ProdutoOrdemServico buscar(int id){
        for (ProdutoOrdemServico produtoOS : produtosOrdemServicos) {
            if(produtoOS.getProdutoOrdemServicoId() == id){
                return produtoOS;
            }
        }
        return null;
    }

    public void alterar(ProdutoOrdemServico produtoOSAlterar){
        for (ProdutoOrdemServico produtoOS : produtosOrdemServicos) {
            if(produtoOS.getProdutoOrdemServicoId() == produtoOSAlterar.getProdutoOrdemServicoId()){
                int index = produtosOrdemServicos.indexOf(produtoOS);
                produtosOrdemServicos.set(index, produtoOSAlterar);
            }
        }
        daoProdutoOrdemServico.gravarArquivo();
    }

    public void alterar(int id, ProdutoOrdemServico produtoOsAlterar){
        for (ProdutoOrdemServico produtoOS : produtosOrdemServicos) {
            if(produtoOS.getProdutoOrdemServicoId() == id){
                int index = produtosOrdemServicos.indexOf(produtoOS);
                produtosOrdemServicos.set(index, produtoOsAlterar);
            }
        }
        daoProdutoOrdemServico.gravarArquivo();
    }

    public void deletar(ProdutoOrdemServico produtoOs){
        produtosOrdemServicos.remove(produtosOrdemServicos.indexOf(produtoOs));
        daoProdutoOrdemServico.gravarArquivo();
    }

    public boolean deletar(int id){
        for (ProdutoOrdemServico produtoOs : produtosOrdemServicos) {
            if(produtoOs.getProdutoOrdemServicoId() == id){
                produtosOrdemServicos.remove(produtoOs);
                daoProdutoOrdemServico.gravarArquivo();
                return true;
            }
        }
        return false;
    }
}
