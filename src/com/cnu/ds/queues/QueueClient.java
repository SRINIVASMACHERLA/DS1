package com.cnu.ds.queues;


public class QueueClient {
	public static void main(String[] args) {
		Queue<Integer> queue = new ListQueue<>();
		for (int i = 1; i <= 6; i++) {
			queue.enqueue(i * 10);
		}

		for (Integer el : queue) {
			System.out.println(el);
		}
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
//		Vector<Integer> vector = new Vector<>();
//		vector.add(100);
//		vector.add(200);
//		vector.add(300);
//		for (Integer integer : vector) {
//			System.out.println(integer);
//			vector.remove(0);
//		}

		System.out.println("1 Enqueue");
		for (Integer el : queue) {
			 queue.enqueue(12);
			System.out.println(el);
//			queue.dequeue();
		}
		queue.enqueue(1213);
		queue.enqueue(1242);
		// queue.enqueue(1252);
		// queue.enqueue(1262);

		System.out.println("2 Enqueue");
		for (Integer el : queue) {
			System.out.println(el);
		}
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		if (queue.isEmpty()) {
			System.out.println("Wow its empty again");
		}
	}
}
