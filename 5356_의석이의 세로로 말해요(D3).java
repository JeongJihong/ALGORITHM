package com.ssafy;

import java.util.Scanner;

public class SWEA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans;
		int maxLen = 0;
		int T;
		T=sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			char[][] board = new char[5][];
			for (int i = 0; i < 5; i++) {
				String str = sc.next();
				board[i] = new char[str.length()];
				maxLen = Math.max(maxLen,str.length());
				for (int j = 0; j < str.length(); j++) {
					board[i][j] = str.charAt(j);
				}
			}
			System.out.print("#" + tc + " ");
			
			for (int i = 0; i < maxLen; i++) {
				for (int j = 0; j < 5; j++) {
					if(i < board[j].length)
						System.out.print(board[j][i]);
				}
			}
			System.out.println();
		}
	}

}
