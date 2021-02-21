import java.io.*;
import java.util.*;

// 주유소
public class BJ_13305_주유소 {

	static int N, cnt = 0;
	static long sum = 0, ans = 0;
	static long[] length, price;

	public static void main(String args[]) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		length = new long[N - 1];
		price = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			length[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N - 1; i++) {
			int j = i;
			while (i + 1 < N - 1 && price[j] < price[i + 1]) {
				sum += length[i];
				++i;
			}
			sum += length[i];
			ans += price[j] * sum;
			sum = 0;
		}

		System.out.println(ans);
	}
}