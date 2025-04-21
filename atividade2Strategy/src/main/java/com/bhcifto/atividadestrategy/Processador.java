package com.bhcifto.atividadestrategy;

import java.net.URI;

public class Processador {
    private Leitura leitura;

    public Processador(Leitura leitura) {
        this.leitura = leitura;
    }

    public void processar (URI pathArquivo) {
        System.out.println(leitura.lerArquivo(pathArquivo));
    }

    public Leitura getLeitura() {
        return leitura;
    }

    public void setLeitura(Leitura leitura) {
        this.leitura = leitura;
    }
}
