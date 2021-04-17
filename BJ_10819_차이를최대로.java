import java.io.*;
import java.util.*;

// 차이를 최대로

public class BJ_10819_차이를최대로 {

	static int N, res;
	static int[] A;
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, new int[N], new boolean[N]);
		System.out.println(res);
	}

	private static void solve(int cnt, int[] sel, boolean[] v) {
		if(cnt == N) {
			int sum = 0;
			for (int i = 0; i <= N-2; i++) {
				sum += Math.abs(sel[i] - sel[i+1]);
			}
			res = Math.max(sum, res);
		}
		
		for (int i = 0; i < N; i++) {
			if(!v[i]) {
				sel[cnt] = A[i];
				v[i] = true;
				solve(cnt+1, sel, v);
				v[i] = false;
			}
		}
	}
}