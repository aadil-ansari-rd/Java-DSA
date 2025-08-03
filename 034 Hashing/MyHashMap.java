import java.util.*;

public class MyHashMap<K, V> {

    // Node structure for each key-value pair
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next; // For chaining in case of collisions

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<K, V>[] table;     // Array of linked list entries (buckets)
    private int capacity = 4;        // Initial capacity
    private int size = 0;            // Current number of elements
    private float loadFactor = 0.75f;// Load factor threshold for rehashing

    // Constructor to initialize table
    public MyHashMap() {
        table = new Entry[capacity];
    }

    // Hash function to compute index
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> head = table[index];

        // Check if key already exists and update
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert new node at head of chain
        Entry<K, V> newNode = new Entry<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;

        // Trigger rehashing if load factor exceeded
        if ((1.0 * size) / capacity >= loadFactor) {
            rehash();
        }
    }

    // Retrieve value by key
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> head = table[index];

        while (head != null) {
            if (head.key.equals(key)) return head.value;
            head = head.next;
        }
        return null;
    }

    // Return value if key exists, else return default
    public V getOrDefault(K key, V defaultValue) {
        V val = get(key);
        return (val != null) ? val : defaultValue;
    }

    // Check if key exists in map
    public boolean containsKey(Object key) {
        int index = Math.abs(key.hashCode()) % capacity;
        Entry<K, V> head = table[index];

        while (head != null) {
            if (head.key.equals(key)) return true;
            head = head.next;
        }
        return false;
    }

    // Check if any value matches given value
    public boolean containsValue(Object value) {
        for (Entry<K, V> head : table) {
            while (head != null) {
                if (Objects.equals(head.value, value)) return true;
                head = head.next;
            }
        }
        return false;
    }

    // Return set of all keys
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Entry<K, V> head : table) {
            while (head != null) {
                keys.add(head.key);
                head = head.next;
            }
        }
        return keys;
    }

    // Return collection of all values
    public Collection<V> values() {
        List<V> vals = new ArrayList<>();
        for (Entry<K, V> head : table) {
            while (head != null) {
                vals.add(head.value);
                head = head.next;
            }
        }
        return vals;
    }

    // Return set of key-value pairs
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entries = new HashSet<>();
        for (Entry<K, V> head : table) {
            while (head != null) {
                K k = head.key;
                V v = head.value;
                entries.add(new AbstractMap.SimpleEntry<>(k, v));
                head = head.next;
            }
        }
        return entries;
    }

    // Check if map is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Remove key and return associated value
    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> head = table[index];
        Entry<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) prev.next = head.next;
                else table[index] = head.next;
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    // Resize and rehash all existing entries
    private void rehash() {
        Entry<K, V>[] oldTable = table;
        capacity *= 2; // Double the capacity
        size = 0;
        table = new Entry[capacity];

        // Reinsert all entries into new table
        for (Entry<K, V> head : oldTable) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    // Return current number of key-value pairs
    public int size() {
        return size;
    }

    // Generate a combined hash code for the map
    public int hashCode() {
        int hash = 0;
        for (Entry<K, V> head : table) {
            while (head != null) {
                hash += Objects.hashCode(head.key) ^ Objects.hashCode(head.value);
                head = head.next;
            }
        }
        return hash;
    }

    // Print map for debugging
    public void printMap() {
        for (int i = 0; i < capacity; i++) {
            System.out.print("Bucket " + i + ": ");
            Entry<K, V> head = table[i];
            while (head != null) {
                System.out.print("[" + head.key + "=" + head.value + "] -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }

    // Main method to test the map
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // put()
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);
        map.put("apple", 40); // overwrite test

        // get()
        System.out.println("Value for key 'apple': " + map.get("apple")); // 40
        System.out.println("Value for key 'banana': " + map.get("banana")); // 20
        System.out.println("Value for key 'notfound': " + map.get("notfound")); // null

        // getOrDefault()
        System.out.println("GetOrDefault 'banana': " + map.getOrDefault("banana", -1)); // 20
        System.out.println("GetOrDefault 'unknown': " + map.getOrDefault("unknown", -1)); // -1

        // containsKey()
        System.out.println("Contains key 'cherry'? " + map.containsKey("cherry")); // true
        System.out.println("Contains key 'mango'? " + map.containsKey("mango"));   // false

        // containsValue()
        System.out.println("Contains value 20? " + map.containsValue(20)); // true
        System.out.println("Contains value 99? " + map.containsValue(99)); // false

        // size()
        System.out.println("Size: " + map.size()); // 3

        // isEmpty()
        System.out.println("Is empty? " + map.isEmpty()); // false

        // keySet()
        System.out.println("Keys: " + map.keySet()); // [apple, banana, cherry]

        // values()
        System.out.println("Values: " + map.values()); // [40, 20, 30]

        // entrySet()
        System.out.println("Entries:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // remove()
        System.out.println("Removed value for 'banana': " + map.remove("banana")); // 20
        System.out.println("After remove, contains 'banana'? " + map.containsKey("banana")); // false

        // Final map state
        System.out.println("Final map size: " + map.size()); // 2
        System.out.println("Map hashCode: " + map.hashCode());
    }
}


