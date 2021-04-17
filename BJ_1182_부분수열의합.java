import java.io.*;
import java.util.*;

// 부분수열의 합

public class BJ_1182_부분수열의합 {

	static int res = 0;
	static int S, N;
	static int[] arr;

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		solve(0, 0);
		if(S == 0)	--res;
		System.out.println(res);
	}

	private static void solve(int cnt, int sum) {
		if (cnt == N) {
			if (sum == S) {
				++res;
			}
			return;
		}

		solve(cnt + 1, sum + arr[cnt]);
		solve(cnt + 1, sum);
	}
}