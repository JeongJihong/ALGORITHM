package com.ssafy;

import java.util.Scanner;

class SWEA {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int move = 0;
			int key, ac, speed = 0;
			for (int i = 0; i < N; i++) {
				key = sc.nextInt();
				switch (key) {
				case 0:
					move += speed;
					break;
				case 1:
					ac = sc.nextInt();
					speed += ac;
					move += speed;
					break;
				case 2:
					ac = sc.nextInt();
					speed = speed - ac < 0 ? 0 : speed - ac;
					move += speed;
					break;
				}
			}

			System.out.println("#" + tc + " " + move);
		}
		sc.close();
	}
}