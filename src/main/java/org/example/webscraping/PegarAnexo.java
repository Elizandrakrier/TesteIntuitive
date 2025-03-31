package org.example.webscraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PegarAnexo {
    private final String link;

    public PegarAnexo(String  link) {
        this.link = link;
    }

    public Map<String, String> pegarLinks() throws IOException {
        Document doc = Jsoup.connect(link).get();
        Elements links = doc.select("a[href$=.pdf]");

        Map<String, String> mapAnexos = new HashMap<>();
        for (Element link : links) {
            String anexo = link.text().trim();
            String urlLink = link.absUrl("href");

            if (anexo.contains("Anexo I.")){
                mapAnexos.put("anexo1.pdf",  urlLink);
            }else if (anexo.contains("Anexo II")){
                mapAnexos.put("anexo2.pdf", urlLink);
            }
        }
        return mapAnexos;
    }
}
