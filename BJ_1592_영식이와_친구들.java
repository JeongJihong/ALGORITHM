import java.io.*;
import java.util.*;
// 영식이와 친구들
public class BJ_1592_영식이와_친구들 {
	
	static int N, M, L;
	static int[] friend;
	static int get, now = 1;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		friend = new int[N+1];
		friend[now] = 1;
		while(true) {
			if(friend[now] == M)	break;
			// 받은 횟수가 짝수번이면
			if(friend[now] % 2 == 0) {
				now -= L;
				if(now < 1) {
					now += N;
				}
				friend[now]++;
				get++;
			}
			// 받은 횟수가 홀수번이면
			else {
				now += L;
				if(now > N) {
					now -= N;
				}
				friend[now]++;
				get++;
			}
		}
		
		System.out.println(get);
	}
}