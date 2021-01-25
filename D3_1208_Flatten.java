package com.ssafy;

import java.util.Scanner;
import java.util.Stack;

class SWEA {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int SIZE = 100;

		for (int tc = 1; tc <= 10; tc++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int maxIdx = 0, minIdx = 0;
			int[] dump = new int[SIZE];
			int cnt = sc.nextInt();
			for (int i = 0; i < SIZE; i++)
				dump[i] = sc.nextInt();

			for (int i = 0; i < cnt; i++) {
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				for (int j = 0; j < SIZE; j++) {
					if(dump[j] > max) {
						max = dump[j];
						maxIdx = j;
					}
					if(dump[j] < min) {
						min = dump[j];
						minIdx = j;
					}
				}
				if(max - min <= 1)
					break;
				dump[maxIdx]--;
				dump[minIdx]++;
			}
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int j = 0; j < SIZE; j++) {
				if(dump[j] > max) {
					max = dump[j];
					maxIdx = j;
				}
				if(dump[j] < min) {
					min = dump[j];
					minIdx = j;
				}
			}
			System.out.println("#" + tc + " " + (max - min));
		}
		sc.close();
	}
}