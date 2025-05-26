import structures.hashTables.*;
import structures.*;
import utils.TxtReader;

public class Main {
    public static void main(String[] args) {
        TxtReader leitor = new TxtReader();
        ArrayList<String> nomes = leitor.lerNomes("src/utils/female_names.txt");

        HashTable tabela1 = new HashTableOne();
        System.out.println("TABELA 1 - Função: length() % capacidade");
        imprimirRelatorio(tabela1, nomes);

        HashTable tabela2 = new HashTableTwo();
        System.out.println("\nTABELA 2 - Função: soma ASCII % capacidade");
        imprimirRelatorio(tabela2, nomes);
    }

    public static void imprimirRelatorio(HashTable table, ArrayList<String> nomes) {
        long inicio = System.nanoTime();
        for (int i = 0; i < nomes.size(); i++) {
            table.inserir(nomes.get(i));
        }
        long fim = System.nanoTime();

        System.out.println("Colisões: " + table.getTotalColisoes());
        System.out.println("Tempo inserção: " + (fim - inicio) + " ns");

        long inicioBusca = System.nanoTime();
        table.buscar("Allys");
        long fimBusca = System.nanoTime();

        System.out.println("Tempo busca: " + (fimBusca - inicioBusca) + " ns");
        imprimirDistribuicao(table);
    }

    public static void imprimirDistribuicao(HashTable tabela) {
        int[] dist = tabela.getDistribuicao();
        for (int i = 0; i < dist.length; i++) {
            System.out.printf("Posição %02d: %d elementos\n", i, dist[i]);
        }
    }
}
