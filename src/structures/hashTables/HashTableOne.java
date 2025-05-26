package structures.hashTables;

public class HashTableOne extends HashTable {
    @Override
    protected int hash(String chave) {
        return chave.length() % capacidade;
    }
}
