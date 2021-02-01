package com.ssafy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input
		int s = sc.nextInt();
		int[] stat = new int[s];
		for (int i = 0; i < stat.length; i++) {
			stat[i] = sc.nextInt();
		}

		int studNum = sc.nextInt();
		int[][] stud = new int[studNum][2];
		for (int i = 0; i < studNum; i++) {
			for (int j = 0; j < 2; j++) {
				stud[i][j] = sc.nextInt();
			}
		}
		
		int switchNum = 0, n = 1;
		for (int i = 0; i < studNum; i++) {
			// 만약 남학생이면
			if(stud[i][0] == 1) {
				switchNum = stud[i][1];
				for (int j = 1; switchNum * j <= s; j++) {
					stat[switchNum*j-1] = stat[switchNum*j-1] == 0 ? 1 : 0;
				}
			}
			// 만약 여학생이면 
			else {
				n = 1;
				switchNum = stud[i][1] - 1;
				while(switchNum - n >= 0 && switchNum + n < s && stat[switchNum - n] == stat[switchNum + n]) {
					++n;
				}
				for (int j = switchNum - n +1; j < switchNum + n; j++) {
					stat[j] = stat[j] == 0? 1 : 0;
				}
			}
		}
		
		for (int i = 0; i < s; i++) {
			System.out.print(stat[i] + " ");
			if((i + 1) % 20 == 0)
				System.out.println();
		}
		
	}
	
}
