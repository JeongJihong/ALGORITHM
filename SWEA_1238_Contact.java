import java.io.*;
import java.util.*;

// Contact

public class SWEA_1238_Contact {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= 10; tc++) {
			int res = 0;
			int[][] v = new int[101][101];
			int[][] board = new int[101][101];
			int[] nodes = new int[101];
			
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len / 2; i++) {
				int f = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				board[f][t] = 1;
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			list.add(start);
			nodes[start] = 1;
			
			while(!list.isEmpty()) {
				res = 0;
				for (int i = 0, sz = list.size(); i < sz; i++) {
					start = list.get(0);
					list.remove(0);
					res = Math.max(res, start);
					for (int j = 1; j <= 100; j++) {
						if(board[start][j] == 1 && v[start][j] == 0 && nodes[j] == 0) {
							list.add(j);
							v[start][j] = 1;
							nodes[j] = 1;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}