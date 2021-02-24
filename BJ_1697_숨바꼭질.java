import java.io.*;
import java.util.*;
// 숨바꼭질
public class BJ_1697_숨바꼭질 {
	
	static int N, K;
	static int[] visited = new int [100001];
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		visited[N] = 1;
		while(!q.isEmpty()) {
			N = q.poll();
			if(N == K)	break;
			
			if(N + 1 <= 100000 && visited[N+1] == 0) {
				q.offer(N+1);
				visited[N+1] = visited[N]+1;
			} if(N -1 >= 0 && visited[N-1] == 0) {
				q.offer(N-1);
				visited[N-1] = visited[N]+1;
			} if(N*2 <= 100000 && visited[N*2] == 0) {
				q.offer(N*2);
				visited[N*2] = visited[N]+1;
			}
		}
		System.out.println(visited[K]-1);
	}
}