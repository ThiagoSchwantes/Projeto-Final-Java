package br.edu.up.views.menus.cadastos;

import java.util.List;

import br.edu.up.controllers.ControleDeEquipamento;
import br.edu.up.models.Equipamento;
import br.edu.up.util.Prompt;

public class MenuEquipamento {
    private ControleDeEquipamento controleDeEquipamento = new ControleDeEquipamento();

    public void mostrar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("MENU DE EQUIPAMENTO");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar equipamento");
        Prompt.imprimir("\t2 - Listar equipamentos");
        Prompt.imprimir("\t3 - Alterar equipamento");
        Prompt.imprimir("\t4 - Deletar equipamento");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");
        Prompt.limparConsole();

        boolean sair = false;
        switch (opcao1) {
            case 1:
                cadastrarEquipamento();
                break;
            case 2:
                List<Equipamento> equipamentos = controleDeEquipamento.getEquipamentos();
                if(equipamentos.isEmpty()){
                    Prompt.imprimir("Não há equipamentos cadastrados.");
                }else{
                    for (Equipamento equipamento : equipamentos) {
                        Prompt.imprimir(equipamento.toStringBasico());
                    }
                }
                break;
            case 3:
                Integer idAlterar = getId();
                Equipamento equipamentoAlterado = alterarEquipamento();

                controleDeEquipamento.alterarEquipamento(idAlterar, equipamentoAlterado);
                break;
            case 4:
                Integer idDeletar = getId();
                controleDeEquipamento.deletarEquipamento(idDeletar);
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

    public Equipamento cadastrarEquipamento(){

        Integer equipamentoId = controleDeEquipamento.getProximoId();
        String nomeEquipamento = lerNomeEquipamento();
        String descricao = Prompt.lerLinha("Informe a descrição do equipamento: ");

        Equipamento equipamento = new Equipamento(equipamentoId,nomeEquipamento,descricao);
        controleDeEquipamento.adicionarEquipamento(equipamento);
        
        return equipamento;
    }
    
    public Integer getId(){
        Integer id = Prompt.lerInteiro("Informe o Id: ");
        return id;
    }

    public Equipamento alterarEquipamento(){
        
        String nomeEquipamento = lerNomeEquipamento();
        String descricao = Prompt.lerLinha("Informe a descrição do equipamento: ");

        Equipamento equipamentoAlterado = new Equipamento(nomeEquipamento,descricao);

        return equipamentoAlterado;
    }

    private String lerNomeEquipamento() {
        while (true) {
            String nomeEquipamento = Prompt.lerLinha("Informe o nome do equipamento: ");
            try {
                Equipamento equipamento = new Equipamento();
                equipamento.setNomeEquipamento(nomeEquipamento);
                return nomeEquipamento;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }
}
