package com.cnu.ds.hash;

public class DoubleHasingHashtable {

	public void put(Long phonenumber) {
		int hashValue = phonenumber.hashCode();
		int probeSize = hashCode(phonenumber);
		int index = hashValue % capacity;

		if (loadfactor <= (((float) size) / capacity)) {
			rehash(getPrime(capacity * 2));
			System.out.println("new capacity : " + getPrime(capacity));
		}

		while (hashtable[index] != null) {
			hashValue = hashValue + probeSize;
			index = hashValue % capacity;
			System.out.println(probeSize);
		}
		// finds empty place
		hashtable[index] = phonenumber;
		size++;
	}

	private int hashCode(Long key) {
		return (int) (89L - key % 89L);
	}

	public boolean contains(Long key) {
		int hashValue = key.hashCode();
		int probeSize = hashCode(key);
		int index = hashValue % capacity;
		while (hashtable[index] != null) {
			Long entry = hashtable[index];
			if (entry.equals(key)) {
				return true;
			}
			hashValue = hashValue + probeSize;
			index = hashValue % capacity;
		}
		return false;
	}

	public DoubleHasingHashtable(float loadfactor, int capacity) {
		this.capacity = capacity;
		hashtable = new Long[capacity];
	}

	private void rehash(int newCapacity) {
		Long newHashtable[] = new Long[newCapacity];
		for (int i = 0; i < capacity; i++) {
			Long entry = hashtable[i];
			if (entry != null) {
				int hashValue = entry.hashCode();
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

	private Long hashtable[];
	private int capacity = 11;
	private float loadfactor = 0.75f;
	private int size;

	public DoubleHasingHashtable() {
		this(0.75f, 11);
	}

}
