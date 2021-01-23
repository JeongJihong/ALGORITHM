package com.ssafy;

import java.util.Scanner;

class SWEA {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String str = sc.next();
			StringBuffer pw = new StringBuffer(str);
			
			for (int i = 0; i < pw.length() - 1; i++) {
				char first = pw.charAt(i);
				char second = pw.charAt(i+1);
				
				if(first == second) {
					pw.delete(i, i + 2);
					i = -1;
				}
				if(pw.length() == 4)
					break;
			}
			System.out.println("#" + tc + " " + pw);
		}
		sc.close();
	}
}