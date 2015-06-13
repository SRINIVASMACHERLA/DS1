package com.cnu.ds.hash.test;

import com.cnu.ds.hash.DoubleHasingHashtable;

public class DoubleHashingTesting {

	public static void main(String[] args) {
		DoubleHasingHashtable hashTable = new DoubleHasingHashtable(0.8f, 67481);
		for (long i = 9999980000L; i <= 9999999999L; i = i + 1) {
			hashTable.put(i);
		}
		long start = System.currentTimeMillis();
		boolean b = hashTable.contains(9999991234L);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken: " + (end - start));
		System.out.println(b);

	}

}
