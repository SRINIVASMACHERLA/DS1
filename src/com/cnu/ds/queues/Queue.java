package com.cnu.ds.queues;

public interface Queue<Item> extends Iterable<Item> {
	void enqueue(Item item);

	Item dequeue();

	boolean isEmpty();

	int size();

	boolean isFull();
}
