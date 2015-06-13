package com.cnu.ds.st;

import java.util.Iterator;

public class SequentailSearchST<Key, Value> implements SymbolTable<Key, Value> {
	private Node first;
	private int count;

	@Override
	public void put(Key key, Value value) {
		Node node = first;
		for (; node != null; node = node.next) {
			if (key.equals(node.key)) {
				node.value = value;
				return;
			}
		}
		first = new Node(key, value, first);
		count++;
	}

	@Override
	public Value get(Key key) {
		Node node = first;
		for (; node != null; node = node.next) {
			if (key.equals(node.key)) {
				return node.value;
			}
		}

		return null;
	}

	@Override
	public boolean contains(Key key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public Iterable<Key> keys() {
		return new NodeIterable();
	}

	class Node {
		Key key;
		Value value;
		Node next;

		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	@Override
	public int size() {
		return count;
	}

	class NodeIterable implements Iterable<Key> {

		@Override
		public Iterator<Key> iterator() {
			return new NodeIterator();
		}
	}

	class NodeIterator implements Iterator<Key> {
		Node node = first;

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public Key next() {
			Key key = node.key;
			node = node.next;
			return key;
		}

		@Override
		public void remove() {
		}

	}

}
