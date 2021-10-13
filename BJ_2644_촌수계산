import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
//	static boolean[][] v;
	static int p1, p2;
	
	public static void main(String args[]) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
//		v = new boolean[n+1][n+1];
		st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}

		dfs(p1, 0);
		System.out.println(-1);
	}

	private static void dfs(int p1, int cnt) {
		for (int i = 1; i <= n; i++) {
			if(arr[p1][i] == 1) {
				break;
			}
			if(i == n)
				return;
		}
		
		for (int i = 1; i <= n; i++) {
			if(arr[p1][i] == 1) {
				if(i == p2) {
					System.out.println(cnt + 1);
					System.exit(0);
				}
				arr[i][p1] = -1;
				arr[p1][i] = -1;
				dfs(i, cnt+1);
			}
		}
		
	}
}
