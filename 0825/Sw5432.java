package com.ssafy.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

// SWEA 5432, 쇠막대기 자르기 D4
public class Sw5432 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= TC; t++) {
			int answer = 0;
			String input = br.readLine();
			LinkedList<Integer> list = new LinkedList<>();	
			
			input = input.replace("()", " ");				// 레이저쏘는 부분을 공백으로 치환
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == '(') {				// 열리면 막대기 하나씩 추가
					list.add(1);
				} else if(input.charAt(i) == ')'){			// 닫히면 막대기 하나의 셈이 끝났으므로 
					list.pollLast();						// 막대기를 list에서 제거하고
					answer += 1;							// answer에 1을 더한다.(2번 레이저를 쏘면 3조각이 되니까 + 1)
				} else {									// 공백이 오면 레이저를 쏜 거니까
					answer += list.size();					// 지금까지 들어있는 막대기의 개수만큼 더해준다.
				}
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
