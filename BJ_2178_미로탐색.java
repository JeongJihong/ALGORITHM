import java.io.*;
import java.util.*;
// 미로 탐색
public class BJ_2178_미로탐색 {
	
	static int N, M;
	static int[][] maze;
	static int[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}
		bfs();
		System.out.println(visited[N-1][M-1]);
	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int[] arr = {0, 0};
		q.offer(arr);
		visited[arr[0]][arr[1]] = 1;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			if(p[0] == N-1 && p[1] == M-1)	break;
			
			for (int d = 0; d < 4; d++) {
				int nr = p[0] + dr[d];
				int nc = p[1] + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && maze[nr][nc] == 1 && visited[nr][nc] == 0) {
					int[] n = {nr, nc};
					q.offer(n);
					visited[nr][nc] = visited[p[0]][p[1]] + 1;
				}
			}
		}
	}
}