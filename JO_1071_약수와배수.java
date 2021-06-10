import java.io.*;
import java.util.*;

public class JO_1071_약수와배수 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n, m;
		n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		int divisor = 0, mutiple= 0;
		for (int i = 0; i < n; i++) {
			if(arr[i] <= m) {
				if(m % arr[i] == 0)	divisor += arr[i];
			}
			if(arr[i] >= m) {
				if(arr[i] % m == 0) mutiple += arr[i];
			}
		}
		
		System.out.println(divisor);
		System.out.println(mutiple);
	}
}