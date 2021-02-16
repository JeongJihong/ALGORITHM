import java.io.*;
import java.util.*;

// 직사각형을 만드는 방법
public class BJ_8320_직사각형을_만드는_방법 {
	public static void main(String args[]) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = n;

		for (int i = 2; i * i <= n; i++) {
			for (int j = i; j <= n / i; j++) {
				++cnt;
			}
		}
		System.out.println(cnt);
	}
}