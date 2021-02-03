package com.ssafy.NM;

import java.util.Scanner;

public class NM2 {

	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int[] arr = new int[M];

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		comb(0, 0);
		System.out.println(sb);
	}

	private static void comb(int k, int cnt) {
		if (k == arr.length) {
			for (int a : arr)
				sb.append(a + " ");
			sb.append('\n');
			return;
		}
		for (int i = cnt; i < N; i++) {
			arr[k] = i + 1;
			comb(k + 1, i + 1);
		}
	}
}
