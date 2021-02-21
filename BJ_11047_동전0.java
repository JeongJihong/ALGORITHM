import java.io.*;
import java.util.*;
// 동전0
public class BJ_11047_동전0 {
	static int K, N, cnt = 0;
	static int[] A;
	public static void main(String args[]) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N];
		for (int i = 0; i < A.length; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N - 1; i >= 0; i--) {
			if(A[i] <= K) {
				cnt += K / A[i];
				K = K % A[i];
			}
		}
		System.out.println(cnt);
	}
	
}