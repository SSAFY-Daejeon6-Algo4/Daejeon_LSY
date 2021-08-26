package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// SWEA 1859, 백만 장자 프로젝트
public class Sw1859 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int t = 1; t <= TC; t++) {
			long answer = 0;		// sum값이 int의 범위를 벗어날 수 있으므로 long으로 쓴다.
			int N = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			int value = arr[arr.length - 1];
			for(int i = arr.length - 2; i >= 0; i--) {
				if(arr[i] >= value) {
					value = arr[i];
				}else {
					answer += value - arr[i];					
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
