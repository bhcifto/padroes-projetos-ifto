package com.bhcifto.atividadestrategyfunctional;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        // BB
        Processador processadorBB = new Processador(Processador::lerArquivoBB);

        System.out.println("Arquivo BB");
        processadorBB.processar(Main.class.getResource("/banco-brasil-1.csv").toURI());

        System.out.println("*****************************************************************");
        // Bradesco
        Processador processadorBradesco = new Processador(Processador::lerArquivoBradesco);
        System.out.println("Arquivo Bradesco");
        processadorBradesco.processar(Main.class.getResource("/bradesco-1.csv").toURI());
    }
}