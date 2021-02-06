package com.ssafy;

import java.util.Scanner;

public class JO_1523_별삼각형1 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(n > 100 || n < 1) {
			System.out.println("INPUT ERROR!");
			return;
		}
		switch (m) {
		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n-1-i; j++) {
					System.out.print(" ");
				}
				for (int k = 0; k < i*2+1; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;

		default:
			System.out.println("INPUT ERROR!");
			break;
		}
	}
}