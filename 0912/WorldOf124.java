package Level2;

public class WorldOf124 {

	public static void main(String[] args) {
		for (int i = 1; i <= 15; i++) {
			System.out.println(solution(i));		
		}
	}
	
	public static String solution(int n) {
		String answer = "";
		int origin = n;
		
		
		while(origin > 0) {
			switch (origin % 3) {
			case 1:
				answer = "1" + answer;
				origin /= 3;
				break;
			case 2:
				answer = "2" + answer;
				origin /= 3;
				break;
			case 0:
				answer = "4" + answer;
				origin /= 3;
				origin--;
				break;
			}
			
		}
		
		return answer;
	}
}
