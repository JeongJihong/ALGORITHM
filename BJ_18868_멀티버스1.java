import java.io.*;
import java.util.*;
// 멀티버스

public class BJ_18868_멀티버스1 {

	static int ans = 0, N, M;
	static char[][] flag;
	static int[][] uni;

	public static void main(String args[]) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		uni = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				uni[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0, new int[2]);
		System.out.println(ans);
	}

	private static void comb(int cnt, int start, int[] sel) {
		if (cnt == 2) {
			for (int j = 0; j < N - 1; j++) {
				for (int k = j; k < N; k++) {
					if (uni[sel[0]][j] > uni[sel[0]][k]) {
						if (uni[sel[1]][j] <= uni[sel[1]][k])
							return;
					} 
					else if (uni[sel[0]][j] < uni[sel[0]][k]) {
						if (uni[sel[1]][j] >= uni[sel[1]][k])
							return;
					} 
					else {
						if (uni[sel[1]][j] != uni[sel[1]][k])
							return;
					}
				}
			}
			++ans;
			return;
		}

		for (int i = start; i < M; i++) {
			sel[cnt] = i;
			comb(cnt + 1, i + 1, sel);
		}
	}
}