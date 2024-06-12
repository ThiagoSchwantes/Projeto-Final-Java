package br.edu.up.daos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.edu.up.controllers.ControleDeAcabamento;
import br.edu.up.controllers.ControleDeEquipamento;
import br.edu.up.controllers.ControleDeProduto;
import br.edu.up.models.Acabamento;
import br.edu.up.models.Equipamento;
import br.edu.up.models.Produto;
import br.edu.up.models.ProdutoOrdemServico;
import br.edu.up.util.EnvLoader;

public class GerenciadorDeProdutosOrdemServico {
    private String header = "produtoOrdemServicoId;produtoId;quantidade;largura;altura;valorM2;equipamentoId;acabamentoId";
    private String nomeDoArquivo;
    List<ProdutoOrdemServico> listaProdutosOrdemDeServico = new ArrayList<>();

    public GerenciadorDeProdutosOrdemServico() {
        Map<String, String> env = EnvLoader.loadEnvFile("SGOS/.env");
        String csvDirectory = env.get("CSV_DIRECTORY");
        nomeDoArquivo = csvDirectory + "/produtosOrdemServico.csv";
    }

    public List<ProdutoOrdemServico> getProdutosOrdemServico() {
        try {
            File arquivoLeitura = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivoLeitura);
            
            if (leitor.hasNextLine()) {
                header = leitor.nextLine();
            }

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] dados = linha.split(";");
                ControleDeProduto controleDeProduto = new ControleDeProduto();
                ControleDeEquipamento controleDeEquipamento = new ControleDeEquipamento();
                ControleDeAcabamento controleDeAcabamento = new ControleDeAcabamento();

                Integer produtoOrdemServicoId = Integer.parseInt(dados[0]);
                Integer produtoId = Integer.parseInt(dados[1]);
                Produto produto = controleDeProduto.buscar(produtoId);
                Integer quantidade = Integer.parseInt(dados[2]);
                Double largura = Double.parseDouble(dados[3]);
                Double altura = Double.parseDouble(dados[4]);
                Double valorM2 = Double.parseDouble(dados[5]);
                Integer equipamentoId = Integer.parseInt(dados[6]);
                Equipamento equipamento = controleDeEquipamento.buscar(equipamentoId);
                Integer acabamentoId = Integer.parseInt(dados[7]);
                Acabamento acabamento = controleDeAcabamento.buscar(acabamentoId);

                ProdutoOrdemServico produtoOrdemServico = new ProdutoOrdemServico(produto, quantidade, largura, altura, valorM2, equipamento, acabamento);
                produtoOrdemServico.setProdutoOrdemServicoId(produtoOrdemServicoId);

                listaProdutosOrdemDeServico.add(produtoOrdemServico);
            }

            leitor.close();
        } catch(Exception e){
            System.out.println("Arquivo não encontrado! (Ordem de Servico)");
        }
        return listaProdutosOrdemDeServico;
    }

        public void gravarArquivo() {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);
            gravador.println(header);

            for (ProdutoOrdemServico produtoOrdemServico : listaProdutosOrdemDeServico) {
                gravador.println(produtoOrdemServico.toCSV());
            }
            gravador.close();
        } catch (IOException e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
    }
}
