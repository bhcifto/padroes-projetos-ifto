package com.bhcifto.atividadestrategy;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LeituraBradesco implements Leitura{
    @Override
    public List<Boleto> lerArquivo(URI pathArquivo) {
        List<Boleto> boletos = new ArrayList<>();

        try(Stream<String> linhas = Files.lines(Paths.get(pathArquivo))) {
            linhas.forEach(linha -> {
                String[] campos = linha.split(";");

                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(campos[0]));
                boleto.setCodBanco(campos[1]);
                boleto.setAgencia(campos[2]);
                boleto.setContaBancaria(campos[3]);
                boleto.setDataVencimento(LocalDate.parse(campos[4], DATE_FORMATTER));
                boleto.setDataPagamento(LocalDateTime.parse(campos[5], DATE_TIME_FORMATTER));
                boleto.setCpfCliente(campos[6]);
                boleto.setValor(Double.parseDouble(campos[7]));
                boleto.setMulta(Double.parseDouble(campos[8]));
                boleto.setJuros(Double.parseDouble(campos[9]));

                boletos.add(boleto);
            });
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return boletos;
    }
}
