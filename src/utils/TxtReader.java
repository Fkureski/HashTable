package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import structures.ArrayList;

public class TxtReader {

    public ArrayList<String> lerNomes(String caminhoRelativo) {
        ArrayList<String> nomes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoRelativo))) {
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
