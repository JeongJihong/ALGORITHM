import java.io.*;
import java.util.*;

// 특이한 자석

public class SWEA_4013_특이한자석 {

	static int res, K;
	static int[][] magnet = new int[4][8];
	static int[] rotationDir = new int[4];

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			res = 0;
			
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < K; i++) {
				res = 0;
				Arrays.fill(rotationDir, 0);
				st = new StringTokenizer(br.readLine());
				int n = 0, d = 0;
				n = Integer.parseInt(st.nextToken()) - 1;
				d = Integer.parseInt(st.nextToken());
				rotationDir[n] = d;
				checkRotationDir(n, d);
				// System.out.println(Arrays.toString(rotationDir));
				Rotate();
//				for (int j = 0; j < 4; j++) {
//					System.out.println(Arrays.toString(magnet[j]));
//				}
//				System.out.println();
			}
			
			for (int i = 0; i < 4; i++) {
				if(magnet[i][0] == 1) {
					res += (int)Math.pow(2, i);
				}
			}

			System.out.println("#" + tc + " " + res);
		}
	}

	private static void Rotate() {
		for (int i = 0; i < 4; i++) {
			int tmp1  = 0, tmp2 = 0;
			if (rotationDir[i] == 1) { // 시계방향으로 회전
				tmp2 = magnet[i][0];
				 for (int j = 0; j < 7; j++) {
					tmp1 = magnet[i][j+1];
					magnet[i][j+1] = tmp2;
					tmp2 = tmp1;
				}
				 magnet[i][0] = tmp1;
			} else if (rotationDir[i] == -1) { // 반시계방향으로 회전
				tmp2 = magnet[i][7];
				for (int j = 7; j >= 1; j--) {
					tmp1 = magnet[i][j-1];
					magnet[i][j-1] = tmp2;
					tmp2 = tmp1;
				}
				 magnet[i][7] = tmp1;
			}
		}
	}

	private static void checkRotationDir(int n, int d) {
		// 내 위치에서 왼쪽으로 가면서 체크
		for (int i = n; i > 0; i--) {
			if (magnet[i][6] != magnet[i - 1][2]) { // 왼쪽 자석 움직인다
				rotationDir[i - 1] = rotationDir[i] == 1 ? -1 : 1;
			} else
				break;
		}
		// 내 위치에서 오른쪽으로 가면서 체크
		for (int i = n; i < 3; i++) {
			if (magnet[i + 1][6] != magnet[i][2]) { // 오른쪽 자석 움직인다
				rotationDir[i + 1] = rotationDir[i] == 1 ? -1 : 1;
			} else
				break;
		}
	}
}