import java.io.*;
import java.util.*;

// 스타트와 링크
public class BJ_14889_스타트와링크 {
	
	static int N, min = Integer.MAX_VALUE;
	static int[][] S;
	static boolean[][] v;
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0, new int[N/2]);
		System.out.println(min);
	}
	private static void solve(int start, int cnt, int[] sel) {
		if(cnt == N/2) {
			int sum1 = 0, sum2 = 0, cnt2 = 0;
			int[] sel2 = new int[N/2];
			boolean flag = false;
			
			for (int i = 0; i < N; i++) {
				flag = false;
				for (int j = 0; j < sel.length; j++) {
					if(sel[j] == i)	flag = true;
				}
				if(!flag) {
					sel2[cnt2++] = i;
				}
			}
			
			for (int i = 0; i < sel.length - 1; i++) {
				for (int j = i+1; j < sel.length; j++) {
					sum1 += S[sel[i]][sel[j]];
					sum1 += S[sel[j]][sel[i]];
				}
			}

			for (int i = 0; i < sel2.length - 1; i++) {
				for (int j = i+1; j < sel2.length; j++) {
					sum2 += S[sel2[i]][sel2[j]];
					sum2 += S[sel2[j]][sel2[i]];
				}
			}

//			System.out.println(Arrays.toString(sel));
//			System.out.println(Arrays.toString(sel2));
//			System.out.println(sum1 + " " + sum2);
			
			
			min = Math.min(min, Math.abs(sum1 - sum2));
			for (int i = 0; i < N; i++) {
				Arrays.fill(v[i], false);
			}
			return;
		}
		
		for (int i = start; i < S.length; i++) {
			sel[cnt] = i;
			solve(i+1, cnt+1, sel);
		}
	}
}