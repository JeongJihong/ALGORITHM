import java.io.*;
import java.util.*;

public class BJ_11724_연결요소의개수 {

	static int N, M;
	static int parents[];
	
	static void makeSet() {	// 크기가 1인 단위집합을 만든다.
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int a) {
		if(parents[a] == a)	// 내가 그 집합의 대표자
			return a;
		else 
			return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot)	return false;
		else {
			parents[bRoot] = aRoot;
			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		HashSet<Integer> set = new HashSet<>();
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N+1];
		
		makeSet();
		
		for (int i = 0; i < M; i++) {	// 간선 연결하기
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			union(u, v);
		}
		
		for (int i = 1; i <= N; i++) {
			set.add(findSet(i));
		}
		
		System.out.println(set.size());
	}
}
