package com.hashtable;

import java.util.TreeMap;

public class HashTable<K, V> {

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    public HashTable(int M) {
        this.M = M;
        this.size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(K key, V value) {
        TreeMap map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V value = null;
        if (map.containsKey(key)) {
            value = map.remove(key);
            size--;
        }

        return value;
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }
    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.add("1", 1);
        //table.add(1, 2);
        Float a = new Float(2);
        a.hashCode();
    }
}
