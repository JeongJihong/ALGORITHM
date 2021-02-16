import java.io.*;
import java.util.*;

import javax.smartcardio.Card;

// 회의실 배정
class Meeting implements Comparable<Meeting> {
	int n, s, e;

	public Meeting(int n, int s, int e) {
		super();
		this.n = n;
		this.s = s;
		this.e = e;
	}
	
	@Override
	public int compareTo(Meeting o) {
		int d = this.e - o.e;
		return d != 0 ? d : this.s - o.s;
	}

}

public class JO_1370_회의실_배정 {
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 1;
		Meeting[] m = new Meeting[N];
		ArrayList<Meeting> list = new ArrayList<>();

		for (int i = 0; i < m.length; i++) {
			m[i] = new Meeting(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(m);
		// 첫번째 인자 넣기
		list.add(m[0]);

		for (int i = 1; i < m.length; i++) {
			if (list.get(list.size() - 1).e <= m[i].s) {
				list.add(m[i]);
				++cnt;
			}
		}
		System.out.println(cnt);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).n + " ");
		}
	}
}