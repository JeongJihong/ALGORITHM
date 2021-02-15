import java.io.*;
import java.util.*;

public class BJ_2961_도영이가_만든_맛있는_음식 {
	static int N;
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] input = new int[N][2];
		int sour = 1, bitter = 0, diff = 0, minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
		}

		for (int i = 1; i < (1 << N); i++) {
			sour = 1;
			bitter = 0;
			for (int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					sour *= input[j][0];
					bitter += input[j][1];
				}
			}
			diff = Math.abs(sour - bitter);
			minDiff = Math.min(minDiff, diff);
		}
		System.out.println(minDiff);
	}
}