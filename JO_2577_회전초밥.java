import java.io.*;
import java.util.*;

// 회전초밥

public class JO_2577_회전초밥 {

	static int N, d, k, c, res, cnt;
	static int[] dish, sushi;
	
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

		sushi = new int[d+1];
		for (int p = 0; p < k; p++) {
			sushi[dish[p]] += 1;
		}
		cnt = countSushi(sushi);	// 초밥 개수를 센다
		if(sushi[c] == 0) {		// 만약 쿠폰 초밥을 먹지 않았다면 1개 더 추가해준다
			++cnt;
			sushi[c] = 1;
		}
		res = Math.max(res, cnt);
		
		for (int i = 0; i < N - 1; i++) {
			sushi[dish[i]] -= 1;				// 맨 처음 초밥 빼기
			sushi[dish[(i+k)%N]] += 1;			// 다음 초밥 추가
			if(sushi[c] == 0 )	sushi[c] = 1;	// 쿠폰 초밥은 고정
			
			if(sushi[dish[i]] == 0)								--cnt;
			if(sushi[dish[(i+k)%N]] == 1 && c != dish[(i+k)%N] 
					&& dish[i] != dish[(i+k)%N])	++cnt;
			res = Math.max(res, cnt);
		}
		System.out.println(res);
	}

	private static int countSushi(int[] sushi) {
		int cnt = 0;
		for (int i = 0; i < sushi.length; i++) {
			if(sushi[i] > 0)	++cnt;
		}
		return cnt;
	}
}