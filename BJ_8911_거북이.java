import java.io.*;
import java.util.*;


public class BJ_8911_거북이 {

	public static void main(String args[]) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		char[] charr;
		int x = 0, y = 0, minX = 0, maxX = 0, minY = 0, maxY = 0;
		int[] d = {0, 1};
		
		for (int tc = 0; tc < T; tc++) {
			x = 0; y = 0; minX = 0; maxX = 0; minY = 0; maxY = 0;
			d[0] = 0;
			d[1] = 1;
			charr = br.readLine().toCharArray();
			for (int i = 0; i < charr.length; i++) {
				switch (charr[i]) {
				case 'F':
					x += d[0];
					y += d[1];
					break;
				case 'B':
					x -= d[0];
					y -= d[1];
					break;
				case 'L':
					if(d[0] == 0 && d[1] == 1) {	// 앞으로 가는 방향
						d[0] = -1;
						d[1] = 0;
					}
					else if(d[0] == -1 && d[1] == 0) {	// 왼쪽으로 가는 방향
						d[0] = 0;
						d[1] = -1;
					}
					else if(d[0] == 0 && d[1] == -1) {	// 아래로 가는 방향
						d[0] = 1;
						d[1] = 0;
					}
					else if(d[0] == 1 && d[1] == 0) {	// 오른쪽으로 가는 방향
						d[0] = 0;
						d[1] = 1;
					}
					break;
				case 'R':
					if(d[0] == 0 && d[1] == 1) {	// 앞으로 가는 방향
						d[0] = 1;
						d[1] = 0;
					}
					else if(d[0] == -1 && d[1] == 0) {	// 왼쪽으로 가는 방향
						d[0] = 0;
						d[1] = 1;
					}
					else if(d[0] == 0 && d[1] == -1) {	// 아래로 가는 방향
						d[0] = -1;
						d[1] = 0;
					}
					else if(d[0] == 1 && d[1] == 0) {	// 오른쪽으로 가는 방향
						d[0] = 0;
						d[1] = -1;
					}
					break;
				}
				minX = Math.min(minX, x);
				maxX = Math.max(maxX, x);
				minY = Math.min(minY, y);
				maxY = Math.max(maxY, y);
			}
			System.out.println((maxX - minX) * (maxY - minY));
		}
	}
}