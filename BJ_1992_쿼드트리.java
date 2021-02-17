import java.io.*;
import java.util.*;

// 치킨배달
public class BJ_1992_쿼드트리 {
	static int[][] data;

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		data = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String n = st.nextToken();
			for (int j = 0; j < N; j++) {
				data[i][j] = n.charAt(j) - '0';
			}
		}

		divide(N, 0, 0);
	}

	private static void divide(int n, int r, int c) {
		if (n == 1) {
			System.out.print(data[r][c]);
			return;
		}
		int i = 0, j = 0, p = data[r][c];
		for (i = r; i < r + n; i++) {
			for (j = c; j < c + n; j++) {
				if (p != data[i][j]) {
					n /= 2;
					System.out.print('(');
					divide(n, r, c);
					divide(n, r, c + n);
					divide(n, r + n, c);
					divide(n, r + n, c + n);
					System.out.print(')');
					return;
				}
			}
		}
		if(i == r + n && j == c + n) {
			System.out.print(p);
		}
	}
}