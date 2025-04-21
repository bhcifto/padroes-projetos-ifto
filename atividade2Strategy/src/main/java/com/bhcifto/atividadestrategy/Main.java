package com.bhcifto.atividadestrategy;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        // BB
        Processador processadorBB = new Processador(new LeituraBB());

        System.out.println("Arquivo BB");
        processadorBB.processar(Main.class.getResource("/banco-brasil-1.csv").toURI());

        System.out.println("*****************************************************************");
        // Bradesco
        Processador processadorBradesco = new Processador(new LeituraBradesco());
        System.out.println("Arquivo Bradesco");
        processadorBradesco.processar(Main.class.getResource("/bradesco-1.csv").toURI());
    }
}