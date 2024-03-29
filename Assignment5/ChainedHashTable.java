// ChainedHashTable.java
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ChainedHashTable<K, V> {
    // Table of buckets
    private SinglyLinkedList<KeyValuePair<K, V>>[] table;

    private int size;
    // added private members necessary to auto-grow
    private double maxLoadFactor;
    private int resizeMultiplier;
    private int buckets;

    public ChainedHashTable() {
        this(997, 1, 2);  // A prime number of buckets
    }

    // a) modify contructor to take two additional parameters
    @SuppressWarnings("unchecked")
    public ChainedHashTable(int buckets, double maxLoadFactor, int resizeMultiplier) {
        // Create table of empty buckets
        table = new SinglyLinkedList[buckets];
        for (int i = 0; i < table.length; ++i) {
            table[i] = new SinglyLinkedList<KeyValuePair<K, V>>();
        }

        this.maxLoadFactor = maxLoadFactor;
        this.resizeMultiplier = resizeMultiplier;
        this.buckets = buckets;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public double getMaxLoadFactor() {
        return maxLoadFactor;
    }

    public int getResizeMultiplier() {
        return resizeMultiplier;
    }

    public int getBuckets() {
        return buckets;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    @SuppressWarnings("unchecked")
    public void insert(K key, V value) throws
            IllegalArgumentException,
            DuplicateKeyException {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }
        if (contains(key)) {
            throw new DuplicateKeyException();
        }

        // check if maxLoadFactor has been exceeded
        if (((1.0 * this.size + 1) / this.buckets) > this.maxLoadFactor) {
            // swap old table
            SinglyLinkedList<KeyValuePair<K, V>>[] temp = table;

            // make a new table with the larger size
            SinglyLinkedList<KeyValuePair<K, V>>[] new_table;
            buckets = buckets * resizeMultiplier;  // update the buckets attribute
            new_table = new SinglyLinkedList[buckets];
            for (int i = 0; i < new_table.length; ++i) {
                new_table[i] = new SinglyLinkedList<KeyValuePair<K, V>>();
            }
            
            // reassign table to new table
            this.table = new_table;

            // iterate over old table and insert all key-value pairs into new table
            for (SinglyLinkedList<KeyValuePair<K, V>> sll : temp) {
                while (!sll.isEmpty()) {
                    KeyValuePair<K, V> kv = sll.removeHead();
                    getBucket(kv.getKey())
                    .insertHead(
                        new KeyValuePair<K, V>(
                            kv.getKey(),
                            kv.getValue()
                        )
                    );
                }
            }
            // delete temp table
            temp = null;
            // add latest element
            insert(key, value);
        } else {
            getBucket(key).insertHead(new KeyValuePair<K, V>(key, value));
            ++size;
        }
    }

    public V remove(K key) throws
            IllegalArgumentException,
            NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }

        // If empty bucket
        SinglyLinkedList<KeyValuePair<K, V>> bucket = getBucket(key);
        if (bucket.isEmpty()) {
            throw new NoSuchElementException();
        }

        // If at head of bucket
        SinglyLinkedList<KeyValuePair<K, V>>.Element elem = bucket.getHead();
        if (key.equals(elem.getData().getKey())) {
            --size;
            return bucket.removeHead().getValue();
        }

        // Scan rest of bucket
        SinglyLinkedList<KeyValuePair<K, V>>.Element prev = elem;
        elem = elem.getNext();
        while (elem != null) {
            if (key.equals(elem.getData().getKey())) {
                --size;
                return bucket.removeAfter(prev).getValue();
            }
            prev = elem;
            elem = elem.getNext();
        }

        throw new NoSuchElementException();
    }

    public V lookup(K key) throws
            IllegalArgumentException,
            NoSuchElementException {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }

        // Scan bucket for key
        SinglyLinkedList<KeyValuePair<K, V>>.Element elem =
                getBucket(key).getHead();
        while (elem != null) {
            if (key.equals(elem.getData().getKey())) {
                return elem.getData().getValue();
            }
            elem = elem.getNext();
        }

        throw new NoSuchElementException();
    }

    public boolean contains(K key) {
        try {
            lookup(key);
        } catch (IllegalArgumentException ex) {
            return false;
        } catch (NoSuchElementException ex) {
            return false;
        }

        return true;
    }

    // b) change mapping method to multiplication
    private SinglyLinkedList<KeyValuePair<K, V>> getBucket(K key) {
        // change to multiplication method
        double A = (Math.sqrt(5) - 1) / 2;
        int bkt = (int)Math.floor(this.buckets * (key.hashCode() * A % 1));
        return table[bkt];
        //return table[Math.abs(key.hashCode()) % table.length];
    }

    private class KeysIterator implements Iterator<K> {
        private int remaining;  // Number of keys remaining to iterate
        private int bucket;     // Bucket we're iterating
        private SinglyLinkedList<KeyValuePair<K, V>>.Element elem;
                                // Position in bucket we're iterating

        public KeysIterator() {
            remaining = ChainedHashTable.this.size;
            bucket = 0;
            elem = ChainedHashTable.this.table[bucket].getHead();
        }

        public boolean hasNext() {
            return remaining > 0;
        }

        public K next() {
            if (hasNext()) {
                // If we've hit end of bucket, move to next non-empty bucket
                while (elem == null) {
                    elem = ChainedHashTable.this.table[++bucket].getHead();
                }

                // Get key
                K key = elem.getData().getKey();

                // Move to next element and decrement entries remaining
                elem = elem.getNext();
                --remaining;

                return key;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public Iterable<K> keys() {
        return new Iterable<K>() {
            public Iterator<K> iterator() {
                return new KeysIterator();
            }
        };
    }
}
