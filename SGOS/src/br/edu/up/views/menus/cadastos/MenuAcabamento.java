package br.edu.up.views.menus.cadastos;

import java.util.List;

import br.edu.up.controllers.ControleDeAcabamento;
import br.edu.up.models.Acabamento;
import br.edu.up.util.Prompt;

public class MenuAcabamento {
    private ControleDeAcabamento controleDeAcabamento = new ControleDeAcabamento();

    public void mostrar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("MENU DE ACABAMENTO");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar acabamento");
        Prompt.imprimir("\t2 - Listar acabamentos");
        Prompt.imprimir("\t3 - Alterar acabamento");
        Prompt.imprimir("\t4 - Deletar acabamento");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");
        Prompt.limparConsole();

        boolean sair = false;
        switch (opcao1) {
            case 1:
                cadastrarAcabamento();
                break;
            case 2:
                List<Acabamento> acabamentos = controleDeAcabamento.getAcabamentos();
                if(acabamentos.isEmpty()){
                    Prompt.imprimir("Não há acabamentos cadastrados.");
                }else{
                    for (Acabamento acabamento : acabamentos) {
                        Prompt.imprimir(acabamento.toStringBasico());
                    }
                }
                break;
            case 3:
                Integer idAlterar = getId();
                Acabamento acabamentoAlterado = alterarAcabamento();

                controleDeAcabamento.alterarAcabamento(idAlterar, acabamentoAlterado);
                break;
            case 4:
                Integer idDeletar = getId();
                
                controleDeAcabamento.deletarAcabamento(idDeletar);
                break;
            case 5:
                sair = true;
                break;
            default:
                Prompt.limparConsole();
                Prompt.imprimir("Valor Inválido.");
                break;
        }

        if(!sair){
            Prompt.separador();
            Prompt.pressionarEnter();
            mostrar();
        }
    }

    public Acabamento cadastrarAcabamento(){

        Integer acabamentoId = controleDeAcabamento.getProximoId();
        String nomeAcabamento = lerNomeAcabamento();
        String descricao = Prompt.lerLinha("Informe a descrição do acabamento: ");
        
        Acabamento acabamento = new Acabamento(acabamentoId,nomeAcabamento,descricao);
        controleDeAcabamento.adicionarAcabamento(acabamento);
        
        return acabamento;
    }
    
    public Integer getId(){
        Integer id = Prompt.lerInteiro("Informe o Id: ");
        return id;
    }

    public Acabamento alterarAcabamento(){
        
        String nomeAcabamento = lerNomeAcabamento();
        String descricao = Prompt.lerLinha("Informe a descrição do acabamento: ");

        Acabamento acabamentoAlterado = new Acabamento(nomeAcabamento,descricao);

        return acabamentoAlterado;
    }

    private String lerNomeAcabamento() {
        while (true) {
            String nomeAcabamento = Prompt.lerLinha("Informe o nome do acabamento: ");
            try {
                Acabamento acabamento = new Acabamento();
                acabamento.setNomeAcabamento(nomeAcabamento);
                return nomeAcabamento;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }
}