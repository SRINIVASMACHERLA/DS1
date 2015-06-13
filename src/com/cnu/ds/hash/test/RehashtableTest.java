package com.cnu.ds.hash.test;

import com.cnu.ds.hash.Employee;
import com.cnu.ds.hash.RehashingHashtable;

public class RehashtableTest {
	public static void main(String[] args) {
		RehashingHashtable<Long, Long> hashTable = new RehashingHashtable<>();
		for (long i = 0; i < 9999999999L; i = i + 1) {
			hashTable.put(i, i);
		}
		long start = System.currentTimeMillis();
		boolean b = hashTable.contains(1111110L);
		long end = System.currentTimeMillis();
		System.out.println("Time Taken: " + (end - start));
		System.out.println(b);
		Employee employee = new Employee();
		employee.setEmployeeID(987654321);
		employee.setName("cnu");
		System.out.println(employee.hashCode());
	}
}
