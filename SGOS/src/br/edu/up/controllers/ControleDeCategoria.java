package br.edu.up.controllers;

import java.util.Iterator;
import java.util.List;

import br.edu.up.models.Categoria;
import br.edu.up.daos.GerenciadorDeCategoriaDAO;

public class ControleDeCategoria {
    private List<Categoria> categorias;
    private GerenciadorDeCategoriaDAO daoCategoria;
    private int maiorId;

    public ControleDeCategoria() {
        daoCategoria = new GerenciadorDeCategoriaDAO();

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

    public Categoria buscar(Integer categoriaId){
        for (Categoria categoria : categorias) {
            if(categoria.getCategoriaId() == categoriaId){
                return categoria;
            }
        }
        return null;
    }

    public Categoria buscar(String nome){
        for (Categoria categoria : categorias) {
            if(categoria.getNomeCategoria().toLowerCase().equals(nome.toLowerCase())){
                return categoria;
            }
        }
        return null;
    }

    public void alterarCategoria(Integer id, Categoria categoriaAlterada) {
        for (Categoria categoria : categorias) {
            if (categoria.getCategoriaId().equals(id)) {
                categoria.setNomeCategoria(categoriaAlterada.getNomeCategoria());
                categoria.setDescricao(categoriaAlterada.getDescricao());
                break;
            }
        }
        daoCategoria.gravarArquivo();
    }

    public void deletarCategoria(Integer id) {
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

