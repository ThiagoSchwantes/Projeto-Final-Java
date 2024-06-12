package br.edu.up.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.edu.up.controllers.ControleDeClientes;
import br.edu.up.controllers.ControleDeFuncionarios;
import br.edu.up.controllers.ControleProdutoDeOrdemServico;
import br.edu.up.models.Cliente;
import br.edu.up.models.Funcionario;
import br.edu.up.models.OrdemDeServico;
import br.edu.up.models.ProdutoOrdemServico;
import br.edu.up.util.EnvLoader;

public class GerenciadorDeOrdemDeSevicoDao {
    private String header = "codigo;dataEHoraAbertura;clienteId;funcionarioId;comentario;produtoOrdemServicoId";
    private String nomeDoArquivo;
    List<OrdemDeServico> listaDeOrdemDeServicos = new ArrayList<>();

    public GerenciadorDeOrdemDeSevicoDao() {
        Map<String, String> env = EnvLoader.loadEnvFile("SGOS/.env");
        String csvDirectory = env.get("CSV_DIRECTORY");
        nomeDoArquivo = csvDirectory + "/ordensDeServicos.csv";
    }

    public List<OrdemDeServico> getOrdemDeServicos() {
        try {
            File arquivoLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoLeitura);
            
            if (leitor.hasNextLine()) {
                header = leitor.nextLine();
            }

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");
                ControleDeClientes controleDeClientes = new ControleDeClientes();
                ControleProdutoDeOrdemServico controleProdutoDeOrdemServico = new ControleProdutoDeOrdemServico();
                ControleDeFuncionarios controleDeFuncionarios = new ControleDeFuncionarios();

                Integer codigo = Integer.parseInt(dados[0]);
                LocalDateTime dataEHoraAbertura = LocalDateTime.parse(dados[1]);
                Cliente cliente = controleDeClientes.buscar(dados[2]); 
                Funcionario funcionario = controleDeFuncionarios.buscar(dados[3]);
                String comentario = dados[4];
                ProdutoOrdemServico produtoOrdemServico = controleProdutoDeOrdemServico.buscar(Integer.parseInt(dados[5]));

                OrdemDeServico ordemDeServico = new OrdemDeServico(codigo, dataEHoraAbertura, cliente, funcionario, comentario, produtoOrdemServico);

                listaDeOrdemDeServicos.add(ordemDeServico);
            }

            leitor.close();
        } catch(Exception e){
            System.out.println("Arquivo não encontrado! (Ordem de Servico)");
        }
        return listaDeOrdemDeServicos;
    }

    public void gravarArquivo() {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (OrdemDeServico ordemDeServico : listaDeOrdemDeServicos) {
                gravador.println(ordemDeServico.toCSV());
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
    }
}
