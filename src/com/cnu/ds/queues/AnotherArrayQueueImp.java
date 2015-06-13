package com.cnu.ds.queues;

public class AnotherArrayQueueImp<Item> extends ArrayQueue<Item> {

	public AnotherArrayQueueImp(int N) {
		super(N);
	}

	@Override
	public void enqueue(Item item) {
		if (isFull()) {
			throw new RuntimeException("Queue is Full");
		}
		if (rear == -1) {
			front++;
		}
		rear = (rear + 1) % N;
		queue[rear] = item;
	}

	@Override
	public Item dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		}
		Item item = queue[front];
		queue[front] = null;
		front = (front + 1) % N;
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean isFull() {
		return (rear + 1) % N == front;
	}

	@Override
	public int size() {
		return (N + rear - front + 1) % N;
	}

}
