package com.cnu.ds.queues;


public class AnotherQueueClient {
	public static void main(String[] args) {
		Queue<Integer> queue = new AnotherArrayQueueImp<>(5);
		for (int i = 1; i <= 5; i++) {
			queue.enqueue(i * 10);
		}
		for (Integer el : queue) {
			System.out.println(el);
		}
		System.out.println();
		for (Integer el : queue) {
			System.out.println(el);
		}
		queue.dequeue();
		System.out.println("After first dequeue");
		for (Integer el : queue) {
			System.out.println(el);
		}
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		System.out.println("After dequeuing all");
		if (queue.isEmpty()) {
			System.out.println("Wow queue is empty");
		} else
			for (Integer el : queue) {
				System.out.println(el);
			}

		System.out.println("Size is "+queue.size());
		
//		queue.enqueue(21);
//		System.out.println("Enqeue ");
//		for (Integer el : queue) {
//			System.out.println(el);
//		}
	}
}
