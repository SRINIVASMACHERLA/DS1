package com.cnu.ds.st;

public interface ExtandedSymbolTable<Key, Value> extends
		SymbolTable<Key, Value> {
	Key min();

	Key max();

	Key floor(Key key);

	Key ceiling(Key key);

	int rank(Key key);

	void deleteMin();

	void deleteMax();
}
