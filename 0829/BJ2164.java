import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 백준 2164, 카드2 S4
public class BJ2164 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {	// 숫자 1~N까지를  queue에 넣는다.
			queue.add(i);				
		}
		
		while(queue.size() != 1) {		// 숫자가 1개만 남을 때까지 
			queue.poll();				// 맨 앞 숫자는 삭제하고
			queue.add(queue.poll());	// 다음 숫자는 맨뒤로 보낸다.
		}
		
		System.out.println(queue.poll());	// 하나 남은 원소를 출력한다.
	}
}
