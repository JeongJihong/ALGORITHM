import java.io.*;
import java.util.*;
//단지번호붙이기
class Point{
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
}

public class BJ_2667_단지번호붙이기 {

	static int N, home = 0;
	static char town = '2';
	static char[][] map;
	static boolean[][] visited;
 	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != '0' && !visited[i][j]) {
					home = 1;
					bfs(new Point(i, j));
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void bfs(Point p) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(p);
		visited[p.r][p.c] = true;
		
		while(!q.isEmpty()) {
			p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] != '0') {
					visited[nr][nc] = true;
					map[nr][nc] = town;
					q.offer(new Point(nr, nc));
					++home;
				}
			}
		}
		++town;
		list.add(home);
	}
}