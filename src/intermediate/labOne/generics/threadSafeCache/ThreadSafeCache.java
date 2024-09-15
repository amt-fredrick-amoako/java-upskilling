package intermediate.labOne.generics.threadSafeCache;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeCache<K, V> {
    private final ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void remove(K key) {
        cache.remove(key);
    }

    public void clear() {
        cache.clear();
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeCache<String, String> cache = new ThreadSafeCache<>();

        // Thread to add key-value pairs to the cache
        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cache.put("key" + i, "value" + i);
            }
        });

        // Thread to read key-value pairs from the cache
        Thread readerThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("key" + i + ": " + cache.get("key" + i));
            }
        });

        // Thread to remove key-value pairs from the cache
        Thread removerThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                cache.remove("key" + i);
            }
        });

        // Start all threads
        writerThread.start();
        readerThread.start();
        removerThread.start();

        // Wait for all threads to finish
        writerThread.join();
        readerThread.join();
        removerThread.join();

        // Final check to see if the cache is empty
        System.out.println("Cache is empty: " + cache.cache.isEmpty());
    }
}



