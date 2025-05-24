import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TxtReader {

    public List<String> lerNomesDeArquivo(String nomeArquivo) {
        List<String> nomes = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("utils/" + nomeArquivo);
        if (inputStream == null) {
            System.err.println("Arquivo não encontrado: " + nomeArquivo);
            return nomes;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                nomes.add(linha.trim());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return nomes;
    }
}
