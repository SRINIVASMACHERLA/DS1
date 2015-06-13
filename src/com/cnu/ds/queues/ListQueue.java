package com.cnu.ds.queues;

import java.util.Iterator;

public class ListQueue<Item> implements Queue<Item> {

	private int size;
	private Node front;
	private Node rear;
	private int modCount;

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	@Override
	public void enqueue(Item item) {
		if (front == null) {
			front = rear = new Node(item, null);
		} else {
			rear.next = new Node(item, null);
			rear = rear.next;
		}
		size++;
		modCount++;
	}

	@Override
	public Item dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		}
		Item item = front.item;
		front = front.next;
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
		return false;
	}

	private class Node {
		Item item;
		Node next;

		public Node(Item item, Node next) {
			super();
			this.item = item;
			this.next = next;
		}

	}

	private class QueueIterator implements Iterator<Item> {
		private Node current = front;
		private int expectedModCount = modCount;
		private int currentCount;

		@Override
		public boolean hasNext() {
			checkModCountVerification();
			return currentCount != size;
		}

		@Override
		public Item next() {
			Item item = current.item;
			checkModCountVerification();
			if (current == null) {
				throw new RuntimeException("NoSuchElementException");
			}
			current = current.next;
			currentCount++;
			return item;
		}

		void checkModCountVerification() {
			if (modCount != expectedModCount) {
				throw new RuntimeException(
						"Concurrent Modification Operation is not supported");
			}
		}

		@Override
		public void remove() {
			throw new RuntimeException("Unsupported Exception");
		}

	}
}
