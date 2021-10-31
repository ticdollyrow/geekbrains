package gb.algorithms.hashtable;

public class DoubleHashTable<K, V> extends HashTableImpl<K, V> {
    public DoubleHashTable(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    protected int getStep(K key) {
        return hashDoubleFunc(key);
    }

    private int hashDoubleFunc(K key) {
        return 5 - (key.hashCode() % 5);
    }
}
