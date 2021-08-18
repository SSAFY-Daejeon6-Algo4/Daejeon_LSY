package com.ssafy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sw1234 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc ++) {
			ArrayList<String> list = new ArrayList<>();
			String str = br.readLine();
			int size = Integer.parseInt(str.split(" ")[0]);
			
			// ArrayList에 숫자 할당
			for(int i = 0; i < size; i++) {
				list.add(str.split(" ")[1].split("")[i]);
			}
			int cnt = 0;
			while(cnt != list.size() - 1) {
				if(list.get(cnt).equals(list.get(cnt + 1))) {
					list.remove(cnt + 1);
					list.remove(cnt);
					cnt --;
					if(cnt < 0) {
						cnt = 0;
					}
				} else {
					cnt++;
				}
			}
			sb.append("#" + tc + " " + String.join("", list) + "\n");
		}	
		System.out.println(sb.toString());
	}

}
