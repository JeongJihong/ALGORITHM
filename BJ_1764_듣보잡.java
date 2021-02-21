import java.io.*;
import java.util.*;
// 듣보잡
public class BJ_1764_듣보잡 {
	
	static ArrayList<String> list = new ArrayList<>();
	static ArrayList<String> noHear = new ArrayList<>();
	static ArrayList<String> noSee = new ArrayList<>();

	public static void main(String args[]) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			noHear.add(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			noSee.add(br.readLine());
		}
		
		noHear.sort(null);
		noSee.sort(null);
		for (int i = 0; i < M; i++) {
				binarySearch(0, noHear.size()-1, noSee.get(i));
		}
		
		System.out.println(list.size());
		list.sort(null);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void binarySearch(int start, int end, String str) {
		if(start > end)	return;
		
		int mid = (start + end) / 2;
		if(noHear.get(mid).equals(str)) {
			list.add(str);
		}
		else if(noHear.get(mid).compareTo(str) < 0) {
			binarySearch(mid+1, end, str);
		}
		else if(noHear.get(mid).compareTo(str) > 0) {
			binarySearch(start, mid-1, str);
		}
	}
	
}