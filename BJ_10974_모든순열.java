import java.io.*;
import java.util.*;

// 모든 순열

public class BJ_10974_모든순열 {

	static int N;
	static int[] sel;
	static boolean[] v;
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		sel = new int[N];
		v = new boolean[N];
		solve(0);
	}

	private static void solve(int cnt) {
		if(cnt == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
		}
		for (int i = 1; i <= N; i++) {
			if(!v[i-1]) {
				sel[cnt] = i;
				v[i-1] = true;
				solve(cnt+1);
				v[i-1] = false;
			}
		}
	}
}