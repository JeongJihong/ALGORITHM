import java.io.*;
import java.util.*;
//색종이2

public class BJ_2567_색종이2 {
	
	static int N;
	static int[][] back = new int[100][100];
	static int line;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		// 색종이 붙이기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = y; j < y+10; j++) {
				for (int k = x; k < x+10; k++) {
					back[j][k] = 1;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(back[i][j] == 0) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && back[nr][nc] == 1) {
							++line;
						}
					}
				}
				if(back[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(!(nr >= 0 && nr < 100 && nc >= 0 && nc < 100)) {
							++line;
						}
					}
				}
			}
		}
		
		System.out.println(line);
	}

}