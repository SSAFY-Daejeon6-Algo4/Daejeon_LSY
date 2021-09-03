package Level2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 프로그래머스 2단계, 문자열 압축
public class StringCompression {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(solution("aaabb"));
	}
	
	public static int solution(String str) {
		int result = str.length();
		int N = str.length();
		
		for(int i = 0; i <=  N / 2; i++) {		// 절반 이후에는 어차피 의미가 없으므로 N / 2만큼만 시행
			String comp = "";
			String start = str.substring(0, i + 1); 
			int count = 1;
			int idx = i + 1;
			
			if(idx == N) {
				return N;
			}
			
			while(idx < N) {
				int new_idx = idx + (i + 1);
				
				if(new_idx >= N) {	
					if(new_idx == N) {			// 딱 맞아떨어질 때
						if(str.substring(idx, new_idx).equals(start)) {	// 마지막 원소가 같은 경우
							count += 1;
							comp += count + start;
						} else {										// 마지막 원소가 다른 경우
							if(count == 1) {
								comp += start;
							} else {
								comp += count + start;	
								count = 1;
							}
							comp += str.substring(idx, new_idx);
						}						
					} else {											// 남은 원소가 간격보다 적을 때
						if(count == 1) {
							comp += start;
						} else {
							comp += count + start;	
							count = 1;
						}
						comp += str.substring(idx);						// 남은 원소 그대로 붙여서 출력
					}
					break;
				}
				
				if(str.substring(idx, new_idx).equals(start)) {			// 이전 원소와 같은 경우
					count += 1;
				} else {												// 이전 원소와 다른 경우
					if(count == 1) {
						comp += start;
					} else {
						comp += count + start;	
						count = 1;
					}
					start = str.substring(idx, new_idx);
				}
				
				idx = new_idx;
			}
			result = Math.min(result, comp.length());
		}
		return result;
	}
}
