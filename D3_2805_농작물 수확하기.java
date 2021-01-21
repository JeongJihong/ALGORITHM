package com.ssafy;

import java.util.Scanner;
import java.io.FileInputStream;

class SWEA {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int ans = 0;
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			String str;

			for (int i = 0; i < N; i++) {
				str = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}

			int skip, r = 0;
			for (int j = 0; j < N / 2 + 1; j++) {
				skip = N / 2 - j;
				for (int k = 0; k < j * 2 + 1; k++) {
					ans += farm[r][skip++];
				}
				++r;
			}
			
			for (int j = N / 2; j >= 1; j--) {
				skip = N / 2 + 1 - j;
				for (int k = 0; k < j * 2 - 1; k++) {
					ans += farm[r][skip++];
				}
				++r;
			}

			System.out.println("#" + t + " " + ans);
		}
	}
}