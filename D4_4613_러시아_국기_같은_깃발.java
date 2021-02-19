import java.io.*;
import java.util.*;
// 러시아 국기 같은 깃발

public class D4_4613_러시아_국기_같은_깃발 {
	
	static int ans = Integer.MAX_VALUE, N, M;
	static char[][] flag;
	static int change = 0;
	
	public static void main(String args[]) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			flag = new char[N][];
			for (int i = 0; i < N; i++) {
				flag[i] = br.readLine().toCharArray();
			}
			
			comb(0, new int[3]);
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void comb(int cnt, int[] sel) {
		if(cnt == sel.length) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if(sum == N) {
				int row = 0;
				change = 0;
				for (int i = 0; i < 3; i++) {	//3색
					for (int j = 0; j < sel[i]; j++) {	// 몇 줄인가
						for (int k = 0; k < M; k++) {
							if(i == 0) {
								if(flag[row][k] != 'W')	++change;
							}
							else if(i == 1) {
								if(flag[row][k] != 'B')	++change;
							}
							else if(i == 2) {
								if(flag[row][k] != 'R')	++change;
							}
						}
						++row;
					}
				}
				ans = Math.min(ans, change);
			}
			return;
		}
		
		for (int i = 1; i < N; i++) {
			sel[cnt] = i;
			comb(cnt+1, sel);
		}
	}
}