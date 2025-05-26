package structures.hashTables;

public class HashTableTwo extends HashTable {
    @Override
    protected int hash (String chave) {
        int soma = 0;
        for (int i = 0; i < chave.length(); i++) {
            soma += chave.charAt(i);
        }
        return soma % capacidade;
    }
}
