package com.bhcifto.atividadestrategy;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LeituraBB implements Leitura{
    @Override
    public List<Boleto> lerArquivo(URI pathArquivo) {
        List<Boleto> boletos = new ArrayList<>();

        try(Stream<String> linhas = Files.lines(Paths.get(pathArquivo))) {
            linhas.forEach(linha -> {
                String[] campos = linha.split(";");

                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(campos[0]));
                boleto.setCodBanco(campos[1]);
                boleto.setDataVencimento(LocalDate.parse(campos[2], DATE_FORMATTER));
                boleto.setDataPagamento(LocalDate.parse(campos[3], DATE_FORMATTER).atStartOfDay());
                boleto.setCpfCliente(campos[4]);
                boleto.setValor(Double.parseDouble(campos[5]));
                boleto.setMulta(Double.parseDouble(campos[6]));
                boleto.setJuros(Double.parseDouble(campos[7]));

                boletos.add(boleto);
            });
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return boletos;
    }
}
