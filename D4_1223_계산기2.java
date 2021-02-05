package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class D4_1223_계산기2 {

	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("calc.txt"));
		Scanner sc = new Scanner(System.in);
		int n;
		char[] input;
		Queue<Character> postfix = new LinkedList<>();
		Stack<Character> operator = new Stack<>();
		Stack<Integer> calculate = new Stack<>();

		for (int tc = 1; tc <= 10; tc++) {
			n = sc.nextInt();
			input = sc.next().toCharArray();
			// postfix에 후위 표기식 offer
			for (int i = 0; i < input.length; i++) {
				// 숫자면 postfix stack에 push
				if (input[i] >= '0' && input[i] <= '9') {
					postfix.offer(input[i]);
				} 
				else if (input[i] == '+' && operator.size() != 0) {
					if (operator.peek() == '*') {
						while (operator.size() > 0) {
							postfix.offer(operator.pop());
						}
						operator.push(input[i]);
					} else {
						operator.push(input[i]);
						postfix.offer(operator.pop());
					}
				} 
				else if (input[i] == '+' && operator.size() == 0) {
					operator.push(input[i]);
				} 
				else if (input[i] == '*') {
					operator.push(input[i]);
				}
			}
			while (operator.size() > 0)
				postfix.offer(operator.pop());
			
			// 수식 계산
			while(postfix.size() > 0) {
				if(postfix.peek() >= '0' && postfix.peek() <= '9') {
					calculate.push(postfix.poll()-'0');
				}
				else {
					if(postfix.peek() == '+') {
						calculate.push(calculate.pop() + calculate.pop());
						postfix.poll();
					}
					else if(postfix.peek() == '*') {
						calculate.push(calculate.pop() * calculate.pop());
						postfix.poll();
						
					}
				}
			}
			System.out.println("#" + tc + " " + calculate.peek());
		}
	}
}
