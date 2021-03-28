import java.io.*;
import java.util.*;

// 가장 긴 바이토닉 부분 수열

class BJ_11054_가장긴바이토닉부분수열 {
	static int N, max = 0;
	static int[] A, L, S;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		A = new int[N];
		L = new int[N];
		S = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int mid = 0; mid < N; mid++) {
			for (int i = 0; i < mid; i++) {
				L[i] = 1;
				for (int j = 0; j < i; j++) {
					if(A[j] < A[i] && L[i] < L[j] + 1) {
						L[i] = L[j] + 1;
					}
				}
				max = Math.max(max, L[i]);
			}
			for (int i = mid; i < N; i++) {
				L[i] = 1;
				for (int j = 0; j < i; j++) {
					if(A[j] > A[i] && L[i] < L[j] + 1) {
						L[i] = L[j] + 1;
					}
				}
				max = Math.max(max, L[i]);
			}
		}
		
		System.out.println(max);
	}
}