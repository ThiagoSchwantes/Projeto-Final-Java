package br.edu.up.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.Acabamento;

public class GerenciadorDeAcabamentoDAO {
    private String header = "acabamentoId;nomeAcabamento;descricao";
    private String nomeDoArquivo = "C:\\Projeto-Final-Java\\SGOS\\src\\br\\edu\\up\\daos\\csvs\\acabamentos.csv";
    List<Acabamento> listaDeAcabamentos = new ArrayList<>();

    public List<Acabamento> getAcabamentos() {
        try {
            File arquivoLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoLeitura);
            if (leitor.hasNextLine()) {
                header = leitor.nextLine();
            }

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");
                
                Integer acabamentoId = Integer.parseInt(dados[0]);
                String nomeAcabamento = dados[1];
                String descricao = dados[2];

                Acabamento acabamento = new Acabamento(acabamentoId, nomeAcabamento, descricao);
                listaDeAcabamentos.add(acabamento);
            }
            leitor.close();
        } catch(Exception e){
            System.out.println("Arquivo não encontrado!");
        }
        return listaDeAcabamentos;
    }

    public void gravarArquivo() {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (Acabamento acabamento : listaDeAcabamentos) {
                gravador.println(acabamento.toCSV());
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
    }
    
}
