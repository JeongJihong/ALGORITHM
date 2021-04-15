import java.io.*;
import java.util.*;

// 회전초밥

public class BJ_2531_회전초밥 {

	static int N, d, k, c, res;
	static int[] dish;
	static boolean[] sushi;
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dish = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dish[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			sushi = new boolean[d+1];
			for (int p = 0; p < k; p++) {
				sushi[dish[(i+p)%N]] = true;
			}
			sushi[c] = true;
			res = Math.max(res, countSushi(sushi));
		}
		System.out.println(res);
	}

	private static int countSushi(boolean[] sushi) {
		int cnt = 0;
		for (int i = 0; i < sushi.length; i++) {
			if(sushi[i])	++cnt;
		}
		return cnt;
	}
}