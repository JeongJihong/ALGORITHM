import java.io.*;
import java.util.*;
//유기농 배추

class Point {
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
}
public class BJ_1012_유기농_배추 {

	static int N, M, K, worm = 0;
	static int[][] field;
	static int[][] cabbage;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			worm = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			field = new int[N][M];
			visited = new boolean[N][M];
			cabbage = new int[K][2];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				cabbage[k][1] = Integer.parseInt(st.nextToken());
				cabbage[k][0] = Integer.parseInt(st.nextToken());
				field[cabbage[k][0]][cabbage[k][1]] = 1;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(field[i][j] != 0 && !visited[i][j]) {
						++worm;
						visited[i][j] = true;
						bfs(new Point(i, j));
					}
				}
			}
			System.out.println(worm);
		}
	}

	private static void bfs(Point p) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(p);
		
		while(!q.isEmpty()) {
			p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && field[nr][nc] != 0) {
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc));
				}
			}
		}
	}
}