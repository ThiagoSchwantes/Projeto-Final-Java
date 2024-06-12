package br.edu.up.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.edu.up.controllers.ControleDeCategoria;
import br.edu.up.models.Categoria;
import br.edu.up.models.Produto;
import br.edu.up.util.EnvLoader;

public class GerenciadorDeProdutosDAO {
    private String header = "produtoId;nomeProduto;descricao;categoria";
    private String nomeDoArquivo;
    List<Produto> listaDeProdutos = new ArrayList<>();

    public GerenciadorDeProdutosDAO() {
        Map<String, String> env = EnvLoader.loadEnvFile("SGOS/.env");
        String csvDirectory = env.get("CSV_DIRECTORY");
        nomeDoArquivo = csvDirectory + "/produtos.csv";
    }

    public List<Produto> getProdutos() {
        ControleDeCategoria controleDeCategoria = new ControleDeCategoria();
        try {
            File arquivoLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoLeitura);
            if (leitor.hasNextLine()) {
                header = leitor.nextLine();
            }

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                Integer produtoId = Integer.parseInt(dados[0]);
                String nomeProduto = dados[1];
                String descricao = dados[2];
                String nomeCategoria = dados[3];

                Categoria categoria = controleDeCategoria.getCategorias().stream()
                        .filter(c -> c.getNomeCategoria().equals(nomeCategoria))
                        .findFirst()
                        .orElse(null);

                Produto produto = new Produto(produtoId, nomeProduto, descricao, categoria);
                listaDeProdutos.add(produto);
            }
            leitor.close();
        } catch(Exception e){
            System.out.println("Arquivo não encontrado! (Produto)");
        }
        return listaDeProdutos;
    }

    public void gravarArquivo() {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (Produto produto : listaDeProdutos) {
                gravador.println(produto.toCSV());
            }
            
            gravador.close();
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
    }
}
