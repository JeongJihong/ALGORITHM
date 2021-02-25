import java.io.*;
import java.util.*;
// 토마토

class Point {
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class BJ_7576_토마토 {

	static int M, N, freshTomato;
	static int[][] box, visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		visited = new int[N][M];
		Point[] q = new Point[N*M];
		int front = 0, rear = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				// 익은 토마토를 발견하면 큐에 넣기
				if (box[i][j] == 1) {
					q[rear++] = new Point(i, j);
				}
				if(box[i][j] == 0)	++freshTomato;
			}
		}

		int ans = 0;
		while (!(rear == front)) {
			int cnt = 0;
			Point p = q[front++];
			
			if(freshTomato == 0)	{
				System.out.println(ans);
				return;
			}

			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && box[nr][nc] == 0 && visited[nr][nc] == 0) {
					box[nr][nc] = 1;
					q[rear++] = new Point(nr, nc);
					visited[nr][nc] = visited[p.r][p.c] + 1;
					ans = visited[nr][nc];
					--freshTomato;
				}
			}
		}
		System.out.println(-1);
	}
}