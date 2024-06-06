package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.models.OrdemDeServico;

public class ControleDeOrdemDeServico {
    private List<OrdemDeServico> ordemDeServicos = new ArrayList<>();
    private int codigoOS = 0;

    public void adicionar(OrdemDeServico os){
        os.setCodigo(codigoOS);
        codigoOS++;

        ordemDeServicos.add(os);
    }

    public String listar(){
        String lista = "";

        for (OrdemDeServico ordemDeServico : ordemDeServicos) {
            if(ordemDeServicos.indexOf(ordemDeServico) == 0){
                lista = ordemDeServico.toString();
            }else{
                lista += "\n\n"+ordemDeServico.toString();
            }
        }

        return lista;
    }

    public OrdemDeServico buscar(int codigo){
        for (OrdemDeServico ordemDeServico : ordemDeServicos) {
            if(ordemDeServico.getCodigo() == codigo){
                return ordemDeServico;
            }
        }
        return null;
    }

    public void alterar(OrdemDeServico os){
        for (OrdemDeServico ordemDeServico : ordemDeServicos) {
            if(ordemDeServico.getCodigo() == os.getCodigo()){
                int index = ordemDeServicos.indexOf(ordemDeServico);
                ordemDeServicos.set(index, os);
            }
        }
    }

    public void alterar(int codigo, OrdemDeServico os){
        for (OrdemDeServico ordemDeServico : ordemDeServicos) {
            if(ordemDeServico.getCodigo() == codigo){
                int index = ordemDeServicos.indexOf(ordemDeServico);
                ordemDeServicos.set(index, os);
            }
        }
    }

    public boolean deletar(OrdemDeServico os){
        return ordemDeServicos.remove(os);
    }

    public boolean deletar(int codigo){
        for (OrdemDeServico ordemDeServico : ordemDeServicos) {
            if(ordemDeServico.getCodigo() == codigo){
                ordemDeServicos.remove(ordemDeServico);
                return true;
            }
        }
        return false;
    }
}
