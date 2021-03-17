import java.io.*;
import java.util.*;

public class SWEA_7733_치즈도둑 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int N, maxCnt = 0;
	static int[][] cheese, v;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			maxCnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			cheese = new int[N][N];
			v = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			for (int i = 0; i < 100; i++) {
				bfs(i);
			}
			System.out.println("#" + tc + " " + maxCnt);
		}
	}
	private static void bfs(int day) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				v[i][j] = 0;
			}
		}
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(v[i][j] == 0 && cheese[i][j] > day) {
					v[i][j] = 1;
					q.offer(new Point(i, j));
				}
				else	continue;
				
				while(!q.isEmpty()) {
					Point pp = q.poll();
					for (int d = 0; d < 4; d++) {
						int nr = pp.r + dr[d];
						int nc = pp.c + dc[d];
						if(nr >= 0 && nr < N && nc >= 0 && nc < N && cheese[nr][nc] > day && v[nr][nc] == 0) {
							v[nr][nc] = 1;
							q.offer(new Point(nr, nc));
						}
					}
				}
				++cnt;
			}
		}
		maxCnt = Math.max(maxCnt, cnt);
	}
}