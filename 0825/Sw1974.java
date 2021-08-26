package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// SWEA 1974, 스도쿠 검증 D2
public class Sw1974 {
	static int[][] sudoku;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= TC; t++) {
			sudoku = new int[9][9];
			int answer;
			
			for(int i = 0; i < 9; i++) {
				sudoku[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			answer = (isRCAvail() && isBoxAvail()) ? 1 : 0;
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static boolean isRCAvail() {
		for(int i = 0; i < 9; i++) {
			boolean[] existR = new boolean[10];
			boolean[] existC = new boolean[10];
			for(int j = 0; j < 9; j++) {
				if(!existR[sudoku[i][j]] && !existC[sudoku[j][i]]) {
					existR[sudoku[i][j]] = true;
					existC[sudoku[j][i]] = true;
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isBoxAvail() {
		int row = 1;
		int col = 1;
		while(true) {
			boolean[] exist = new boolean[10];
			for(int i = 3 * (row - 1); i < 3 * row; i++) {
				for(int j = 3 * (col - 1); j < 3 * col; j++) {
					if(!exist[sudoku[i][j]]) {
						exist[sudoku[i][j]] = true;
					} else {
						return false;
					}
				}
			}
			
			col++;
			if(col == 4) {	// 열의 끝에 도달했으면
				if(row == 3) {	// 만약 행의 끝, 열의 끝까지 조사했으면 탈출
					break;
				}
				col = 1;		// 그 외에는 다음 행의 1열부터 조사
				row ++;
			}
		}
		return true;
	}
}
