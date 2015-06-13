package com.cnu.ds.hash.test;

import com.cnu.ds.hash.HashTable;

public class HashtableTest {
	public static void main(String[] args) {
		HashTable<Integer, Integer> hashTable = new HashTable<>();
		for (int i = 0; i < 121 * 121 * 121; i = i + 11) {
			hashTable.put(i, i);
		}
		long start = System.currentTimeMillis();
		boolean b = hashTable.contains(1111110);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken: " + (end - start));
		System.out.println(b);
	}
}
