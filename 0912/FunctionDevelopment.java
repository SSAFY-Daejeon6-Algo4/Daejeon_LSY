package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelopment {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
		System.out.println(Arrays.toString(solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));
	}
	public static int[] solution(int[] progresses, int[] speeds) {
		int answer[] = new int[progresses.length];
		int rest[] = new int[progresses.length];
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < progresses.length; i++) {
			int restDays = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
			rest[i] = restDays;
		}
		
		int index = 0;
		int count = 0;
		int start = rest[index];
		
		while(index < progresses.length) {
			if(rest[index] <= start) {
				count += 1;
				index += 1;
			} else {
				list.add(count);
				count = 0;
				start = rest[index];
			}
		}
		
		if(count != 0) {
			list.add(count);
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
