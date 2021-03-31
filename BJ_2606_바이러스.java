import java.io.*;
import java.util.*;

// 바이러스

class BJ_2606_바이러스 {

	static int[][] arr;
	static int N, C;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			arr[p][q] = 1;
			arr[q][p] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> s = new HashSet<Integer>();
		q.offer(1);
		
		while(!q.isEmpty()) {
			int p = q.poll();
			for (int i = 1; i <= N; i++) {
				if(arr[p][i] == 1) {
					arr[i][p] = 0;
					arr[p][i] = 0;
					q.offer(i);
					s.add(i);
				}
			}
		}
		System.out.println(s.size());
	}
}