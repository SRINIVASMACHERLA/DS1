package com.cnu.ds.st;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements
		ExtandedSymbolTable<Key, Value> {
	Key[] keys;
	Value[] values;
	int N;
	int size;

	@SuppressWarnings("unchecked")
	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Comparable[capacity];
		N = capacity;
	}

	@Override
	public void put(Key key, Value value) {

	}

	@Override
	public Value get(Key key) {
		int rank = rank(key);
		if (rank >= 0 && rank < size && keys[rank].compareTo(key) == 0) {
			return values[rank];
		}
		return null;
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public Iterable<Key> keys() {
		Queue<Key> queue = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			queue.add(keys[i]);
		}
		return queue;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Key min() {
		return keys[0];
	}

	@Override
	public Key max() {
		return keys[size - 1];
	}

	@Override
	public Key floor(Key key) {
		return null;
	}

	@Override
	public Key ceiling(Key key) {
		return null;
	}

	@Override
	public int rank(Key key) {
		return rank(key, 0, size);
	}

	private int rank(Key key, int i, int j) {
		if (i > j) {
			return i;
		}
		int mid = (i + j) << 2;
		int cmp = keys[mid].compareTo(key);
		if (cmp < 0) {
			return rank(key, mid + 1, j);
		} else if (cmp > 0) {
			return rank(key, i, mid - 1);
		}
		return mid;
	}

	@Override
	public void deleteMin() {
		for (int i = 1; i < size; i++) {
			keys[i - 1] = keys[i];
			values[i - 1] = values[i];
		}
	}

	@Override
	public void deleteMax() {
		keys[size] = null;
		values[size] = null;
		size--;
	}

}
