package org.example.transformacaodedados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompactacaoDados {
    public void compactarDados(String[] anexos, String anexoZip) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(anexoZip);
             ZipOutputStream zipOut = new ZipOutputStream(fileOut)) {

            for (String anexo: anexos) {
                File fileZip = new File(anexo);
                try (FileInputStream fileIn = new FileInputStream(fileZip)){
                    ZipEntry zipEntry = new ZipEntry(fileZip.getName());
                    zipOut.putNextEntry(zipEntry);

                    byte[] blocoBuffer = new byte[1024];
                    int length;
                    while ((length = fileIn.read(blocoBuffer)) >= 0) {
                        zipOut.write(blocoBuffer, 0,  length);
                    }
                }
            }
        }
    }
}
