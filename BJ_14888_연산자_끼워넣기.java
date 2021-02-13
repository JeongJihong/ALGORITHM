import java.io.*;
import java.util.*;
// BJ 연산자 끼워넣기
public class BJ_14888_연산자_끼워넣기 {
	static int N, AIdx = 0;
	static int[] op;
	static long[] A;
	static Stack<Long> res = new Stack<Long>();
	static long max = Long.MIN_VALUE, min= Long.MAX_VALUE;
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = new long[N];
		op = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0, new int[N-1], op);
		System.out.println(max);
		System.out.println(min);
		
		br.close();
	}

	private static void perm(int cnt, int[] sel, int[] op) {
		if(cnt == N-1) {
			res.push(A[AIdx++]);
			for (int i = 0; i < N-1; i++) {
				switch (sel[i]) {
					case 0:
						res.push(res.pop() + A[AIdx++]);
						break;
					case 1:
						res.push(res.pop() -  A[AIdx++]);
						break;
					case 2:
						res.push(res.pop() *  A[AIdx++]);
						break;
					case 3:
						res.push(res.pop() /  A[AIdx++]);
						break;
				}
			}
			max = Math.max(res.peek(), max);
			min = Math.min(res.peek(), min);
			AIdx = 0;
			res.clear();
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(op[i] != 0) {
				sel[cnt] = i;
				--op[i];
				perm(cnt+1, sel, op);
				++op[i];
			}
		}
	}
}