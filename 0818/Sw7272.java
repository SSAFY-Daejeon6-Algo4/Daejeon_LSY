package com.ssafy.d3;

import java.io.*;

public class Sw7272 {
	public static String Answer;
	public static String one_o = "ADOPQR";
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= tc; i++) {
			String str = br.readLine();
			String str1 = str.split(" ")[0];
			String str2 = str.split(" ")[1];
			int flag = 1;
			Answer = "DIFF";
			
			if(str1.length() != str2.length()) {
				sb.append("#" + i + " " + Answer + "\n");
				continue;
			}
			
			for(int k = 0; k < str1.length(); k++) {
				if(one_o.contains(String.valueOf(str1.charAt(k)))) {
					if(!one_o.contains(String.valueOf(str2.charAt(k)))) {
						flag = 0;
						break;
					}
				} else if(str1.charAt(k) == 'B') {
					if(str2.charAt(k) != 'B') {
						flag = 0;
						break;
					}
				} else {
					if(str2.charAt(k) == 'B' || one_o.contains(String.valueOf(str2.charAt(k)))) {
						flag = 0;
						break;
					}
				}
			}
			
			if(flag == 1) {
				Answer = "SAME";
			} 
			sb.append("#" + i + " " + Answer + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
