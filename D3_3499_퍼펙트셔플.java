package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class D3_3499_퍼펙트셔플 {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt, idx;
		String[] card, sorted;
		for (int tc = 1; tc <= T; tc++) {
			idx = 0;
			cnt = sc.nextInt();
			card = new String[cnt];
			sorted = new String[cnt];
			for (int i = 0; i < cnt; i++) {
				card[i] = sc.next();
			}
			// 카드가 짝수개이면
			if(cnt % 2 == 0) {
				for (int i = 0; i < cnt/2; i++) {
					sorted[idx++] = card[i];
					sorted[idx++] = card[i + cnt/2];
				}
			}
			else{
				sorted[idx++] = card[0];
				for (int i = 1; i <= cnt/2; i++) {
					sorted[idx++] = card[i + cnt/2];
					sorted[idx++] = card[i];
				}
				
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < sorted.length; i++) {
				System.out.print(sorted[i] + " ");
			}
			System.out.println();
		}
	}
}
