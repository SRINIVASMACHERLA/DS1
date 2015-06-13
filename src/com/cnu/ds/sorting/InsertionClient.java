package com.cnu.ds.sorting;

public class InsertionClient {
	public static void main(String[] args) {
		Sort sort = new Insertion();
		Comparable<?>[] a = { 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L' };
		sort.sort(a);
		System.out.println(sort.isSorted(a));
	}
}
