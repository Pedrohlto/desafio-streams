package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Venda> vendas = lerVendasDoArquivo("vendas.csv");
    }

    public static List<Venda> lerVendasDoArquivo(String nomeArquivo) {
        List<Venda> vendas = null;
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            vendas = br.lines()
                    .skip(1) // Pular cabeçalho
                    .map(line -> {
                        String[] campos = line.split(",");
                        return new Venda(campos[0], campos[1], campos[2], Integer.parseInt(campos[4]), Double.parseDouble(campos[5]), campos[6]);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendas;
    }
}
