package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// SWEA 6958, 동철이의 프로그래밍 대회 D3
public class Sw6958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= TC; t++) {
			int winner = 0;
			int solved = 0;
			
			// Input Setting
			String[] inputs = br.readLine().split(" ");
			
			int N = Integer.parseInt(inputs[0]);
			int M = Integer.parseInt(inputs[1]);
			
			for(int i = 0; i < N; i++) {
				String answer = br.readLine();
				answer = answer.replace(" ", "").replace("0", "");	// 성공한 문제의 개수를 보기 위해 공백과 0을 제거한다

				if(answer.length() >= solved) {						
					if(answer.length() == solved) {					// 기존 1등과 같게 푼 경우
						winner += 1;								// 우승자 + 1
					} else {										// 기존 1등보다 많이 푼 경우
						winner = 1;									// 이 사람만 1등이기 때문에 winner를 1로 초기화
						solved = answer.length();					// solved 최신화
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(winner).append(" ").append(solved).append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
