package com.ssafy.NM;

import java.util.Arrays;
import java.util.Scanner;

public class NM5 {

	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int[] arr = new int[N];
	static int[] sel = new int[M];
	static boolean[] isSelected = new boolean[N];
	 
	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt == sel.length) {
			for(int a : sel)
				System.out.print(a + " ");
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i] == false) {
				sel[cnt] = arr[i];
				isSelected[i] = true;
				perm(cnt+1);
				isSelected[i] = false;
			}
		}
	}
}
