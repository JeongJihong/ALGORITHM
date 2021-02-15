import java.io.*;
import java.util.*;

public class BJ_3040_백설공주와_일곱난쟁이 {
	
	static int[] input = new int[9];
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		comb(0, 0, new int[7]);
	}

	private static void comb(int cnt, int start, int[] dwarf) {
		if(cnt == 7) {
			int sum = 0;
			for (int i = 0; i < dwarf.length; i++) {
				sum += dwarf[i];
			}
			if(sum == 100) {
				for (int i = 0; i < dwarf.length; i++) {
					System.out.println(dwarf[i]);
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			dwarf[cnt] = input[i];
			comb(cnt+1, i+1, dwarf);
		}
	}
	
}