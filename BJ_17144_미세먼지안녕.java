import java.io.*;
import java.util.*;

// 미세먼지 안녕!

class Point {
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class BJ_17144_미세먼지안녕 {

	static int R, C, T, cleanerPos = 0;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] room, roomDif;
	static int[][] v;

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		room = new int[R][C];
		roomDif = new int[R][C];
		v = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
				if (room[r][c] == -1)
					cleanerPos = r;
			}
		}
		diffusion();
		System.out.println(getResult());
	}

	private static void diffusion() {
		for (int t = 0; t < T; t++) {
			bfs();
			airCleaner();
		}
	}

	private static void bfs() {
		copy(room, roomDif);
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(room[r][c] > 0) {
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr >= 0 && nr < R && nc >= 0 && nc < C && roomDif[nr][nc] != -1) {
							roomDif[nr][nc] += room[r][c] / 5;
							roomDif[r][c] -= room[r][c] / 5;
						}
					}
				}
			}
		}
		copy(roomDif, room);
	}

	private static void copy(int[][] src, int[][] dst) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				dst[r][c] = src[r][c];
			}
		}
	}

	private static void airCleaner() {
		// 오른쪽으로 날리기
		int tmp = 0, nexttmp = 0, r = cleanerPos;
		for (int c = 1; c < C; c++) {
			nexttmp = room[r][c];
			room[r][c] = tmp;
			tmp = nexttmp;
		}
		
		// 아래쪽으로 날리기
		for (int i = r+1; i < R; i++) {
			nexttmp = room[i][C-1];
			room[i][C-1] = tmp;
			tmp = nexttmp;
		}
		
		// 왼쪽으로 날리기
		for (int c = C-2; c >= 0; c--) {
			nexttmp = room[R-1][c];
			room[R-1][c] = tmp;
			tmp = nexttmp;
		}
		
		// 위쪽으로 날리기
		for (int i = R-2; i >= r; i--) {
			nexttmp = room[i][0];
			room[i][0] = tmp;
			tmp = nexttmp;
		}
		room[r][0] = -1;
		

		// 오른쪽으로 날리기
		tmp = 0; nexttmp = 0; r = cleanerPos-1;
		for (int c = 1; c < C; c++) {
			nexttmp = room[r][c];
			room[r][c] = tmp;
			tmp = nexttmp;
		}

		// 위쪽으로 날리기
		for (int i = r-1; i >= 0; i--) {
			nexttmp = room[i][C-1];
			room[i][C-1] = tmp;
			tmp = nexttmp;
		}

		// 왼쪽으로 날리기
		for (int c = C-2; c >= 0; c--) {
			nexttmp = room[0][c];
			room[0][c] = tmp;
			tmp = nexttmp;
		}
		// 아래쪽으로 날리기
		for (int i = 1; i < r; i++) {
			nexttmp = room[i][0];
			room[i][0] = tmp;
			tmp = nexttmp;
		}
		
		room[r][0] = -1;
		
		//print(room);
	}

	private static void print(int[][] room) {
		for (int r = 0; r < room.length; r++) {
			for (int c = 0; c < room[r].length; c++) {
				System.out.printf("%2d ", room[r][c]);
			}
			System.out.println();
		}
		System.out.println("===========");
	}
	
	private static int getResult() {
		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				res += room[i][j];
			}
		}
		return res + 2;
	}

}