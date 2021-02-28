import java.io.*;
import java.util.*;
// 안전영역
class Point {
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
}

public class BJ_2468_안전_영역 {
	
	static int N, highest = 0, maxIsland;
	static int[][] map, rainMap, v;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		v = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				highest = Math.max(highest, map[i][j]);
			}
		}
		// 비가 온 수치
		for (int i = 0; i < highest; i++) {
			
			Queue<Point> q = new LinkedList<>();
			int island = 1;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(map[j][k] > i && v[j][k] == 0) {
						q.offer(new Point(j, k));
						while(!q.isEmpty()) {
							Point p = q.poll();
							v[p.r][p.c] = island;
							for (int d = 0; d < 4; d++) {
								int nr = p.r + dr[d];
								int nc = p.c + dc[d];
								if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > i && v[nr][nc] == 0) {
									v[nr][nc] = island;
									q.offer(new Point(nr, nc));
								}
							}
						}
						++island;
					}
				}
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					v[j][k] = 0;
				}
			}
			maxIsland = Math.max(maxIsland, island);
		}
		System.out.println(maxIsland-1);
	}
}