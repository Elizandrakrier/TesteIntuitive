package org.example.transformacaodedados;

import java.util.ArrayList;
import java.util.List;

public class TabelaDados {

    public List<String[]> rodarTextoNaTabela(String texto) {
        List<String[]> linhasDaTabela = new ArrayList<>();
        String[] linhas = texto.split("\n");

        for (String linha: linhas) {
            String[] colunas = linha.trim().split("\\s{2,}");

            for (int i = 0; i < colunas.length; i++) {
                if(colunas[i].equals("OD"))
                    colunas[i] = "Odontologico";
                if(colunas[i].equals("AMB"))
                    colunas[i] = "Ambulatorial";
            }

            if (colunas.length >= 4) {
                linhasDaTabela.add(colunas);
            }
        }
        return linhasDaTabela;
    }
}
