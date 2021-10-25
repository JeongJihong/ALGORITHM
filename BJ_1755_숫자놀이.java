import java.io.*;
import java.util.*;

public class Main {
	
	static int M, N;
	static int[] arr;
	static String[] strArr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N - M + 1];
		strArr = new String[N - M + 1];
		
		// 배열에 숫자 저장
		for (int i = M; i < N + 1; i++) {
			arr[i - M] = i;
		}
		
		// 숫자 -> 문자 -> 숫자
		
		for (int i = 0; i < arr.length; i++) {
			// 숫자를 영어 단어로 바꿔서 저장
			if(arr[i] < 10) {	// 숫자가 한자리수일 경우
				if(arr[i] == 1) {
					strArr[i] = "one";
				} else if(arr[i] == 2) {
					strArr[i] = "two";
				} else if(arr[i] == 3) {
					strArr[i] = "three";
				} else if(arr[i] == 4) {
					strArr[i] = "four";
				} else if(arr[i] == 5) {
					strArr[i] = "five";
				} else if(arr[i] == 6) {
					strArr[i] = "six";
				} else if(arr[i] == 7) {
					strArr[i] = "seven";
				} else if(arr[i] == 8) {
					strArr[i] = "eight";
				} else if(arr[i] == 9) {
					strArr[i] = "nine";
				} else if(arr[i] == 0) {
					strArr[i] = "zero";
				}
			} else {	// 숫자가 두자리수일 경우
				int ten = arr[i] / 10;
				if(ten == 1) {	// 10의 자리 수를 저장
					strArr[i] = "one";
				} else if(ten == 2) {
					strArr[i] = "two";
				} else if(ten == 3) {
					strArr[i] = "three";
				} else if(ten == 4) {
					strArr[i] = "four";
				} else if(ten == 5) {
					strArr[i] = "five";
				} else if(ten == 6) {
					strArr[i] = "six";
				} else if(ten == 7) {
					strArr[i] = "seven";
				} else if(ten == 8) {
					strArr[i] = "eight";
				} else if(ten == 9) {
					strArr[i] = "nine";
				} else if(ten == 0) {
					strArr[i] = "zero";
				}
				
				int one = arr[i] % 10;
				if(one == 1) {	// 1의 자리수를 저장
					strArr[i] += " one";
				} else if(one == 2) {
					strArr[i] += " two";
				} else if(one == 3) {
					strArr[i] += " three";
				} else if(one == 4) {
					strArr[i] += " four";
				} else if(one == 5) {
					strArr[i] += " five";
				} else if(one == 6) {
					strArr[i] += " six";
				} else if(one == 7) {
					strArr[i] += " seven";
				} else if(one == 8) {
					strArr[i] += " eight";
				} else if(one == 9) {
					strArr[i] += " nine";
				} else if(one == 0) {
					strArr[i] += " zero";
				}
			}
		}
		Arrays.sort(strArr);	// 문자열을 정렬

	
		for (int i = 0; i < strArr.length; i++) {
			if(!strArr[i].contains(" "))	{ // 한자리수일 경우
				if(strArr[i].equals("one")) {
					arr[i] = 1;
				} else if(strArr[i].equals("two")) {
					arr[i] = 2;
				} else if(strArr[i].equals("three")) {
					arr[i] = 3;
				} else if(strArr[i].equals("four")) {
					arr[i] = 4;
				} else if(strArr[i].equals("five")) {
					arr[i] = 5;
				} else if(strArr[i].equals("six")) {
					arr[i] = 6;
				} else if(strArr[i].equals("seven")) {
					arr[i] = 7;
				} else if(strArr[i].equals("eight")) {
					arr[i] = 8;
				} else if(strArr[i].equals("nine")) {
					arr[i] = 9;
				} else if(strArr[i].equals("zero")) {
					arr[i] = 0;
				}
			} else {	// 두자리수일 경우
				String[] s = strArr[i].split(" ");	// 빈칸을 기준으로 쪼갠다
				if(s[0].equals("one")) {	// 십의 자리 수
					arr[i] = 10;
				} else if(s[0].equals("two")) {
					arr[i] = 20;
				} else if(s[0].equals("three")) {
					arr[i] = 30;
				} else if(s[0].equals("four")) {
					arr[i] = 40;
				} else if(s[0].equals("five")) {
					arr[i] = 50;
				} else if(s[0].equals("six")) {
					arr[i] = 60;
				} else if(s[0].equals("seven")) {
					arr[i] = 70;
				} else if(s[0].equals("eight")) {
					arr[i] = 80;
				} else if(s[0].equals("nine")) {
					arr[i] = 90;
				} else if(s[0].equals("zero")) {
					arr[i] = 0;
				}
				
				if(s[1].equals("one")) {	// 일의 자리 수
					arr[i] += 1;
				} else if(s[1].equals("two")) {
					arr[i] += 2;
				} else if(s[1].equals("three")) {
					arr[i] += 3;
				} else if(s[1].equals("four")) {
					arr[i] += 4;
				} else if(s[1].equals("five")) {
					arr[i] += 5;
				} else if(s[1].equals("six")) {
					arr[i] += 6;
				} else if(s[1].equals("seven")) {
					arr[i] += 7;
				} else if(s[1].equals("eight")) {
					arr[i] += 8;
				} else if(s[1].equals("nine")) {
					arr[i] += 9;
				} else if(s[1].equals("zero")) {
					arr[i] += 0;
				}
			}
		}
		
		for (int i = 1; i <= arr.length; i++) {
			System.out.print(arr[i-1] + " ");
			if(i % 10 == 0) {
				System.out.println();
			}
		}
	}
}
