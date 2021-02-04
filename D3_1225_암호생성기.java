package com.ssafy;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class D3_1225_암호생성기 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("1225.txt"));
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int T, tmp = 1, n = 1;
		
		for (int tc = 1; tc <= 10; tc++) {
			T = sc.nextInt();
			q.clear();
			tmp = 1;
			for (int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			
			while(tmp > 0) {
				n = 1;
				for (int i = 0; i < 5; i++) {
					tmp = q.poll() - n;
					n++;
					tmp = tmp < 0 ? 0 : tmp;
					q.offer(tmp);
					if(tmp <= 0)
						break;
				}
			}
			
			System.out.print("#" + tc + " ");
			for(int i = 0; i < 8; ++i) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	
	}
}