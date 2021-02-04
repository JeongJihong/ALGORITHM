package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class BJ_2493_탑 {
	
	static class Building {
		int height, idx;
		
		public Building(int height, int idx) {
			super();
			this.height = height;
			this.idx = idx;
		}
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Building> st = new Stack<>();
		int[] ans = new int[N];
		Building b, current;
		str = new StringTokenizer(br.readLine());
		
		// 첫번째 빌딩
		b = new Building(Integer.parseInt(str.nextToken()), 1);
		st.push(b);
		ans[0] = 0;
		// 2~N번째 빌딩
		for (int i = 1; i < N; i++) {
			current  = new Building(Integer.parseInt(str.nextToken()), i+1);
			// 이전 건물의 높이가 현재 높이보다 낮다면
			if(st.peek().height < current.height) {
				// stack이 비어있지않고 이전 건물의 높이 < 현재 건물의 높이일 동안 계속 앞의 건물을 pop한다
				while(!st.isEmpty() && st.peek().height < current.height) {
					st.pop();
				}
			}
			// 만약 stack이 비어있다면 앞의 건물 중 현재보다 큰 건물은 없으므로 0을 저장
			if(st.isEmpty()) {
				st.push(current);
				ans[i] = 0;
			}
			// stack이 비어있지 않고, 앞의 건물 높이가 현재 건물 높이보다 높다면 앞 건물 idx저장
			else if(st.peek().height > current.height) {
				ans[i] = st.peek().idx;
				st.push(current);
			}
		}
		for (int i = 0; i < N; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);
	}
}