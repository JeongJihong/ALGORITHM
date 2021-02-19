import java.io.*;
import java.util.*;
// 점프점프

public class BJ_18512_점프점프 {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int AP = Integer.parseInt(st.nextToken());
		int BP = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> aLoc = new ArrayList<>();
		ArrayList<Integer> bLoc = new ArrayList<>();
		
		int mul = 0;
		int size = 1;
		
		while(true) {
			aLoc.add(AP + X * mul);
			bLoc.add(BP + Y * mul);
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (!aLoc.get(i).equals(bLoc.get(j))){
						if(aLoc.get(i) > 10000 || bLoc.get(j)> 10000) {
							 System.out.println(-1);
							 return;
						}
					}
					else {
						 System.out.println(aLoc.get(i));
						 return;
					}
				}
			}
			++mul;
			++size;
		}
	}
}