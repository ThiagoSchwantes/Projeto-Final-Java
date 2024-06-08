package br.edu.up.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.edu.up.models.Pagamento;
import br.edu.up.util.EnvLoader;

public class GerenciadorDePagamentoDAO {
    private String header = "pagamentoId;nomePagamento";
    private String nomeDoArquivo;
    List<Pagamento> listaDePagamentos = new ArrayList<>();

    public GerenciadorDePagamentoDAO() {
        Map<String, String> env = EnvLoader.loadEnvFile("SGOS/.env");
        String csvDirectory = env.get("CSV_DIRECTORY");
        nomeDoArquivo = csvDirectory + "/pagamentos.csv";
    }

    public List<Pagamento> getPagamentos() {
        try {
            File arquivoLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoLeitura);
            if (leitor.hasNextLine()) {
                header = leitor.nextLine();
            }

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                Integer pagamentoId = Integer.parseInt(dados[0]);
                String nomePagamento = dados[1];

                Pagamento pagamento = new Pagamento(pagamentoId, nomePagamento);
                listaDePagamentos.add(pagamento);
            }
            leitor.close();
        } catch(Exception e){
            System.out.println("Arquivo não encontrado! (Pagamento)");
        }
        return listaDePagamentos;
    }

    public void gravarArquivo() {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (Pagamento pagamento : listaDePagamentos) {
                gravador.println(pagamento.toCSV());
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
    }
}
