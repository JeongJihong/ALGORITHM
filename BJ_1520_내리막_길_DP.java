import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map, dp;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(N-1, M-1));
	}

	private static int dfs(int r, int c) {
		if(r == 0 && c == 0)	return 1;
		
		if(dp[r][c] == -1) {
			dp[r][c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[r][c] < map[nr][nc]) {
					dp[r][c] += dfs(nr,nc);
				}
			}
		}
		return dp[r][c];
	}
}