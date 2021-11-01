package gb.algorithms.hashtable.homework;

import gb.algorithms.hashtable.HashTable;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;
        private Item<K,V> next;

        public Item(K key, V value, Item next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }

    }

    private final Item<K, V>[] data;
    private final Item<K, V> emptyEntry;
    private int size;

    public HashTableImpl(int initialCapacity) {
        this.data = new Item[initialCapacity];
        emptyEntry = new Item<>(null, null, null);
    }

    public HashTableImpl() {
        this(16);
    }


    private int hashFunc(K key) {
        return Math.abs(key.hashCode()) % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void display() {

    }
}
