package org.example.atividadeTemplateStrategy;

import java.time.LocalDate;

public class LeituraBB implements Leitura {

    @Override
    public Boleto processarLinhaArquivo(String[] vetorLinhaArq) {
        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArq[0]));
        boleto.setCodBanco(vetorLinhaArq[1]);
        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArq[2], DATE_FORMATTER));
        boleto.setDataPagamento(LocalDate.parse(vetorLinhaArq[3], DATE_FORMATTER).atStartOfDay());
        boleto.setCpfCliente(vetorLinhaArq[4]);
        boleto.setValor(Double.parseDouble(vetorLinhaArq[5]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArq[6]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArq[7]));

        return boleto;
    }
}
