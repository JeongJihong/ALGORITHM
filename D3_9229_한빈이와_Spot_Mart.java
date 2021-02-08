import java.util.Scanner;

public class D3_9229_한빈이와_Spot_Mart {
	static int M, sum, max;
	
	public static void main(String[] args) {
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N;
		int snack[];
		for (int tc = 1; tc <= T; tc++) {
			sum = 0;
			max = -1;
			N = sc.nextInt();
			M = sc.nextInt();
			snack = new int[N];
			for (int i = 0; i < snack.length; i++) {
				snack[i] = sc.nextInt();
			}
			choose(snack, new int[2], 0, 0);
			System.out.println("#" + tc + " " + max);
		}
	}

	private static void choose(int[] snack, int[] sel, int cnt, int start) {
		if(cnt == 2) {
			sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if(sum <= M) {
				max = Math.max(max, sum);
			}
			return;
		}
		for (int i = start; i < snack.length; i++) {
			sel[cnt] = snack[i];
			choose(snack, sel, cnt+1, i+1);
		}
	}
}
