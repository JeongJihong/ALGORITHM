package com.ssafy.NM;

import java.util.Arrays;
import java.util.Scanner;

public class NM1 {

	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int[] arr = new int[M];
	static boolean[] isSelected = new boolean[N];
	 
	public static void main(String[] args) {
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt == arr.length) {
			for(int a : arr)
				System.out.print(a + " ");
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i] == false) {
				arr[cnt] = i+1;
				isSelected[i] = true;
				perm(cnt+1);
				isSelected[i] = false;
			}
		}
	}
}
