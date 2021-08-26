package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1940, 가랏! RC카! D2
public class Sw1940 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		// Test Case
		for(int t = 1; t <= TC; t++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			
			int speed = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int command = Integer.parseInt(st.nextToken());
				int new_speed = 0;
				if(st.hasMoreTokens()) {
					new_speed = Integer.parseInt(st.nextToken());					
				}
				
				if(command == 2) {		// 감속인 경우
					speed -= new_speed;	// 기존 속도에 입력받은 속도를 뺀 속도가 새로운 속도
					if(speed <= 0) {	// 속도 0 이하면 0으로 고정
						speed = 0;
					} else {			// 그 외엔 1초간 새 속도로 이동
						answer += speed;
					}
				} else if(command == 1) {	// 가속인 경우
					speed += new_speed;		// 기존 속도에 입력받은 속도를 더한 속도가 새로운 속도
					answer += speed;		// 1초간 새 속도로 이동
				} else {					// 0(현재 속도 유지), 이전 속도와 동일하게 이동
					answer += speed;
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
