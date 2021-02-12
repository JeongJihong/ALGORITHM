import java.io.*;
import java.util.*;

public class BJ_17406_배열돌리기4 {
	static int[][] order;
	static int orderNum;
	static int N, M, K;
	static int ans = Integer.MAX_VALUE, min = Integer.MAX_VALUE;

	public static class OP {
		int R, C, S;

		public OP(int r, int c, int s) {
			super();
			R = r;
			C = c;
			S = s;
		}
	}

	public static void main(String args[]) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 정보 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][M + 1];
		int[][] res = new int[N + 1][M + 1];
		int[][] origin = new int[N + 1][M + 1];
		OP[] op = new OP[K];
		order = new int[fact(K)][K];

		// 입력 받기
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				res[r][c] = arr[r][c];
				origin[r][c] = arr[r][c];
			}
		}

		for (int i = 0; i < op.length; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			op[i] = new OP(R, C, S);
		}

		// 연산 수행할 수 있는 가지 수 구하기
		perm(0, new boolean[K], new int[K]);

		for (int i = 0; i < order.length; i++) {
			for (int ok = 0; ok < order[i].length; ok++) {
				int s = 1;
				int rr = op[order[i][ok]].R;
				int cc = op[order[i][ok]].C;
				int ss = op[order[i][ok]].S;
				while (s <= ss) {
					for (int r = 1; r <= N; r++) {
						for (int c = 1; c <= M; c++) {
							if (s <= ss && r == rr - s && c == cc - s) {
								int row = r;
								int col = c;

								// 오른쪽으로 이동
								while (row == rr - s && col < cc + s) {
									res[row][col + 1] = arr[row][col++];
								}
								// 아래로 이동
								while (row < rr + s && col == cc + s) {
									res[row + 1][col] = arr[row++][col];
								}
								// 왼쪽으로 이동
								while (row == rr + s && col > cc - s) {
									res[row][col - 1] = arr[row][col--];
								}
								// 위로 이동
								while (row > rr - s && col == cc - s) {
									res[row - 1][col] = arr[row--][col];
								}
								++s;
							}
						}
					}
				}
				// 한바퀴 돌린 배열을 원래 배열에 다시 복사하기
				for (int r = 1; r <= N; r++) {
					for (int c = 1; c <= M; c++) {
						arr[r][c] = res[r][c];
					}
				}
			}
			// 배열의 값 구하기
			ans = arrVal(res);
//			for (int r = 1; r <= N; r++) {
//				for (int c = 1; c <= M; c++) {
//					System.out.print(res[r][c]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			// 새로운 연산 시작하기 전에 원래 배열로 돌려놓기
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= M; c++) {
					arr[r][c] = origin[r][c];
					res[r][c] = origin[r][c];
				}
			}
		}
		System.out.println(ans);
		br.close();
	}

	private static int arrVal(int[][] res) {
		for (int r = 1; r <= N; r++) {
			int sum = 0;
			for (int c = 1; c <= M; c++) {
				sum += res[r][c];
			}
			min = Math.min(min, sum);
		}
		return min;
	}

	private static void perm(int cnt, boolean[] isSelected, int[] sel) {
		if (cnt == K) {
			for (int i = 0; i < K; i++) {
				order[orderNum][i] = sel[i];
			}
			++orderNum;
			return;
		}
		for (int i = 0; i < sel.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				sel[cnt] = i;
				perm(cnt + 1, isSelected, sel);
				isSelected[i] = false;
			}
		}
	}

	private static int fact(int k) {
		if (k == 1)
			return 1;
		return k * fact(k - 1);
	}
}