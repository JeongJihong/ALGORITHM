import java.io.*;
import java.util.*;

// 치킨배달
public class BJ_15686_치킨배달 {
	
	static int[][] loc, sel;
	static int storeNum, N, M, dist, sum = 0, min = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
	static int[][] city;
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sel = new int[M][2];
		city = new int[N+1][N+1];
		int cnt = 0;
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				city[r][c] = Integer.parseInt(st.nextToken());
				if(city[r][c] == 2)	{
					++storeNum;
				}
				
			}
		}
		loc = new int[storeNum][2];
		cnt = 0;
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if(city[r][c] == 2)	{
					loc[cnt][0] = r;
					loc[cnt++][1] = c;
				}
				
			}
		}
		
		comb(0, 0);
		System.out.println(ans);
	}

	private static void comb(int cnt, int start) {
		if(cnt == M) {
			sum = 0;
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if(city[r][c] == 1) {
						min = Integer.MAX_VALUE;
						for (int i = 0; i < M; i++) {
							dist = Math.abs(sel[i][0] - r) + Math.abs(sel[i][1] - c);
							min = Math.min(dist, min);
						}
						sum += min;
					}
				}
			}
			ans = Math.min(ans, sum);
			return;
		}
		for (int i = start; i < storeNum; i++) {
			sel[cnt][0] = loc[i][0];
			sel[cnt][1] = loc[i][1];
			comb(cnt+1, i+1);
		}
	}
}