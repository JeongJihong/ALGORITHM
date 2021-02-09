import java.io.*;
import java.util.*;

public class BJ_2164_카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while(q.size() > 1) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.peek());
	}
}
