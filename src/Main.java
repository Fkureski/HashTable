import hashTables.*;
import structures.*;
import utils.TxtReader;

public class Main {
    public static void main(String[] args) {
        TxtReader leitor = new TxtReader();
        ArrayList<String> nomes = leitor.lerNomes("src/utils/female_names.txt");

        HashTable tabela1 = new HashTableOne();
        HashTable tabela2 = new HashTableTwo();

        long inicio1 = System.nanoTime();
        for (int i = 0; i < nomes.size(); i++) {
            tabela1.inserir(nomes.get(i));
        }
        long fim1 = System.nanoTime();

        long inicio2 = System.nanoTime();
        for (int i = 0; i < nomes.size(); i++) {
            tabela2.inserir(nomes.get(i));
        }
        long fim2 = System.nanoTime();

        System.out.println("TABELA 1 - Função: length() % capacidade");
        System.out.println("Colisões: " + tabela1.getTotalColisoes());
        System.out.println("Tempo inserção: " + (fim1 - inicio1) + " ns");
        imprimirDistribuicao(tabela1);

        System.out.println("\nTABELA 2 - Função: soma ASCII % capacidade");
        System.out.println("Colisões: " + tabela2.getTotalColisoes());
        System.out.println("Tempo inserção: " + (fim2 - inicio2) + " ns");
        imprimirDistribuicao(tabela2);
    }

    public static void imprimirDistribuicao(HashTable tabela) {
        int[] dist = tabela.getDistribuicao();
        for (int i = 0; i < dist.length; i++) {
            System.out.printf("Posição %02d: %d elementos\n", i, dist[i]);
        }
    }
}
