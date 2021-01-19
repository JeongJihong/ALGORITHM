package com.ssafy;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	// 입력
		int T = sc.nextInt();
		int [][] arr = new int[T][10];
		int [] oddSum = new int[T];
		
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 10;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < T; i++) {			// 홀수 덧셈
			for (int j = 0; j < 10;j++) {
				if (arr[i][j] % 2 != 0)
					oddSum[i] += arr[i][j];
			}
		}
		
		for (int i = 0; i < T; i++) {			// 출력
			System.out.println("#" + (i + 1) + " " + oddSum[i]);
		}
	}

}
