package org.example.webscraping;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BaixarAnexo {
    public void baixar(String link, String arquivo) throws IOException {
        try (InputStream in = new URL(link).openStream()){
            Files.copy(in, new File(arquivo).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
