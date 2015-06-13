package com.cnu.ds.hash.openaddressing;

import com.cnu.ds.hash.IHashTable;

public class QuadraticHashtable<K, V> implements IHashTable<K, V> {

	@Override
	public void put(K key, V value) {
		int hashValue = key.hashCode();
		int probeStepSize = 0;
		int index = hashValue % capacity + probeStepSize;
		while (hashtable[index] != null) {
			probeStepSize = probeStepSize + 1;
			probeStepSize = (int) Math.pow(probeStepSize, 2);
			hashValue = hashValue + probeStepSize;
			index = hashValue % capacity;
		}
		// finds empty place
		Entry<K, V> entry = new Entry<>(key, value);
		hashtable[index] = entry;
	}

	@Override
	public boolean contains(K key) {
		int hashValue = key.hashCode();
		int index = hashValue % capacity;
		while (hashtable[index] != null) {
			Entry<K, V> entry = hashtable[index];
			if (entry.getKey().equals(key)) {
				return true;
			}
			hashValue = hashValue + 1;
			index = hashValue % capacity;
		}
		return false;
	}

	@Override
	public V remove(K key) {
		return null;
	}

	static class Entry<K, V> {
		private K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

	}

	public QuadraticHashtable(int loadfactor) {
	}

	@SuppressWarnings("unchecked")
	public QuadraticHashtable() {
		capacity = 104399;
		hashtable = new Entry[capacity];
	}

	private Entry<K, V> hashtable[];
	private int capacity;
}
