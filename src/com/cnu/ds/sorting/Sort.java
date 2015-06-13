package com.cnu.ds.sorting;

@SuppressWarnings("rawtypes")
abstract public class Sort {
	int count;

	protected boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (less(a[i], a[i + 1])) {
				continue;
			}
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	protected boolean less(Comparable i, Comparable j) {
		return i.compareTo(j) < 0;
	}

	protected void excahnge(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	protected void sort(Comparable<?>[] a) {

	}
}
