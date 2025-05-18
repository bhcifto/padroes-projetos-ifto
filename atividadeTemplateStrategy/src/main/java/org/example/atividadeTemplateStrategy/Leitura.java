package org.example.atividadeTemplateStrategy;

import java.time.format.DateTimeFormatter;

public interface Leitura {
    DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    Boleto processarLinhaArquivo(String[] vetorLinhaArq);
}
