import java.io.*;
import java.util.*;

// 로또

public class BJ_6603_로또 {

	static int[] S;
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		
		while(k != 0) {
			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0, new int[6]);
			System.out.println();
			
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
		}
	}

	private static void dfs(int cnt, int start, int[] sel) {
		if(cnt == 6) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < S.length; i++) {
			sel[cnt] = S[i];
			dfs(cnt+1, i+1, sel);	// 고르는 경우
		}
	}
}