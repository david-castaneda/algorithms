package templates;

import java.util.HashMap;
import java.util.Map;

class LRUNode<K, V> {
    K key;
    V value;
    LRUNode<K, V> next;
    LRUNode<K, V> prev;
}

class LRUCache<K, V> {

    private final Integer capacity;
    private final Map<K, LRUNode<K, V>> map;
    private LRUNode<K, V> head;
    private LRUNode<K, V> tail;

    public LRUCache() {
        this.capacity = 3;
        this.map = new HashMap<>();
    }

    public LRUCache(Integer capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    // return the value for a key (and mark it as recently accessed).
    V get(K key) {
        return null;
    }

    // insert new key/value.
    // if cache is full remove least recently accessed item.
    void put(K key, V value) {
    }
}

public class LRU {

    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>();

        cache.put("john", 20);

        System.out.println("Cache value: " + cache.get("john"));
    }

}
