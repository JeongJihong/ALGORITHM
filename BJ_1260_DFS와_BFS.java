import java.io.*;
import java.util.*;

// BFS DFS
public class BJ_1260_DFS와_BFS {
	static int N, M, S;
	static StringBuilder sb = new StringBuilder();
	static int[][] adjMat;

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		adjMat = new int[N+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjMat[x][y] = 1;
			adjMat[y][x] = 1;
		}

		DFS(S, new boolean[N+1]);
		System.out.println(sb);
		sb.setLength(0);
		BFS();
		System.out.println(sb);
		br.close();
	}

	private static void DFS(int s, boolean[] v) {
		v[s] = true;
		System.out.print(s + " ");
		
		for (int i = 1; i <= N; i++) {
			if(adjMat[s][i] == 1 && !v[i]) {
				DFS(i,v);
			}
		}
	}

	private static void BFS() {
		boolean[] v = new boolean[N+1];
		Queue<Integer> Q = new LinkedList<>();
		Q.add(S);
		v[S] = true;
		while(!Q.isEmpty()) {
			Integer p = Q.poll();
			System.out.print(p + " ");
			for (int i = 1; i <= N; i++) {
				if(adjMat[p][i] == 1 && !v[i]) {
					Q.add(i);
					v[i] = true;
				}
			}
		}
	}
}