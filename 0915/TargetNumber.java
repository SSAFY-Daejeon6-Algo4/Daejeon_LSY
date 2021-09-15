package Level2;

public class TargetNumber {

	static int answer = 0;
	static boolean[] visit;
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
	}
	
	public static int solution(int[] numbers, int target) {
		visit = new boolean[numbers.length];
        subset(0, target, numbers);
        return answer;
    }
	
	public static void subset(int n, int target, int[] numbers) {
		if(n == numbers.length) {
			int sum = 0;
			for(int i = 0; i < numbers.length; i++) {
				if(visit[i]) {					// 선택된 애들은 음수로 가정
					sum += -1 * numbers[i];
				} else {						// 비선택된 애들은 양수로 가정
					sum += numbers[i];
				}
			}
			if(sum == target) answer++;			// 총 합이 타겟 넘버와 같은 경우만 + 1
			return;
		}
		
		visit[n] = true;
		subset(n + 1, target, numbers);			// 부분집합으로 계산
		
		visit[n] = false;
		subset(n + 1, target, numbers);
	}
}
