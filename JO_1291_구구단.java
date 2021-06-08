import java.io.*;
import java.util.*;

public class JO_1291_구구단 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		while(s < 2 || s > 9 || e < 2 || e > 9) {
			System.out.println("INPUT ERROR!");
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= 9; i++) {
			if(s < e) {
				for (int j = s; j <= e; j++) {
					System.out.print(j + " * " + i + " = ");
					System.out.printf("%2d   ", j * i);
				}
			}
			else {
				for (int j = s; j >= e; j--) {
					System.out.print(j + " * " + i + " = ");
					System.out.printf("%2d   ", j * i);
				}
			}
			System.out.println();
		}
	}
}