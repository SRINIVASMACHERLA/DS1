package com.cnu.ds.sorting;

/**
 * @author cnu8
 * @see It is the improved version of {@link MergeSort}
 */
public class MergeSortVersion2 extends Sort {

	private static Comparable<?>[] aux;

	@Override
	protected void sort(Comparable<?>[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	protected void sort(Comparable<?>[] a, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			sort(a, low, mid);
			sort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
	}

	private void merge(Comparable<?>[] a, int low, int mid, int high) {
		// !less(a[mid], a[mid + 1]) : No merge required if the last element of
		// first array is
		// less than or equal to the first element of second array. Because the
		// complete array is already in sorted order
		// !a[mid].equals(a[mid + 1]) -- check for equality of the above two
		// elements
		if (!less(a[mid], a[mid + 1]) || !a[mid].equals(a[mid + 1])) {
			for (int i = low; i <= high; i++) {
				aux[i] = a[i];
			}
			int i = low, j = mid + 1, k = low;
			while (i <= mid && j <= high) {
				if (less(aux[i], aux[j])) {
					a[k] = aux[i];
					i++;
				} else {
					a[k] = aux[j];
					j++;
				}
				k++;
			}
			while (i <= mid) {
				a[k] = aux[i];
				i++;
				k++;
			}
			while (j <= high) {
				a[k] = aux[j];
				j++;
				k++;
			}
		}
		// Testing the output of array : a after merging
		// for (int k2 = low; k2 <= high; k2++) {
		// System.out.print(a[k2]);
		// }
		// System.out.println();
	}

	public static void main(String[] args) {
		char[] aa = "MERGEEXAMPLE".toCharArray();
		System.out.println("Before Sort");
		Comparable<?>[] a = new Comparable[aa.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = aa[i];
		}
		for (Comparable<?> comparable : a) {
			System.out.print(comparable);
		}
		System.out.println();
		MergeSortVersion2 mergeSortVersion2 = new MergeSortVersion2();
		mergeSortVersion2.sort(a);
		if (mergeSortVersion2.isSorted(a)) {
			System.out.println("After Sort:");
			for (Comparable<?> comparable : a) {
				System.out.print(comparable);
			}
		} else {
			System.out.println("Array is not sorted");
		}
	}
}
