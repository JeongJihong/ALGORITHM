package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

// 배열 돌리기 3
class Main {
	static int R;
	static int row, col;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		// 입력 받기
		row = sc.nextInt();
		col = sc.nextInt();
		R = sc.nextInt();
		int[] op = new int[R];
		int[][] arr = new int[row][col];
		int temp;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < R; i++) {
			op[i] = sc.nextInt();
		}

		// 배열 계산하기
		for (int r = 0; r < R; r++) {
			switch (op[r]) {
			case 1:
				for (int i = 0; i < row / 2; i++) {
					for (int j = 0; j < col; j++) {
						temp = arr[i][j];
						arr[i][j] = arr[row - 1 - i][j];
						arr[row - 1 - i][j] = temp;
					}
				}
				break;
			case 2:
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col / 2; j++) {
						temp = arr[i][j];
						arr[i][j] = arr[i][col - 1 - j];
						arr[i][col - 1 - j] = temp;
					}
				}
				break;
			case 3:
				temp = row;
				row = col;
				col = temp;
				int[][] arr1 = new int[row][col];
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						arr1[i][j] = arr[col - 1 - j][i];
					}
				}
				arr = arr1;
				break;
			case 4:
				temp = row;
				row = col;
				col = temp;
				int[][] arr2 = new int[row][col];
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						arr2[i][j] = arr[j][row - 1 - i];
					}
				}
				arr = arr2;
				break;
			case 5:
				int[][] arr3 = new int[row][col];
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (i < row / 2 && j < col / 2) { // 1
							arr3[i][j + col / 2] = arr[i][j];
						} else if (i < row / 2 && j >= col / 2 && j < col) { // 2
							arr3[i + row / 2][j] = arr[i][j];
						} else if (i >= row / 2 && i < row && j >= col / 2 && j < col) { // 3
							arr3[i][j - col / 2] = arr[i][j];
						} else { // 4
							arr3[i - row / 2][j] = arr[i][j];
						}
					}
				}
				arr = arr3;
				break;
			case 6:
				int[][] arr4 = new int[row][col];
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						if (i < row / 2 && j < col / 2) { // 1
							arr4[i+row/2][j] = arr[i][j];
						} else if (i < row / 2 && j >= col / 2 && j < col) { // 2
							arr4[i][j-col/2] = arr[i][j];
						} else if (i >= row / 2 && i < row && j >= col / 2 && j < col) { // 3
							arr4[i-row/2][j] = arr[i][j];
						} else { // 4
							arr4[i][j+col/2] = arr[i][j];
						}
					}
				}
				arr = arr4;
				break;
			}
		}

		// 출력하기
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}