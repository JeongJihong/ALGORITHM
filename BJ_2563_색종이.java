import java.io.*;
import java.util.*;
// 색종이
public class BJ_2563_색종이 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] basePaper = new int[100][100]; 
		int num = Integer.parseInt(st.nextToken());
		int[] left = new int[num];
		int[] down = new int[num];
		int res = 0;
		// 색종이 입력받기
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			left[i] = Integer.parseInt(st.nextToken());
			down[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < num; i++) {
			for (int l = left[i]-1; l < left[i]+9; l++) {
				for (int b = down[i]-1; b < down[i]+9; b++) {
					basePaper[l][b] = 1;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(basePaper[i][j] == 1)
					++res;
			}
		}
		System.out.println(res);
		br.close();
	}
}