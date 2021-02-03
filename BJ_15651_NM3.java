package com.ssafy.NM;

import java.util.Scanner;

public class NM3 {

	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int[] arr = new int[M];
	static StringBuilder sb = new StringBuilder();
	 
	public static void main(String[] args) {
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if(cnt == arr.length) {
			for(int a : arr)
				sb.append(a + " ");
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[cnt] = i+1;
			perm(cnt+1);
		}
	}
}
