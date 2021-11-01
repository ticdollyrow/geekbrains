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
        int index = hashFunc(key);


        if (data[index] == null) {
            data[index] = new Item<>(key, value, null);
            size++;
            return true;
        }
        Item<K,V> element = data[index];
        do{
            if(isKeysEquals(element, key)){
                element.setValue(value);
                return true;
            }
        }while (element.next != null);

        data[index] = new Item<>(key, value, element);
        size++;
        return true;
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == emptyEntry) {
            return false;
        }
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }


    @Override
    public V get(K key) {

        int index = indexOf(key);
        if (index == -1) {
            return null;
        }

        Item<K,V> element;
        element = data[index];
        while (element != null){
            if(isKeysEquals(element,key)){
                return element.getValue();
            }
            element = element.next;
        }

        return null;
    }

    private int indexOf(K key) {
        int index = hashFunc(key);

        return  index;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }

        Item<K,V> element;
        Item<K,V> elementPrev = null;

        element = data[index];
        while (!isKeysEquals(element,key) && element != null){
            elementPrev = element;
            element = element.next;
        }

        if (element == null ){
            return null;
        }

        if( elementPrev == null){
            data[index] = element.next;
            element.next = emptyEntry;
            size--;
        } else{
            elementPrev.next = element.next;
            element.next = emptyEntry;
        }



        return element.getValue();
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        Item<K,V> element;
        for (int i = 0; i < data.length; i++) {

            element = data[i];
            while (element != null){
                System.out.printf("%d = [%s]%n", i, element);
                element = element.next;
            }
        }
    }
}
