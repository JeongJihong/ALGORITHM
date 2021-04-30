import java.io.*;
import java.util.*;

// 
public class BJ_2846_오르막길 {

	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int res = 0;
		for (int i = 0; i < N; i++) {
			int s = arr[i];
			int idx = i;
			while (i + 1 < N && arr[i] < arr[i + 1]) { // 오르막 길이라면
				++i;
			}
			if (idx != i) { // 오르막 길이 끝나는 지점이라면
				res = Math.max(res, arr[i] - s);
			}
		}
		System.out.println(res);
		;
	}
}