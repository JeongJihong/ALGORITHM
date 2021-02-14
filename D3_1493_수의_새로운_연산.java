import java.io.*;
import java.util.*;

// 수의 새로운 연산
class Point {
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class D3_1493_수의_새로운_연산 {
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T, p, q, res;
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		Point gridP, gridQ, gridSum;

		for (int tc = 1; tc <= T; tc++) {
			res = 0;
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			
			gridP = getGrid(p);
			gridQ = getGrid(q);
			gridSum = new Point(gridP.x + gridQ.x, gridP.y + gridQ.y);
			res = getPoint(gridSum);
			System.out.println("#" + tc + " " + res);
		}
	}

	private static Point getGrid(int pp) {
		int x = 1, y = 1, idx = 1;
		for (int i = 1; i < pp; i++) {
			if(y == 1) {
				idx++;
				y = idx;
				x = 1;
			}
			else {
				x++;
				y--;
			}
		}
		return new Point(x, y);
	}

	private static int getPoint(Point pnt) {
		int x = 1, y = 1, cnt = 1, idx = 1;
		while(!(x == pnt.x && y == pnt.y)) {
			if(y == 1) {
				idx++;
				y = idx;
				x = 1;
			}
			else {
				x++;
				y--;
			}
			++cnt;
		}
		return cnt;
	}
}
