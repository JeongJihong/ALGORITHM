import java.io.*;
import java.util.*;

class Point {
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
}

public class BJ_14716_현수막 {
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int M, N, res;
	static int[][] board;
	
 	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] == 1) {
					bfs(i, j);
					++res;
				}
			}
		}
		
		System.out.println(res);
		
	}
	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(i, j));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 8; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				// 만약 범위를 만족하고 글자인 부분이라면
				if(nr >= 0 && nr < M && nc >= 0 && nc < N && board[nr][nc] == 1) {
					board[nr][nc] = -1;
					q.offer(new Point(nr, nc));
				}
			}
		}
		
//		for (int k = 0; k < M; k++) {
//			System.out.println(Arrays.toString(board[k]));
//		}
//		System.out.println();
	}
}
