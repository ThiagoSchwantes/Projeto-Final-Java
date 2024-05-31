package br.edu.up.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.*;

public class GereciadorDeClientesDAO {
    private String header = "";
    private String localArquivo = "C:\\Projeto-Final-Java\\SGOS\\src\\br\\edu\\up\\daos\\csvs\\clientes.csv";
    List<Cliente> listaDeClientes = new ArrayList<>();

    public List<Cliente> getClientes(){

        try {
            File arquivoLeitura = new File(localArquivo);
            Scanner leitor = new Scanner(arquivoLeitura);
            header = leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");
                
                Integer clienteId = Integer.parseInt(dados[0]);
                String nomeCliente = dados[1];
                String rg = dados[2];
                String cpf = dados[3];
                String cep = dados[4];
                String endereco = dados[5];
                String bairro = dados[6];
                String cidade = dados[7];

                Cliente cliente = new Cliente(clienteId, nomeCliente, rg, cpf, cep, endereco, bairro, cidade);
                listaDeClientes.add(cliente);
            }
            leitor.close();
        } catch(Exception e){
            System.out.println("Arquivo não encontrado!");
        }
        return listaDeClientes;
    }

    public void gravarArquivo(){
        
        try {

            FileWriter arquivoGravar = new FileWriter(localArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (Cliente cliente : listaDeClientes) {
                gravador.println(cliente.toCSV());
            }
            gravador.close();

        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
    }
}
