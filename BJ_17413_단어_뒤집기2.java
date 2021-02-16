import java.io.*;
import java.util.*;

// 단어 뒤집기2
public class BJ_17413_단어_뒤집기2 {

	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		Stack<Character> ch = new Stack<>();
		String s;
		s = sc.nextLine();

		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() && s.charAt(i) == '<') {
				// 태그 출력
				while (s.charAt(i) != '>')
					System.out.print(s.charAt(i++));
				System.out.print('>');

			} else {
				while(i < s.length() && s.charAt(i) != ' ' && s.charAt(i) != '<') {
					ch.push(s.charAt(i++));
				}
				while (!ch.isEmpty()) {
					System.out.print(ch.pop());
				}
				if(i < s.length() && s.charAt(i) != '<') {
					System.out.print(" ");
					continue;
				}
				--i;
			}
		}
		
	}
}