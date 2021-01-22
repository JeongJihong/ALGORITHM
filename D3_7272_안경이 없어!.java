package com.ssafy;

import java.util.Scanner;

class SWEA {
	static String zero = "CEFGHIJKLMNSTUVWXYZ";
	static String one = "ADOPQR";
	static String two = "B";
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String s1 = sc.next();
			String s2 = sc.next();
			
			// 길이 다르면 빠져나감
			if(s1.length() != s2.length()) {
				System.out.println("#" + tc + " " + "DIFF");
				continue;
			}

			String set1 = newStr(s1);
			String set2 = newStr(s2);
			
			if(set1.equals(set2))
				System.out.println("#" + tc + " " + "SAME");
			else
				System.out.println("#" + tc + " " + "DIFF");
		}
		sc.close();
	}

	private static String newStr(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < zero.length(); j++) {
				if(s.charAt(i) == zero.charAt(j)) {
					str += "A";
					break;
				}
			}
			for (int j = 0; j < one.length(); j++) {
				if(s.charAt(i) == one.charAt(j)) {
					str += "B";
					break;
				}
			}
			for (int j = 0; j < two.length(); j++) {
				if(s.charAt(i) == two.charAt(j)) {
					str += "C";
					break;
				}
			}
		}
		return str;
	}
}