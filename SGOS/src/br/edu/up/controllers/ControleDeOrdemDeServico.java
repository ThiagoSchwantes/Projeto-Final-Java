package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.daos.GerenciadorDeOrdemDeSevicoDao;
import br.edu.up.models.OrdemDeServico;

public class ControleDeOrdemDeServico {
    private List<OrdemDeServico> ordemDeServicos = new ArrayList<>();
    private GerenciadorDeOrdemDeSevicoDao daoOS;
    private int codigoOS = 0;

    public ControleDeOrdemDeServico(){
        daoOS = new GerenciadorDeOrdemDeSevicoDao();

        this.ordemDeServicos = daoOS.getOrdemDeServicos();
        this.codigoOS = 0;

        for (OrdemDeServico ordemDeServico : this.ordemDeServicos) {
            if (ordemDeServico.getCodigo() > codigoOS) {
                codigoOS = ordemDeServico.getCodigo();
            }
        }
    }

    public void adicionar(OrdemDeServico os){
        os.setCodigo(codigoOS);
        codigoOS++;

        ordemDeServicos.add(os);
        daoOS.gravarArquivo();
    }

    public String listar(){
        String lista = "";

        for (OrdemDeServico ordemDeServico : ordemDeServicos) {
            if(ordemDeServicos.indexOf(ordemDeServico) == 0){
                lista = ordemDeServico.toStringBasico();
            }else{
                lista += ordemDeServico.toStringBasico();
            }
            lista += "\n-------------------------------------------------------------------------\n";
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
        daoOS.gravarArquivo();
    }

    public void alterar(int codigo, OrdemDeServico os){
        for (OrdemDeServico ordemDeServico : ordemDeServicos) {
            if(ordemDeServico.getCodigo() == codigo){
                int index = ordemDeServicos.indexOf(ordemDeServico);
                ordemDeServicos.set(index, os);
            }
        }
        daoOS.gravarArquivo();
    }

    public void deletar(OrdemDeServico os){
        ordemDeServicos.remove(os);
        daoOS.gravarArquivo();
    }

    public boolean deletar(int codigo){
        for (OrdemDeServico ordemDeServico : ordemDeServicos) {
            if(ordemDeServico.getCodigo() == codigo){
                ordemDeServicos.remove(ordemDeServico);
                daoOS.gravarArquivo();
                return true;
            }
        }
        return false;
    }
}
