import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
// 제로
public class BJ_10773_제로 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> st = new Stack<>();
		int K = sc.nextInt();
		int n, sum = 0;
		for (int i = 0; i < K; i++) {
			n = sc.nextInt();
			if(n == 0) 	st.pop();
			else 		st.push(n);
		}
		while(!st.empty()) {
			sum += st.pop();
		}
		System.out.println(sum);
	}
}