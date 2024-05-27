package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.up.models.Pagamento;
import br.edu.up.views.ViewPagamento;
import br.edu.up.daos.GerenciadorDePagamentoDAO;

public class ControleDePagamento {
    private List<Pagamento> pagamentos;
    private GerenciadorDePagamentoDAO daoPagamento;
    private int maiorId;

    public ControleDePagamento(List<Pagamento> pagamentos) {
        daoPagamento = new GerenciadorDePagamentoDAO();
        if (pagamentos == null) {
            this.pagamentos = new ArrayList<>();
        } else {
            this.pagamentos = pagamentos;
        }
        this.pagamentos = daoPagamento.getPagamentos();
        this.maiorId = 0;

        for (Pagamento pagamento : this.pagamentos) {
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

    public void alterarPagamento(ViewPagamento viewPagamento) {
        Integer id = viewPagamento.getId();
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getPagamentoId().equals(id)) {
                Pagamento pagamentoAlterado = viewPagamento.alterarPagamento();
                pagamento.setNomePagamento(pagamentoAlterado.getNomePagamento());
                break;
            }
        }
        daoPagamento.gravarArquivo();
    }

    public void deletarPagamento(ViewPagamento viewPagamento) {
        Integer id = viewPagamento.getId();
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

