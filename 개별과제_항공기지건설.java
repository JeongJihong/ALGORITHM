package com.ssafy;

import java.util.*;

public class Example {

	public static void main(String[] args) {
		
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {	// Test Case 개수만큼 반복
			
			int N = sc.nextInt();			// get Information
			int K = sc.nextInt();
			int [][] m = new int[N][N];
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					m[j][j2] = sc.nextInt();
				}
			}
			
			int sum = 0, ans = 0, p;
			for (int i = N - 1; i >= 0; i--) {	// 직사각형 뒷부분
				for (int j = N - 1; j >= 0; j--) {
					for (int k = 0; k < i + 1; k++) {	//직사각형 앞부분
					L: for (int l = 0; l < j + 1; l++) {
							sum = 0;
							min = Integer.MAX_VALUE;
							max = Integer.MIN_VALUE;
							for (p = k; p < i + 1; p++) {	//max-min
								for (int q = l; q < j + 1; q++) {
									min = Math.min(min, m[p][q]);
									max = Math.max(max, m[p][q]);
									if(m[p][q] - min > K || max - m[p][q] > K) {
										continue L;
									}
									sum++;
								}
							} 
							if(p == i + 1) {
								ans = Math.max(sum, ans);
								continue L;
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
		
		sc.close();

	}
	
}
