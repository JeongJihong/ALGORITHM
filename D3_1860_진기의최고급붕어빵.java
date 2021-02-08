package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N, M, K, breadNum = 0, cnt, start;
		int[] person;
		String ans = "";
		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			ans = "";
			// input
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			person = new int[N];
			for (int i = 0; i < person.length; i++) {
				person[i] = sc.nextInt();
			}
			Arrays.sort(person);
			breadNum = 0;
			start = 1;
			for (int i = 0; i < person.length; i++) {
				for (int j = start; j <= person[i]; j++) {
					if(j % M == 0)	breadNum += K;
				}
				if(breadNum > 0) {
					--breadNum;
					++cnt;
				}
				start = person[i]+1;
			}
			if(cnt == person.length)	ans = "Possible";
			else						ans = "Impossible"; 
			System.out.println("#" + tc + " " + ans);
		}
	}
}


