package Level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MoreHot {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
	}
	
	public static int solution(int[] scoville, int K) {
		int answer = 0;
		
		Arrays.sort(scoville);
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(int i : scoville) {
			queue.add(i);
		}
		
		while(queue.size() > 1) {
			System.out.println(queue);
			if(queue.peek() >= K) {
				break;
			}
			else {
				int hot1 = queue.poll();
				int hot2 = queue.poll();
				
				queue.add(hot1 + hot2 * 2);
				answer++;
			}
		}
		
		if(queue.peek() < K) {
			return -1;
		}
		
		return answer;
	}
}
