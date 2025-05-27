package structures.hashTables;

import structures.ArrayList;

public abstract class HashTable {
    protected final int CAPACIDADE_MAXIMA = 32;
    protected final double LIMITE_FATOR_CARGA = 0.75;
    protected int capacidade = 8;
    protected int totalElementos = 0;
    protected int totalColisoes = 0;
    protected ArrayList<String>[] tabela;

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
        if ((double) totalElementos / capacidade >= LIMITE_FATOR_CARGA && capacidade < CAPACIDADE_MAXIMA) {
            redimensionar();
        }

        int pos = hash(chave);

        if (!tabela[pos].isEmpty()) {
            totalColisoes++;
        }

        tabela[pos].add(chave);
        totalElementos++;
    }

    public boolean buscar(String chave) {
        int pos = hash(chave);
        ArrayList<String> bucket = tabela[pos];
        for (int i = 0; i < bucket.toArray().length; i++) {
            if (bucket.get(i).equals(chave)) return true;
        }
        return false;
    }

    public boolean remover(String chave) {
        int pos = hash(chave);
        ArrayList<String> bucket = tabela[pos];
        for (int i = 0; i < bucket.toArray().length; i++) {
            if (bucket.get(i).equals(chave)) {
                bucket.remove(i);
                totalElementos--;
                return true;
            }
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

    private void redimensionar() {
        int novaCapacidade = Math.min(capacidade * 2, CAPACIDADE_MAXIMA);
        ArrayList<String>[] novaTabela = new ArrayList[novaCapacidade];
        for (int i = 0; i < novaCapacidade; i++) {
            novaTabela[i] = new ArrayList<>();
        }

        for (int i = 0; i < capacidade; i++) {
            ArrayList<String> bucket = tabela[i];
            for (int j = 0; j < bucket.toArray().length; j++) {
                String chave = bucket.get(j);
                int novaPos = hash(chave) % novaCapacidade;

                if (!novaTabela[novaPos].isEmpty()) {
                    totalColisoes++;
                }

                novaTabela[novaPos].add(chave);
            }
        }

        tabela = novaTabela;
        capacidade = novaCapacidade;
    }
}
