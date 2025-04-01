package org.example.transformacaodedados;

import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TransformarDados {
    public static void main(String[] args) {
        File anexoPdf = new File("anexo1.pdf");
        PuxarDados puxarDados = new PuxarDados(anexoPdf);
        TabelaCSV tabelaCSV = new TabelaCSV();
        TabelaDados tabelaDados = new TabelaDados();
        CompactacaoDados compactacaoDados = new CompactacaoDados();

        try {
            String texto = puxarDados.puxarTexto();
            List<String[]> dados = tabelaDados.rodarTextoNaTabela(texto);

            String anexoCsv = "saida.csv";
            tabelaCSV.salvarCSV(anexoCsv, dados);

            compactacaoDados.compactarDados(new String[] {anexoCsv}, "anexo.zip");

            System.out.println("Transformação concluída.");
        } catch (IOException e) {
            System.out.println("Errp ao processar: " +e.getMessage());
            e.printStackTrace();
        }
    }
}
