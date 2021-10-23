import java.io.*;
import java.util.*;

// 섬의 개수
public class Main {
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int w, h, res;
	static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String args[]) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		
		while(w > 0 && h > 0) {
			// 입력 받기
			map = new int[h][w];
			res = 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1) {
						bfs(i ,j);
						++res;
					}
				}
			}
			
			System.out.println(res);
			
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
		}
	}

	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(i , j));
		map[i][j] = -1;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 8; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 1) {
					q.offer(new Point(nr, nc));
					map[nr][nc] = -1;
				}
				
			}
		}
	}
}
