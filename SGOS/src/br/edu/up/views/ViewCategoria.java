package br.edu.up.views;

import br.edu.up.controllers.ControleDeCategoria;
import br.edu.up.models.Categoria;
import br.edu.up.util.Prompt;

public class ViewCategoria {

    ControleDeCategoria controleDeCategoria = new ControleDeCategoria(null);

    public Categoria cadastrarCategoria(){

        Integer categoriaId = controleDeCategoria.getProximoId();
        String nomeCategoria = Prompt.lerLinha("Informe o nome da categoria: ");
        String descricao = Prompt.lerLinha("Informe a descrição da categoria: ");

        Categoria categoria = new Categoria(categoriaId,nomeCategoria,descricao);
        controleDeCategoria.adicionarCategoria(categoria);
        
        return categoria;
    }
    
    public Integer getId(){
        Integer id = Prompt.lerInteiro("Informe o Id: ");
        return id;
    }

    public Categoria alterarCategoria(){
        
        String nomeCategoria = Prompt.lerLinha("Informe o nome da categoria: ");
        String descricao = Prompt.lerLinha("Informe a descrição da categoria: ");

        Categoria categoriaAlterado = new Categoria(nomeCategoria,descricao);

        return categoriaAlterado;
    }
}
