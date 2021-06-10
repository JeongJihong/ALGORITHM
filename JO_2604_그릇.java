import java.io.*;
import java.util.*;

public class JO_2604_그릇 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] bowl = str.toCharArray();
		
		int res = 0;
		
		for (int i = 0; i < bowl.length - 1; i++) {
			if(bowl[i] == bowl[i+1])	res += 5;
			else						res += 10;
		}
		
		System.out.println(res + 10);
	}
}