package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GeradorArquivo {

    public static void main(String[] args) {

        String nomeArquivo = "vendas.csv";
        int totalVendas = 2000; // Total de vendas a serem geradas
        gerarCSVVendas(nomeArquivo, totalVendas);
        System.out.println("Arquivo CSV de vendas gerado com sucesso: " + nomeArquivo);
    }


    public static void gerarCSVVendas(String nomeArquivo, int totalVendas) {
        Random random = new Random();
        String[] produtos = {"Produto A", "Produto B", "Produto C", "Produto D", "Produto E", "Produto F"};
        String[] vendedores = {"Pedro", "Luciana", "Daniel"};
        String[] pagamentos = {"credito", "debito", "dinheiro", "pix"};
        double precoMin = 10.0;
        double precoMax = 100.0;
        int quantidadeMin = 1;
        int quantidadeMax = 10;

        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            // Escrever cabeçalho
            writer.println("ID Venda,Produto,Vendedor,Quantidade,Preco,Pagamento");

            // Gerar dados de vendas aleatórios
            for (int i = 0; i < totalVendas; i++) {
                String idVenda = String.valueOf(i + 1);
                String nomeProduto = produtos[random.nextInt(produtos.length)];
                String nomeVendedor = vendedores[random.nextInt(vendedores.length)];
                int quantidadeVendida = random.nextInt(quantidadeMax - quantidadeMin + 1) + quantidadeMin;
                double precoUnitario = random.nextDouble() * (precoMax - precoMin) + precoMin;
                String formaPagamento = pagamentos[random.nextInt(pagamentos.length)];

                // Escrever linha de venda no arquivo CSV
                writer.printf("%s,%s,%s,%d,%.2f,%s%n", idVenda, nomeProduto, nomeVendedor, quantidadeVendida, precoUnitario, formaPagamento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
