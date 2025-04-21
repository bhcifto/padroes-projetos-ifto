package com.bhcifto.atividadestrategy;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface Leitura {
    DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    List<Boleto> lerArquivo(URI pathArquivo);
}
