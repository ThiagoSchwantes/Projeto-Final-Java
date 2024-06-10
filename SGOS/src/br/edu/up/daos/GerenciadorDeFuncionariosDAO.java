package br.edu.up.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.edu.up.models.Cliente;
import br.edu.up.models.Funcionario;
import br.edu.up.util.EnvLoader;

public class GerenciadorDeFuncionariosDAO {

    private String header = "";
    private String localArquivosFuncionarios;
    List<Funcionario> listaDeFuncionarios = new ArrayList<>();

    public GerenciadorDeFuncionariosDAO() {
        Map<String, String> env = EnvLoader.loadEnvFile("SGOS/.env");
        String csvDirectory = env.get("CSV_DIRECTORY");
        localArquivosFuncionarios = csvDirectory + "/funcionarios.csv";
    }

    public List<Funcionario> getFuncionarios() {
        try {
            File arquivoLeitura = new File(localArquivosFuncionarios);
            Scanner leitor = new Scanner(arquivoLeitura);
            header = leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");

                Integer funcionarioId = Integer.parseInt(dados[0]);
                String nomeFuncionario = dados[1];
                String rg = dados[2];
                String cpf = dados[3];
                String cep = dados[4];
                String endereco = dados[5];
                String bairro = dados[6];
                String cidade = dados[7];

                Funcionario funcionario = new Funcionario(funcionarioId, nomeFuncionario, rg, cpf, cep, endereco, bairro, cidade);
                listaDeFuncionarios.add(funcionario);
            }
            leitor.close();
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado!");
        }
        return listaDeFuncionarios;
    }

    public void gravarArquivo() {
        try {
            FileWriter arquivoGravar = new FileWriter(localArquivosFuncionarios);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (Funcionario funcionario : listaDeFuncionarios) {
                gravador.println(funcionario.toCSV());
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
    }

}
