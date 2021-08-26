package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// SWEA 6730, 장애물 경주 난이도
public class Sw6730 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			int up = 0, down = 0;

			int N = Integer.parseInt(br.readLine());
			int[] huddle = new int[N];
			huddle = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			for (int i = 1; i < N; i++) {	// 첫 허들은 검사할 필요가 없으므로 다음 허들 부터 시작
				if (huddle[i] > huddle[i - 1]) {	// 이전 허들보다 현재 허들이 높으면
					up = Math.max(huddle[i] - huddle[i - 1], up);	// 높이뛰기 난이도를 최신화
				} else {							// 이전 허들이 현재 허들보다 높으면
					down = Math.max(huddle[i - 1] - huddle[i], down);	// 뛰어내리기 난이도를 최신화
				}
			}

			sb.append("#").append(t).append(" ").append(up).append(" ").append(down).append("\n");
		}
		System.out.println(sb.toString());
	}

}
