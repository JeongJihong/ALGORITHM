import java.io.*;
import java.util.*;

public class JO_1303_숫자사각형1 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int num = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(num++ + " ");
			}
			System.out.println();
		}
	}
}