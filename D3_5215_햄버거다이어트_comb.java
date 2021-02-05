package com.ssafy;

import java.io.FileInputStream;
import java.util.Scanner;

//햄버거 다이어트

class Ingredient {
	int score, kcal;

	public Ingredient() {}

	public Ingredient(int score, int kcal) {
		super();
		this.score = score;
		this.kcal = kcal;
	}
}

class D3_5215_햄버거다이어트_comb {

	static int ans, num, limit, sumKcal, sumScore;
	static Ingredient[] all;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("5215.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			num = sc.nextInt();
			limit = sc.nextInt();
			all = new Ingredient[num];
			sumKcal = 0;
			sumScore = 0;
			ans = 0;
			// input
			for (int i = 0; i < all.length; i++) {
				all[i] = new Ingredient(sc.nextInt(), sc.nextInt());
			}

			for (int i = 1; i <= num; i++) {
				comb(0, 0, i, new Ingredient[i]);
			}

			// output
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static void comb(int cnt, int start, int n, Ingredient[] sel) {
		if (cnt == n) {
			sumKcal = 0;
			sumScore = 0;
			for (int i = 0; i < n; i++) {
				sumKcal += sel[i].kcal;
				sumScore += sel[i].score;
			}
			if (sumKcal <= limit) {
				ans = Math.max(ans, sumScore);
			}
			return;
		}

		for (int i = start; i < all.length; i++) {
			sel[cnt] = new Ingredient(all[i].score, all[i].kcal);
			comb(cnt + 1, i + 1, n, sel);
		}
	}
}