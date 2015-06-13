package com.cnu.ds.sorting;

import java.util.Arrays;

public class MergeSort extends Sort {

	@Override
	protected void sort(Comparable<?>[] a) {
		sort(a, 0, a.length - 1);
	}

	protected void sort(Comparable<?>[] a, int lo, int hi) {
		count++;
		if (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			System.out.println(lo + " " + mid + " " + hi);
			sort(a, lo, mid);
			sort(a, mid + 1, hi);
			merge(a, lo, mid, hi);
		}
	}

	protected void merge(Comparable<?>[] a, int lo, int mid, int hi) {
		Comparable<?> aux[] = Arrays.copyOf(a, a.length);
		int i = lo, k = lo;
		int j = mid + 1;
		while (k <= hi) {
			count++;
			if (j > hi) {
				a[k++] = aux[i++];
			} else if (i > mid) {
				a[k++] = aux[j++];
			} else if (less(aux[i], aux[j])) {
				a[k++] = aux[i++];
			} else {
				a[k++] = aux[j++];
			}
		}
	}

}
