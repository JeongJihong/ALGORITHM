import java.io.*;
import java.util.*;

// 파티

class BJ_1043_거짓말 {

	static int parents[];
	static int N, M, TNum, cnt, PNum;
	static int[] T, P;
	static int[][] PP;

	static void make(int n) { // 크기가 1인 단위집합을 만든다.
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		make(N);

		st = new StringTokenizer(br.readLine());
		int TNum = Integer.parseInt(st.nextToken());
		T = new int[TNum];
		for (int i = 0; i < TNum; i++) {
			T[i] = Integer.parseInt(st.nextToken());
			union(0, T[i]);
		}

		PP = new int[M][N + 1];
		for (int m = 0; m < M; m++) { // 파티의 수만큼 반복
			st = new StringTokenizer(br.readLine());
			PNum = Integer.parseInt(st.nextToken());
			P = new int[PNum];
			PP[m][0] = PNum;
			for (int i = 0; i < PNum; i++) {
				P[i] = Integer.parseInt(st.nextToken());
				PP[m][i + 1] = P[i];
			}
			for (int i = 0; i < PNum - 1; i++) {
				union(P[i], P[i + 1]);
			}
		}

		//System.out.println(Arrays.toString(parents));
		for (int m = 0; m < M; m++) {
			int none = 0;
			for (int i = 1; i <= PP[m][0]; i++) {
				if (findSet(parents[PP[m][i]]) != findSet(parents[0])) {
					continue;
				}
				none++;
			}
			if (none == 0)
				cnt++;
		}
		System.out.println(cnt);
	}
}