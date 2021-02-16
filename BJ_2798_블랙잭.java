import java.io.*;
import java.util.*;

import javax.smartcardio.Card;
// 블랙잭
public class BJ_2798_블랙잭 {
	static int N, M, ans, idx;
	static int[] card;
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		
		comb(0, 0, new int[3]);
		System.out.print(ans);
	}
	private static void comb(int cnt, int start, int[] sel) {
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++)
				sum += sel[i];
			if(sum <= M)
				ans = Math.max(sum, ans);
			return;
		}
		for (int i = start; i < N; i++) {
			sel[cnt] = card[i];
			comb(cnt+1, i+1, sel);
		}
	}
}