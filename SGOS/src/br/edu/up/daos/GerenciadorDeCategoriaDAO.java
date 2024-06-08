package br.edu.up.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.edu.up.models.Categoria;
import br.edu.up.util.EnvLoader;

public class GerenciadorDeCategoriaDAO {
    private String header = "categoriaId;nomeCategoria;descricao";
    private String nomeDoArquivo;
    List<Categoria> listaDeCategorias = new ArrayList<>();

    public GerenciadorDeCategoriaDAO() {
        Map<String, String> env = EnvLoader.loadEnvFile("SGOS/.env");
        String csvDirectory = env.get("CSV_DIRECTORY");
        nomeDoArquivo = csvDirectory + "/categorias.csv";
    }

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
            System.out.println("Arquivo não encontrado! (Categoria)");
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
