package com.ssafy;

import java.util.Scanner;

public class D5_1247_최적경로 {

	static int customerNum, minDist = Integer.MAX_VALUE;
	static int[][] Loc;
	static int[] sel;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			minDist = Integer.MAX_VALUE;
			// input 받기
			customerNum = sc.nextInt();
			Loc = new int[customerNum + 2][2];
			sel = new int[customerNum];
			isSelected = new boolean[customerNum];
			for (int i = 0; i < customerNum + 2; i++) {
				Loc[i][0] = sc.nextInt();
				Loc[i][1] = sc.nextInt();
			}

			// 고객좌표의 순열구하기
			customerOrder(0);

			// output
			System.out.println("#" + tc + " " + minDist);
		}
		sc.close();
	}
	
	private static void customerOrder(int k) {
		if (k == sel.length) {
			minDist = calcAllDist(Loc, sel) < minDist ? calcAllDist(Loc, sel) : minDist;
			return;
		}

		for (int i = 0; i < customerNum; i++) {
			if (isSelected[i] == false) {
				sel[k] = i;
				isSelected[i] = true;
				customerOrder(k + 1);
				isSelected[i] = false;
			}
		}

	}

	private static int calcAllDist(int[][] loc, int[] sel) {
		int sum = calcDistance(0, sel[0]+2);
		for (int i = 0; i < sel.length - 1; i++) {
			sum += calcDistance(sel[i]+2, sel[i+1]+2);
		}
		sum +=calcDistance(sel[sel.length-1]+2, 1);
		return sum;
	}

	private static int calcDistance(int n1, int n2) {
		return Math.abs(Loc[n1][0] - Loc[n2][0]) + Math.abs(Loc[n1][1] - Loc[n2][1]);
	}
}