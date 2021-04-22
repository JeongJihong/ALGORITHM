import java.io.*;
import java.util.*;

public class SWEA_1868_파핑파핑지뢰찾기 {

	static int N, res;
	static char[][] map;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			res = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			solve();
			
			System.out.println("#" + tc + " " + res);
		}
	}

	private static void solve() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '.') {	// 지금 있는 칸이 지뢰가 아니라면
					if(checkLandmine(i, j)) {	// 8방 탐색으로 지뢰가 있는지 살펴본다
						++res;
						map[i][j] = '0';
						for (int d = 0; d < 8; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(!(nr >= 0 && nr < N && nc >= 0 && nc < N)) continue;
							bfs(nr ,nc);
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '.')	++res;
			}
		}
	}

	private static void bfs(int r, int c) {
		int nr = 0, nc = 0;
		for (int d = 0; d < 8; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			
			if(!(nr >= 0 && nr < N && nc >= 0 && nc < N)) continue;
			if(map[nr][nc] == '*') {
				map[r][c] = '#';
				return;
			}
		}
		map[r][c] = '0';
		for (int d = 0; d < 8; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			
			if(!(nr >= 0 && nr < N && nc >= 0 && nc < N)) continue;
			if(map[nr][nc] == '.') {
				bfs(nr, nc);
			}
		}
		
	}

	private static boolean checkLandmine(int r, int c) {
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(!(nr >= 0 && nr < N && nc >= 0 && nc < N)) continue;
			if(map[nr][nc] == '*')	return false;
		}
		return true;
	}
}