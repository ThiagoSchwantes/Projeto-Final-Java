package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.up.models.Categoria;
import br.edu.up.views.ViewCategoria;
import br.edu.up.daos.GerenciadorDeCategoriaDAO;

public class ControleDeCategoria {
    private List<Categoria> categorias;
    private GerenciadorDeCategoriaDAO daoCategoria;
    private int maiorId;

    public ControleDeCategoria(List<Categoria> categorias) {
        daoCategoria = new GerenciadorDeCategoriaDAO();
        if (categorias == null) {
            this.categorias = new ArrayList<>();
        } else {
            this.categorias = categorias;
        }
        this.categorias = daoCategoria.getCategorias();
        this.maiorId = 0;

        for (Categoria categoria : this.categorias) {
            if (categoria.getCategoriaId() > maiorId) {
                maiorId = categoria.getCategoriaId();
            }
        }
    }

    public int getProximoId() {
        return ++maiorId;
    }

    public void adicionarCategoria(Categoria categoria) {
        categorias.add(categoria);
        daoCategoria.gravarArquivo();
    }

    public void alterarCategoria(ViewCategoria viewCategoria) {
        Integer id = viewCategoria.getId();
        for (Categoria categoria : categorias) {
            if (categoria.getCategoriaId().equals(id)) {
                Categoria categoriaAlterada = viewCategoria.alterarCategoria();
                categoria.setNomeCategoria(categoriaAlterada.getNomeCategoria());
                categoria.setDescricao(categoriaAlterada.getDescricao());
                break;
            }
        }
        daoCategoria.gravarArquivo();
    }

    public void deletarCategoria(ViewCategoria viewCategoria) {
        Integer id = viewCategoria.getId();
        Iterator<Categoria> iterator = categorias.iterator();
        while (iterator.hasNext()) {
            Categoria categoria = iterator.next();
            if (categoria.getCategoriaId().equals(id)) {
                iterator.remove();
                break;
            }
        }
        daoCategoria.gravarArquivo();
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}

