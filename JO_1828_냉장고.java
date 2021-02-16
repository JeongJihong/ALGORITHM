import java.io.*;
import java.util.*;

// 냉장고
class Temp implements Comparable<Temp> {
	int x, y;

	public Temp() {
		super();
	}

	public Temp(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Temp o) {
		int d = this.y - o.y;
		return d != 0 ? d : this.x - o.x;
	}

}

public class JO_1828_냉장고 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int cnt = 1;
		int N = sc.nextInt();
		Temp[] t = new Temp[N];
		Temp stan;
		for (int i = 0; i < t.length; i++) {
			t[i] = new Temp(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(t);
		
		stan = new Temp(t[0].x, t[0].y);
		for (int i = 1; i < t.length; i++) {
			if(!(stan.y >= t[i].x && stan.y <= t[i].y))	{
				++cnt;
				stan = new Temp(t[i].x, t[i].y);
			}
		}
		System.out.println(cnt);
	}
}