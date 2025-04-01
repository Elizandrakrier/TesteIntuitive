package org.example.webscraping;

import java.io.IOException;
import java.util.Map;

public class TesteWebScraping {
    public static void main(String[] args) {

        PegarAnexo pegarAnexo = new PegarAnexo("https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos");
        BaixarAnexo baixarAnexo = new BaixarAnexo();
        CompactacaoAnexo compactacaoAnexo = new CompactacaoAnexo();

        try {
            Map<String, String> anexos = pegarAnexo.pegarLinks();

            if (anexos.size() == 2) {
                for (Map.Entry<String, String> entry : anexos.entrySet()) {
                    baixarAnexo.baixar(entry.getValue(), entry.getKey());
                }
                compactacaoAnexo.compactar(
                        anexos.keySet().toArray(new String[0]),
                        "anexos.zip"
                );
                System.out.println("Finalizado com sucesso.");
            }else {
                System.out.println("Anexos não encontrados");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
