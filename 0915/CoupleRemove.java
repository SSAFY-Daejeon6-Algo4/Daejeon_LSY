package Level2;

import java.util.Stack;

// 프로그래머스 2단계, 짝지어 제거하기
public class CoupleRemove {
	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
		System.out.println(solution("acac"));
	}
	
	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		if(s.length() % 2 != 0) return 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(stack.empty()) {
				stack.push(s.charAt(i));
			} else {
				if(stack.peek() == s.charAt(i)) {
					stack.pop();
				} else {
					stack.push(s.charAt(i));
				}
			}
		}
		
		if(stack.empty()) {
			return 1;
		} else {
			return 0;
		}
    }
}
