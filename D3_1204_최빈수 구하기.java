package com.ssafy;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		int T = sc.nextInt();
		int score = 0;
		int [] frequent = new int[101];
		
		for (int i = 0; i < T; i++) {
			int caseNum = sc.nextInt();
			int max = 0;
			
			for (int j = 0; j < frequent.length; j++) {	//초기화
				frequent[j] = 0;
			}
			
			for (int j = 0; j < 1000; j++) {
				score = sc.nextInt();
				frequent[score]++;
			}
			for (int j = 0; j < 101; j++) {
				max = Math.max(max, frequent[j]);
			}
			for (score = 100; score >= 0; score--) {
				if(max == frequent[score])
					break;
			}
			System.out.println("#" + caseNum + " " + score);
		}
		sc.close();
	}

}