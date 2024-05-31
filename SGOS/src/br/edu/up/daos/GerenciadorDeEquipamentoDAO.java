package br.edu.up.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.Equipamento;

public class GerenciadorDeEquipamentoDAO {
    private String header = "equipamentoId;nomeEquipamento;descricao";
    private String nomeDoArquivo = "C:\\Projeto-Final-Java\\SGOS\\src\\br\\edu\\up\\daos\\csvs\\equipamentos.csv";
    List<Equipamento> listaDeEquipamentos = new ArrayList<>();

    public List<Equipamento> getEquipamentos() {
        try {
            File arquivoLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoLeitura);
            if (leitor.hasNextLine()) {
                header = leitor.nextLine();
            }

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");
                
                Integer equipamentoId = Integer.parseInt(dados[0]);
                String nomeEquipamento = dados[1];
                String descricao = dados[2];

                Equipamento equipamento = new Equipamento(equipamentoId, nomeEquipamento, descricao);
                listaDeEquipamentos.add(equipamento);
            }
            leitor.close();
        } catch(Exception e){
            System.out.println("Arquivo não encontrado!");
        }
        return listaDeEquipamentos;
    }

    public void gravarArquivo() {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (Equipamento equipamento : listaDeEquipamentos) {
                gravador.println(equipamento.toCSV());
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
    }
}

