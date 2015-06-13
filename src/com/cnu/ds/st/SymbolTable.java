package com.cnu.ds.st;

public interface SymbolTable<Key, Value> {
	void put(Key key, Value value);

	Value get(Key key);

	boolean contains(Key key);

	boolean isEmpty();

	Iterable<Key> keys();
	int size();

}
