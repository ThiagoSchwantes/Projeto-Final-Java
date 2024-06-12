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
import br.edu.up.models.ClienteEmpresa;
import br.edu.up.models.ClientePessoa;
import br.edu.up.util.EnvLoader;

public class GerenciadorDeClientesDAO {
    private String header = "";
    private String localArquivoClientes;
    List<Cliente> listaDeClientes = new ArrayList<>();

    public GerenciadorDeClientesDAO() {
        Map<String, String> env = EnvLoader.loadEnvFile("SGOS/.env");
        String csvDirectory = env.get("CSV_DIRECTORY");
        localArquivoClientes = csvDirectory + "/clientes.csv";
    }

    public List<Cliente> getClientes() {
        try {
            File arquivoLeitura = new File(localArquivoClientes);
            Scanner leitor = new Scanner(arquivoLeitura);
            header = leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");
                Integer clienteId = Integer.parseInt(dados[0]);
                String nomeCliente = dados[1];
                String cep = dados[2];
                String endereco = dados[3];
                String bairro = dados[4];
                String cidade = dados[5];

                if (dados[6].equals("")) { 
                    String rg = dados[9];
                    String cpf = dados[10];
                    ClientePessoa clientePessoa = new ClientePessoa(clienteId, nomeCliente, cep, endereco, bairro, cidade, rg, cpf);
                    listaDeClientes.add(clientePessoa);
                } else{ 
                    String cnpj = dados[6];
                    String inscricaoEstadual = dados[7];
                    int anoFundacao = Integer.parseInt(dados[8]);
                    ClienteEmpresa clienteEmpresa = new ClienteEmpresa(clienteId, nomeCliente, cep, endereco, bairro, cidade, cnpj, inscricaoEstadual, anoFundacao);
                    listaDeClientes.add(clienteEmpresa);
                }
            }
            leitor.close();
        } catch(Exception e){
            System.out.println("Arquivo não encontrado! (Cliente)");
        }
        return listaDeClientes;
    }

    public void gravarArquivo() {
        try {
            FileWriter arquivoGravar = new FileWriter(localArquivoClientes);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (Cliente cliente : listaDeClientes) {
                if(cliente instanceof ClienteEmpresa){
                    ClienteEmpresa clienteEmpresa = (ClienteEmpresa) cliente;
                    gravador.println(clienteEmpresa.toCSV());
                }else if(cliente instanceof ClientePessoa){
                    ClientePessoa clientePessoa = (ClientePessoa) cliente;
                    gravador.println(clientePessoa.toCSV());
                }
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!" + e);
        }
    }
}
