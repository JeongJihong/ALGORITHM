import java.io.*;
import java.util.*;

import javax.smartcardio.Card;
// 설탕 배달
public class BJ_2839_설탕배달 {
	public static void main(String args[]) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0, min = Integer.MAX_VALUE;
		
		for (int i = N / 5; i >= 0; i--) {
			cnt = i;
			if((N - i * 5) % 3 == 0) {
				cnt += (N - i * 5) / 3;
				min = Math.min(min, cnt);
			}
		}
		if(min == Integer.MAX_VALUE) 	System.out.println(-1);
		else							System.out.println(min);
	}
}