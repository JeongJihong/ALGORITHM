import java.io.*;
import java.util.*;

// 보급로


public class SWEA_1249_보급로 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			int[][] time = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(time[i], Integer.MAX_VALUE);
			}
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			bfs(0, 0, map, time);
			
			System.out.println("#" + tc + " " + time[N-1][N-1]);
		}
	}

	private static void bfs(int r, int c, int[][] map, int[][] time) {
		time[r][c] = map[r][c];
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r, c));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && time[nr][nc] > time[p.r][p.c] + map[nr][nc]) {
					time[nr][nc] = time[p.r][p.c] + map[nr][nc];
					q.add(new Point(nr, nc));
				}
			}
//			for (int i = 0; i < time.length; i++) {
//				for (int j = 0; j < time[i].length; j++) {
//					System.out.print(time[i][j]);
//				}
//				System.out.println();
//			}
		}
		
	}
}