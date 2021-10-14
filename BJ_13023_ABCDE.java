import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static ArrayList<Integer>[] nodes;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nodes = new ArrayList[N];
		v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			nodes[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			nodes[s].add(e);
			nodes[e].add(s);
		}

		for (int i = 0; i < N; i++) {
			dfs(i, 0);
		}
		System.out.println(0);
	}

	private static void dfs(int i, int cnt) {
		if (cnt == 4) {
			System.out.println(1);
			System.exit(0);
		}
		v[i] = true;
		for (int j = 0; j < nodes[i].size(); j++) {
			if (!v[nodes[i].get(j)]) {
				dfs(nodes[i].get(j), cnt + 1);
			}
		}
		v[i] = false;
	}
}
