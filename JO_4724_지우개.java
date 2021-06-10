import java.io.*;
import java.util.*;

public class JO_4724_지우개 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int[] arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		
		while(cnt != 1) {
			cnt = 0;
			for (int i = 1; i <= n; i++) {
				if(arr[i] != -1) cnt++;
			}
			if(cnt == 1) break;
			else {
				cnt = 0;
				for (int i = 1; i <= n; i++) {
					if(arr[i] != -1) cnt++;
					if(cnt % 2 != 0) { // 홀수라면
						arr[i] = -1;
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if(arr[i] != -1) {
				System.out.println(i);
				break;
			}
		}
	}
}