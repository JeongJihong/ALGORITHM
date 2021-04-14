import java.io.*;
import java.util.*;

// 수지의 수지 맞는 여행

public class SWEA_7699_수지의수지맞는여행 {
	
	static int R, C, res = 0;
	static int[] v;
	static int[][] island;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			v = new int[26];
			res = 0;
			
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			island = new int[R][C];
			
			for (int i = 0; i < island.length; i++) {
				String str = br.readLine();
				char[] c = str.toCharArray();
				for (int j = 0; j < c.length; j++) {
					island[i][j] = c[j] - 'A';
				}
			}
			
			v[island[0][0]] = 1;
			dfs(0, 0, 1);
			
			System.out.println("#" + tc + " " + res);
		}
	}

	private static void dfs(int r, int c, int cnt) {
		
		res = Math.max(res, cnt);
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && v[island[nr][nc]] != 1) {
				v[island[nr][nc]] = 1;
				dfs(nr, nc, cnt + 1);
				v[island[nr][nc]] = 0;
			}
		}
	}
}