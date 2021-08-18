package com.ssafy.d3;

import java.util.Scanner;

public class Sw2805 {
	public static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int tc = sc.nextInt();
		
		for(int i = 1; i <= tc; i++) {
			int N = sc.nextInt();
			sum = 0;
			
			int[][] farm = new int[N][N];
			
			// 배열 입력받기
			for(int row = 0; row < N; row++) {
				String str = sc.next();
				for(int col = 0; col < N; col++) {
					farm[row][col] = str.charAt(col) - '0';
				}
			}
			
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < N; col++) {
					int new_row = Math.abs((N / 2) - row);
					if(col >= new_row && col < N - new_row) {
						sum += farm[row][col];						
					} 
				}
			}
			sb.append("#" + i + " " + sum + "\n");
		}
		System.out.println(sb.toString());
	}
}
