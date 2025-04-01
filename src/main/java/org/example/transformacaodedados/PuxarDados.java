package org.example.transformacaodedados;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PuxarDados {
    private final File arquivoPdf;

    public PuxarDados(File arquivoPdf) {
        this.arquivoPdf = arquivoPdf;
    }

    public String puxarTexto() throws IOException {
        try (PDDocument document = PDDocument.load(arquivoPdf)) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }
}
