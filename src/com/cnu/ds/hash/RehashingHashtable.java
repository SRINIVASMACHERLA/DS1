package com.cnu.ds.hash;

public class RehashingHashtable<K, V> implements IHashTable<K, V> {

	@Override
	public void put(K key, V value) {
		int hashValue = key.hashCode();
		int index = hashValue % capacity;

		if (loadfactor <= (((float) size) / capacity)) {
			// System.out.println("______________________________________________");
			// System.out.print("Current table size : " + size + "  ");
			// System.out.println((((float) size) / capacity));
			// System.out.println("Current table capacity : " + capacity +
			// "  ");
			// System.out.println("New Capacity : " + capacity);
			// System.out.println("______________________________________________");
			rehash(getPrime(capacity));
		}

		while (hashtable[index] != null) {
			hashValue = hashValue + 1;
			index = hashValue % capacity;
		}
		// finds empty place
		Entry<K, V> entry = new Entry<>(key, value);
		hashtable[index] = entry;
		size++;
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

	public RehashingHashtable(int loadfactor) {
	}

	@SuppressWarnings("unchecked")
	public RehashingHashtable() {
		capacity = 11;
		hashtable = new Entry[capacity];
	}

	@SuppressWarnings("unchecked")
	private void rehash(int newCapacity) {
		Entry<K, V> newHashtable[] = new Entry[newCapacity];
		for (int i = 0; i < capacity; i++) {
			Entry<K, V> entry = hashtable[i];
			if (entry != null) {
				int hashValue = entry.getKey().hashCode();
				int index = hashValue % newCapacity;
				while (newHashtable[index] != null) {
					hashValue = hashValue + 1;
					index = hashValue % newCapacity;
				}
				newHashtable[index] = entry;
			}
		}
		hashtable = newHashtable;
		capacity = newCapacity;
	}

	private int getPrime(int capacity) {
		for (int i = capacity + 2; true; i += 2) {
			if (isPrime(i)) {
				return i;
			}
		}
	}

	private boolean isPrime(int num) {
		int factors = 1;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				factors++;
			}
			if (factors > 1) {
				return false;
			}
		}
		return true;
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

	private Entry<K, V> hashtable[];
	private int capacity;
	private float loadfactor = 0.75f;
	private int size;
}
