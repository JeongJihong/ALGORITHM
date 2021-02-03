package com.ssafy.NM;

import java.util.Arrays;
import java.util.Scanner;

public class NM7 {

	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int[] arr = new int[N];
	static int[] sel = new int[M];
	
	static StringBuilder sb = new StringBuilder();
	 
	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if(cnt == sel.length) {
			for(int a : sel)
				sb.append(a + " ");
			sb.append('\n');
			return;
		}
		for (int i = 0; i < N; i++) {
			sel[cnt] = arr[i];
			perm(cnt+1);
		}
	}
}
