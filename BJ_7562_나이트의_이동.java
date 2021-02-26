import java.io.*;
import java.util.*;
// 나이트의 이동

class Point {
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
}
public class BJ_7562_나이트의_이동 {
	
	static int I;
	static int[][] board;
	static int[][] knight = new int[2][2];
	static int[][] v;
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String args[]) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			I = Integer.parseInt(st.nextToken());
			board = new int[I][I];
			v = new int[I][I];
			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 2; k++) {
					knight[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
		}		
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(knight[0][0], knight[0][1]));
		v[knight[0][0]][knight[0][1]] = 1;
		
		while(q.size() != 0) {
			// 말 하나가 움직일 수 있는 경우의 수
			Point p = q.poll();
			if(p.r == knight[1][0] && p.c == knight[1][1]) {
				System.out.println(v[p.r][p.c]-1);
				return;
			}
			for (int d = 0; d < 8; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr >= 0 && nr < I && nc >= 0 && nc < I && v[nr][nc] == 0) {
					v[nr][nc] = v[p.r][p.c] + 1;
					q.offer(new Point(nr, nc));
				}
			}
		}
	}
}