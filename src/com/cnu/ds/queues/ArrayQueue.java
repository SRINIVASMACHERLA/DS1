package com.cnu.ds.queues;

import java.util.Iterator;

public class ArrayQueue<Item> implements Queue<Item> {
	protected Item[] queue;
	protected int size;
	protected int N;
	protected int front, rear;
	protected int modCount;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int N) {
		queue = (Item[]) new Object[N];
		this.N = N;
		front = rear = -1;
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	@Override
	public void enqueue(Item item) {
		if (isFull()) {
			throw new RuntimeException("Queue is Full");
		}
		if (rear == -1) {
			front++;
		}
		rear = rear == N - 1 ? 0 : rear + 1;
		queue[rear] = item;
		size++;
		modCount++;
	}

	@Override
	public Item dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		}
		Item item = queue[front];
		queue[front] = null;
		front = front == N - 1 ? 0 : front + 1;
		size--;
		modCount++;
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isFull() {
		return size == N;
	}

	private class QueueIterator implements Iterator<Item> {
		int tempCount;
		int tempFront = front;
		int capacity = N;
		int expectedModCount = modCount;

		@Override
		public boolean hasNext() {
			return tempCount != size;
		}

		@Override
		public Item next() {
			if (tempCount <= size) {
				checkModCountVerification();
				Item ele = queue[tempFront];
				tempFront = (tempFront + 1) % capacity;
				tempCount++;
				return ele;
			}
			throw new RuntimeException("Unsupported Operation");
		}

		void checkModCountVerification() {
			if (modCount != expectedModCount) {
				throw new RuntimeException(
						"Concurrent Modification Operation is not supported");
			}
		}

		@Override
		public void remove() {
			throw new RuntimeException("UnSupported Operation");
		}

	}
}
