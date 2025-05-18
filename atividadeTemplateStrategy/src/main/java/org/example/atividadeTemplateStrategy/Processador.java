package org.example.atividadeTemplateStrategy;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Processador {
    private Leitura leitura;

    public Processador(Leitura leitura) {
        this.leitura = leitura;
    }

    public void processar (URI pathArquivo) {
        List<Boleto> boletos = new ArrayList<>();

        try(Stream<String> linhas = Files.lines(Paths.get(pathArquivo))) {
            linhas.forEach(linha -> {
                String[] vetorLinhaArq = linha.split(";");

                boletos.add(leitura.processarLinhaArquivo(vetorLinhaArq));
            });
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        System.out.println(boletos);
    }

    public Leitura getLeitura() {
        return leitura;
    }

    public void setLeitura(Leitura leitura) {
        this.leitura = leitura;
    }
}
