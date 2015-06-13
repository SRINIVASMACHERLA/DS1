package com.cnu.ds.hash;

public interface IHashTable<K, V> {
	void put(K key, V value);

	boolean contains(K key);

	V remove(K key);
}
