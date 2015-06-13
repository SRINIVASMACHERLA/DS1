package com.cnu.ds.sorting;

public class MergeSortTest {
	public static void main(String[] args) {
		Sort sort = new MergeSort();
		Comparable<?>[] a = { 89, 7, 4, 23, 78, 90, 2, 13 };
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " --> ");
		}
		System.out.println("end");
		System.out.println("---------------------------------");
		sort.sort(a);
		if (sort.isSorted(a)) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " --> ");
			}
			System.out.println("end");
			System.out.println("Total steps count " + sort.count);
		}
	}
}
