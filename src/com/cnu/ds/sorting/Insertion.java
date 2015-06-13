package com.cnu.ds.sorting;

public class Insertion extends Sort {
	public void sort(Comparable<?>[] a) {
		int j = 0;
		for (int i = 0; i < a.length - 1; i++) {
			Comparable<?> ele = a[i + 1];
			for (j = i; j >= 0 && less(ele, a[j]); j--)
				a[j + 1] = a[j];
			a[j + 1] = ele;
		}
	}
}
