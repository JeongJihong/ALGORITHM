import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class D3_1228_암호문1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("calc.txt"));
		Scanner sc = new Scanner(System.in);
		LinkedList<String> origin = new LinkedList<>();
		int originLen, orderNum, INum, x, y;
		for (int tc = 1; tc <= 10; tc++) {
			INum = 0;
			origin.clear();
			originLen = sc.nextInt();
			for (int i = 0; i < originLen; i++) {
				origin.add(sc.next());
			}
			orderNum = sc.nextInt();
			while(INum < orderNum) {
				if(sc.next().charAt(0) == 'I') {
					++INum;
					x = sc.nextInt();
					y = sc.nextInt();
					for (int i = 0; i < y; i++) {
						origin.add(x, sc.next());
						++x;
					}
				}
			}
			System.out.print("#" + tc + " ");
			Iterator<String> iter = origin.iterator();
			for (int i = 0; i < 10; i++) {
				System.out.print(iter.next() + " ");
			}
			System.out.println();
		}
	}
}
