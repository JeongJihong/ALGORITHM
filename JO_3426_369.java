import java.io.*;
import java.util.*;

public class JO_3426_369 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int res = 0;
		
		for (int i = 1; i <= n; i++) {
			int cur = i;
			while(cur / 10 != 0) {
				if(cur % 10 != 0 && cur % 10 % 3 == 0) {
					++res;
				}
				cur /= 10;
			}
			if(cur != 0 && cur % 3 == 0) {
				++res;
			}
		}
		System.out.println(res);
	}
}