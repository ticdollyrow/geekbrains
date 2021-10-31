package gb.algorithms.hashtable;

public class HashTableImpl<K, V> implements HashTable<K, V> {


    static class Item<K, V> implements Entry<K, V> {


        private final K key;
        private V value;
        public Item(K key, V value) {
            this.key = key;
            this.value = value;
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
        this.data = new Item[initialCapacity * 2];
        emptyEntry = new Item<>(null, null);
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int index = hashFunc(key);

        while (data[index] != null) {
            if (isKeysEquals(data[index], key)) {
                data[index].setValue(value);
                return true;
            }
            index += getStep(key);
            index %= data.length;
        }

        data[index] = new Item<>(key, value);
        size++;
        return true;
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == emptyEntry) {
            return false;
        }
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }

    protected int getStep(K key) {
        return 1;
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode()) % data.length;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == -1 ? null : data[index].getValue();
    }

    private int indexOf(K key) {
        int index = hashFunc(key);

        int count = 0;
        while (count < data.length) {
            Item<K,V> item = data[index];
            if ( item == null) {
                break;
            } else if (isKeysEquals(data[index], key)) {
                return index;
            }

            count++;
            index += getStep(key);
            index %= data.length;
        }

        return -1;
    }


    @Override
    public V remove(K key) {
        int index = indexOf(key);

        if (index == -1) {
            return null;
        }
        Item<K, V> temp = data[index];
        data[index] = emptyEntry;

        return temp.getValue();
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
        System.out.println("--------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]);
        }
        System.out.println("--------------------------");
    }
}
