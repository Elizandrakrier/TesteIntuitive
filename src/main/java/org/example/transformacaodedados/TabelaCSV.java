package org.example.transformacaodedados;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TabelaCSV {
    public void salvarCSV(String arquivoCSV, List<String[]>dados) throws IOException{
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(arquivoCSV))){
            for (String[] linha: dados) {
                csvWriter.writeNext(linha);
            }
        }
    }
}
