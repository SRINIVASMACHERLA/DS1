package com.cnu.ds.hash;

public class Combinations {
	public void combinations(int a[], int n, int r, int s, int e) {
		if (r == 0) {
			return;
		}
		for (int i = s; i < e - r + 1; i++) {
			combinations(a, n, r, i + 1, e);
			for (int j = s; j < r; j++) {
				
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 6 };
		Combinations combinations = new Combinations();
	}
}
