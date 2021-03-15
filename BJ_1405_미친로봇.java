import java.io.*;
import java.util.*;

// 미친 로봇
public class BJ_1405_미친로봇 {

	static int move;
	static double res = 0;
	static double[] perc = new double[4];
	static int[][] v = new int[30][30];
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		move = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 4; i++) {
			perc[i] = Integer.parseInt(st.nextToken()) * 0.01;
		}
		
		v[14][14] = 1;
		dfs(14, 14, 1, 0);
		
		System.out.println(res);
	}

	private static void dfs(int r, int c, double p, int n) {
		if(n == move) {
			res += p;
			return;
		}
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(v[nr][nc] == 0) {
				v[nr][nc] = 1;
				dfs(nr, nc, p*perc[d], n+1);
				v[nr][nc] = 0;
			}
		}
	}
}