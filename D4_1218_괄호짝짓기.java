package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class D4_1218_괄호짝짓기 {
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("1218.txt"));
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<>();
		int T, ans;
		String str;
		char c;
		
		for (int tc = 1; tc <= 10; tc++) {
			// 입력
			T = sc.nextInt();
			str = sc.next();
			ans = 1;
			st.clear();
			for (int i = 0; i < T; i++) {
				c = str.charAt(i);
				// 여는 괄호면 그냥 넣는다
				if(c == '{' || c == '[' || c == '<' || c == '(')
					st.push(str.charAt(i));
				// 닫는 괄호면 맨 위에 있는 괄호와 확인한 뒤 pop한다
				else if(c == '}' && st.peek() == '{') {
					st.pop();
				}
				else if(c == ']' && st.peek() == '[') {
					st.pop();
				}
				else if(c == '>' && st.peek() == '<') {
					st.pop();
				}
				else if(c == ')' && st.peek() == '(') {
					st.pop();
				}
				// 정상적인 입력이 아니면 break
				else {
					ans = 0;
					break;
				}
			}
			// 출력
			System.out.println("#" + tc + " " + ans);
		}
		sc.close();
	}
}