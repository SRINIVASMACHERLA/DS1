package com.cnu.ds.sorting;

public class SelectionClient {
	public static void main(String[] args) {
		Selection selection = new Selection();
		Comparable<?>[] a = { 3, 2, 5, -1, 0, 34, 9 };

		selection.sort(a);
		System.out.println(selection.isSorted(a));
	}
}
