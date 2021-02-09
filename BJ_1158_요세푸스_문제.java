import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class BJ_1158_요세푸스_문제 {
	public static void main(String args[]) throws FileNotFoundException {
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> p = new LinkedList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			p.offer(i+1);
		}
		
		System.out.print("<");
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < K-1; j++) {
				p.offer(p.poll());
			}
			System.out.print(p.poll() + ", ");
		}
		System.out.print(p.poll() + ">");
	}
}