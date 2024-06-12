package br.edu.up.controllers;

import java.util.Iterator;
import java.util.List;
import br.edu.up.models.Pagamento;
import br.edu.up.daos.GerenciadorDePagamentoDAO;

public class ControleDePagamento {
    private List<Pagamento> pagamentos;
    private GerenciadorDePagamentoDAO daoPagamento;
    private int maiorId;

    public ControleDePagamento() {
        daoPagamento = new GerenciadorDePagamentoDAO();
        pagamentos = daoPagamento.getPagamentos();
        maiorId = 0;

        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getPagamentoId() > maiorId) {
                maiorId = pagamento.getPagamentoId();
            }
        }
    }

    public int getProximoId() {
        return ++maiorId;
    }

    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
        daoPagamento.gravarArquivo();
    }

    public Pagamento buscar(Integer pagamentoId){
        for (Pagamento pagamento : pagamentos) {
            if(pagamento.getPagamentoId() == pagamentoId){
                return pagamento;
            }
        }
        return null;
    }

    public Pagamento buscar(String nome){
        for (Pagamento pagamento : pagamentos) {
            if(pagamento.getNomePagamento().toLowerCase().equals(nome.toLowerCase())){
                return pagamento;
            }
        }
        return null;
    }

    public void alterarPagamento(Integer id, Pagamento pagamentoAlterado) {
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getPagamentoId().equals(id)) {
                pagamento.setNomePagamento(pagamentoAlterado.getNomePagamento());
                break;
            }
        }
        daoPagamento.gravarArquivo();
    }

    public void deletarPagamento(Integer id){
        Iterator<Pagamento> iterator = pagamentos.iterator();
        while (iterator.hasNext()) {
            Pagamento pagamento = iterator.next();
            if (pagamento.getPagamentoId().equals(id)) {
                iterator.remove();
                break;
            }
        }
        daoPagamento.gravarArquivo();
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
}

