package structures.hashTables;

import structures.ArrayList;

public abstract class HashTable {
    protected int capacidade = 32;
    protected ArrayList<String>[] tabela;
    protected int totalColisoes = 0;

    @SuppressWarnings("unchecked")
    public HashTable() {
        tabela = new ArrayList[capacidade];
        for (int i = 0; i < capacidade; i++) {
            tabela[i] = new ArrayList<>();
        }
    }

    // Cada classe concreta implementa sua própria função hash
    protected abstract int hash(String chave);

    public void inserir(String chave) {
        int pos = hash(chave);

        if (!tabela[pos].isEmpty()) {
            totalColisoes++;
        }

        tabela[pos].add(chave);
    }

    public boolean buscar(String chave) {
        int pos = hash(chave);
        ArrayList<String> bucket = tabela[pos];
        for (int i = 0; i < bucket.toArray().length; i++) {
            if (bucket.get(i).equals(chave)) return true;
        }
        return false;
    }

    public int getTotalColisoes() {
        return totalColisoes;
    }

    public int[] getDistribuicao() {
        int[] distribuicao = new int[capacidade];
        for (int i = 0; i < capacidade; i++) {
            distribuicao[i] = bucketSize(tabela[i]);
        }
        return distribuicao;
    }

    private int bucketSize(ArrayList<String> bucket) {
        int count = 0;
        try {
            while (true) {
                bucket.get(count++);
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }
}
