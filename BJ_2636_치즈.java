import java.io.*;
import java.util.*;

public class BJ_2636_치즈 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int R, C, melt, prevMelt, cnt = 0;
	static int[][] plate, v;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		plate = new int[R][C];
		v = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				plate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(plate[r][c] == 1) {
					++cnt;
					bfs();
					for (int i = 0; i < R; i++) {
						Arrays.fill(v[i], 0);
					}
					r = -1;
					break;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(prevMelt);
	}

	private static void bfs() {
		int bc = 0;
		
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0));
		v[0][0] = 1;
		
		L: while(!q.isEmpty()) {
			bc = 0;
			Point p = q.poll();
			// break 조건
			for (int i = 0; i < R; i++) {
				if(v[i][0] == 1 && v[i][C-1] == 1) ++bc;
			}
			for (int i = 0; i < C; i++) {
				if(v[0][i] == 1 && v[R-1][i] == 1) ++bc;
			}
			if(bc == 2*(R+C) -4)	break L;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && v[nr][nc] == 0 && plate[nr][nc] == 0) {
					q.offer(new Point(nr, nc));
					v[nr][nc] = 1;
					for (int id = 0; id < 4; id++) {
						int ir = nr + dr[id];
						int ic = nc + dc[id];
						if(ir >= 0 && ir < R && ic >= 0 && ic < C && plate[ir][ic] == 1) {
							// 공기와 접촉했기때문에 사라진다
							plate[ir][ic] = -1;
						}
					}
				}
			}
			
		}
		melt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(plate[i][j] == -1)	{
					++melt;
					plate[i][j] = 0;
				}
			}
		}
		if(melt != 0)	prevMelt = melt;
	}
}