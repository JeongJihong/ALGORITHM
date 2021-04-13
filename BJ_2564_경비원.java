import java.io.*;
import java.util.*;

// 경비원

class BJ_2564_경비원 {
	
	static int X, Y;
	static int N;
	static int[][] inp;
	
	public static void main(String[] args) throws Exception {
		int res = 0;
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		inp = new int[N+1][2];
		
		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				inp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(inp[N][0] == 1) {			// 동근이가 북쪽에 있을때
			for (int i = 0; i < N; i++) {
				if(inp[i][0] == 1) {
					res += Math.abs(inp[i][1] - inp[N][1]);
				} else if(inp[i][0] == 2) {
					res += Y;
					int min = Math.min(inp[N][1] + inp[i][1], X-inp[N][1] + X-inp[i][1]);
					res += min;
				} else if(inp[i][0] == 3) {
					res += (inp[i][1] + inp[N][1]);
				} else if(inp[i][0] == 4) {
					res += (inp[i][1] + X - inp[N][1]);
				}
			}
		} else if(inp[N][0] == 2) {	// 동근이가 남쪽에 있을때
			for (int i = 0; i < N; i++) {
				if(inp[i][0] == 1) {
					res += Y;
					int min = Math.min(inp[N][1] + inp[i][1], X-inp[N][1] + X-inp[i][1]);
					res += min;
				} else if(inp[i][0] == 2) {
					res += Math.abs(inp[i][1] - inp[N][1]);
				} else if(inp[i][0] == 3) {
					res += (Y - inp[i][1] + inp[N][1]);
				} else if(inp[i][0] == 4) {
					res += (Y - inp[i][1] + X - inp[N][1]);
				}
			}
		} else if(inp[N-1][0] == 3) {	// 동근이가 서쪽에 있을때
			for (int i = 0; i < N; i++) {
				if(inp[i][0] == 1) {
					res += Math.abs(inp[N][1] + inp[i][1]);
					System.out.println();
				} else if(inp[i][0] == 2) {
					res += Math.abs(inp[i][1] + Y - inp[N][1]);
				} else if(inp[i][0] == 3) {
					res += Math.abs(inp[i][1] - inp[N][1]);
				} else if(inp[i][0] == 4) {
					res += X;
					int min = Math.min(inp[N][1] + inp[i][1], Y-inp[N][1] + Y-inp[i][1]);
					res += min;
				}
			}
		} else if(inp[N][0] == 4) {	// 동근이가 동쪽에 있을때
			for (int i = 0; i < N; i++) {
				if(inp[i][0] == 1) {
					res += Math.abs(X - inp[i][1] + inp[N][1]);
				} else if(inp[i][0] == 2) {
					res += Math.abs(X - inp[i][1] + Y - inp[N][1]);
				} else if(inp[i][0] == 3) {
					res += X;
					int min = Math.min(inp[N][1] + inp[i][1], Y-inp[N][1] + Y-inp[i][1]);
					res += min;
				} else if(inp[i][0] == 4) {
					res += Math.abs(inp[i][1] - inp[N][1]);
				}
			}
		}
		
		System.out.println(res);
	}
}