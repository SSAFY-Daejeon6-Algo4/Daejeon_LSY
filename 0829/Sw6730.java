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

			for (int i = 1; i < N; i++) {
				if (huddle[i] > huddle[i - 1]) {
					up = Math.max(huddle[i] - huddle[i - 1], up);
				} else {
					down = Math.max(huddle[i - 1] - huddle[i], down);
				}
			}

			sb.append("#").append(t).append(" ").append(up).append(" ").append(down).append("\n");
		}
		System.out.println(sb.toString());
	}

}
