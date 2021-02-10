import java.io.*;
import java.util.*;

public class BJ_16926_배열돌리기1 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][M + 1];
		int[][] res = new int[N + 1][M + 1];
		boolean[][] change;

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			// 한 바퀴 도는 과정
			change = new boolean[N+1][M+1];
			int fr = N;
			int fc = M;
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					if (!change[r][c] && r == c && r <= M / 2) {
						int row = r;
						int col = c;
				
						// 아래로 이동
						while (row < fr && col == c) {
							res[row + 1][col] = arr[row][col];
							change[row][col] = true;
							++row;
						}
						// 오른쪽으로 이동
						while (row == fr && col < fc) {
							res[row][col + 1] = arr[row][col];
							change[row][col] = true;
							++col;
						}
						// 위로 이동
						while (row > r && col == fc) {
							res[row - 1][col] = arr[row][col];
							change[row][col] = true;
							--row;
						}
						// 왼쪽으로 이동
						while (row == r && col > c) {
							res[row][col - 1] = arr[row][col];
							change[row][col] = true;
							--col;
						}
						--fr;
						--fc;
					}
				}
			}
			// 한바퀴 돌린 배열을 원래 배열에 다시 복사하기
			for (int r =1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					arr[r][c] = res[r][c];
				}
			}
		}
		// 출력하기
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				sb.append(res[r][c] + " ");
			}
			sb.append('\n');
		}
		System.out.println(sb);

		br.close();
	}
}