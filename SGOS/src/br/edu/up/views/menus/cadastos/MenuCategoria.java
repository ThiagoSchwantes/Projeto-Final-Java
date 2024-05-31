package br.edu.up.views.menus.cadastos;

import java.util.List;

import br.edu.up.controllers.ControleDeCategoria;
import br.edu.up.models.Categoria;
import br.edu.up.util.Prompt;

public class MenuCategoria {
    
    ControleDeCategoria controleDeCategoria = new ControleDeCategoria();

    public void mostrar(){
        Prompt.limparConsole();

        Prompt.separador();
        Prompt.imprimir("MENU DE CATEGORIA");
        Prompt.separador();

        Prompt.imprimir("Digite uma das opções:");
        Prompt.imprimir("\t1 - Cadastrar categoria");
        Prompt.imprimir("\t2 - Listar categorias");
        Prompt.imprimir("\t3 - Alterar categoria");
        Prompt.imprimir("\t4 - Deletar categoria");
        Prompt.imprimir("\t5 - Voltar para o menu de cadastro");

        int opcao1 = Prompt.lerInteiro("Digite aqui: ");
        Prompt.limparConsole();

        boolean sair = false;
        switch (opcao1) {
            case 1:
                cadastrarCategoria();
                break;
            case 2:
                List<Categoria> categorias = controleDeCategoria.getCategorias();
                if(categorias.isEmpty()){
                    Prompt.imprimir("Não há categorias cadastradas.");
                }else{
                    for (Categoria categoria : categorias) {
                        Prompt.imprimir(categoria.toStringBasico());
                    }
                }
                break;
            case 3:
                Integer idAlterado = getId();
                Categoria categoriaAlterada = alterarCategoria();

                controleDeCategoria.alterarCategoria(idAlterado, categoriaAlterada);
                break;
            case 4:
                Integer idDeletar = getId();
                controleDeCategoria.deletarCategoria(idDeletar);
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

    public Categoria cadastrarCategoria(){

        Integer categoriaId = controleDeCategoria.getProximoId();
        String nomeCategoria = lerNomeCategoria();
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
        
        String nomeCategoria = lerNomeCategoria();
        String descricao = Prompt.lerLinha("Informe a descrição da categoria: ");

        Categoria categoriaAlterado = new Categoria(nomeCategoria,descricao);

        return categoriaAlterado;
    }

    private String lerNomeCategoria() {
        while (true) {
            String nomeCategoria = Prompt.lerLinha("Informe o nome da categoria: ");
            try {
                Categoria categoria = new Categoria();
                categoria.setNomeCategoria(nomeCategoria);
                return nomeCategoria;
            } catch (IllegalArgumentException e) {
                Prompt.imprimir(e.getMessage());
            }
        }
    }
}