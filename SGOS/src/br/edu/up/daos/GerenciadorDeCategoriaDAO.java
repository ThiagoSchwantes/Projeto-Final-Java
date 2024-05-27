package br.edu.up.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.Categoria;

public class GerenciadorDeCategoriaDAO {
    private String header = "categoriaId;nomeCategoria;descricao";
    private String nomeDoArquivo = "C:\\Users\\User\\Desktop\\Projeto-Final-Java\\SGOS\\src\\br\\edu\\up\\daos\\categorias.csv";
    List<Categoria> listaDeCategorias = new ArrayList<>();

    public List<Categoria> getCategorias() {
        try {
            File arquivoLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoLeitura);
            if (leitor.hasNextLine()) {
                header = leitor.nextLine();
            }

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");
                
                Integer categoriaId = Integer.parseInt(dados[0]);
                String nomeCategoria = dados[1];
                String descricao = dados[2];

                Categoria categoria = new Categoria(categoriaId, nomeCategoria, descricao);
                listaDeCategorias.add(categoria);
            }
            leitor.close();
        } catch(Exception e){
            System.out.println("Arquivo não encontrado!");
        }
        return listaDeCategorias;
    }

    public void gravarArquivo() {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (Categoria categoria : listaDeCategorias) {
                gravador.println(categoria.toCSV());
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
    }
}

