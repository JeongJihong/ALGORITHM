import java.io.*;
import java.util.*;

public class D3_6808_규영이와_인영이의_카드게임 {

	static int[] gyuyoung = new int[9];
	static int[] inyoung = new int[9];
	static int[] order = new int[9];
	static int T, win = 0, lose = 0, idx = 0;
	
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();

		for (int tc = 1; tc <= T; tc++) {
			win = 0;
			lose = 0;
			idx = 0;
			// set에 카드 저장
			for (int i = 1; i <= 18; i++) {
				set.add(i);
			}
			// 남은 카드 구하기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyuyoung[i] = Integer.parseInt(st.nextToken());
				set.remove(gyuyoung[i]);
			}
			Iterator<Integer> it = set.iterator();
			while(it.hasNext()) {
				inyoung[idx++] = it.next();
			}
			
			perm(0,0);
			System.out.println("#" + tc + " " + win + " " + lose);
		}
	}

	private static void perm(int cnt, int flag) {
		// 대결한다
		if(cnt == 9) {
			game(gyuyoung, order);
			return;
		}
		for (int i = 0; i < 9; i++) {
			if((flag & 1 << i) == 0) {
				order[cnt] = inyoung[i];
				perm(cnt+1, flag | 1 << i);
			}
		}
	}

	private static void game(int[] p, int[] q) {
		int pScore = 0, qScore = 0;
		for (int i = 0; i < 9; i++) {
			if(p[i] > q[i])			pScore += p[i] + q[i];
			else if(q[i] > p[i])	qScore += p[i] + q[i];
		}
		if(pScore > qScore)	++win;
		else if(pScore < qScore) ++lose;
	}
}
