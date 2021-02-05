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
	@Override
	public String toString() {
		return "Ingredient [score=" + score + ", kcal=" + kcal + "]";
	}
	
}

class D3_5215_햄버거다이어트 {

	static int ans, num, limit, sumKcal, sumScore;
	static boolean[] isSelected;
	static Ingredient[] all;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("5215.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			num = sc.nextInt();
			limit = sc.nextInt();
			all = new Ingredient[num];
			isSelected = new boolean[num];
			sumKcal = 0;
			sumScore = 0;
			ans = 0;
			// input
			for (int i = 0; i < all.length; i++) {
				all[i] = new Ingredient(sc.nextInt(), sc.nextInt());
				
			}
			
			power(0);
			
			// output
			System.out.println("#" + tc + " " + ans);
		}
		
	}

	private static void power(int cnt) {
		if(cnt == num) {
			sumKcal = 0;
			sumScore = 0;
			for (int i = 0; i < isSelected.length; i++) {
				if(isSelected[i]) {
					sumKcal += all[i].kcal;
					sumScore += all[i].score;
				}
			}
			if(sumKcal <= limit)
				ans = Math.max(ans, sumScore);
			return;
		}
		
		isSelected[cnt] = true;
		power(cnt+1);
		isSelected[cnt] = false;
		power(cnt+1);
	}
}