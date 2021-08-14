import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BJ2116 {
	static HashMap<Integer, Integer> hashMap;
	static int count, answer = 0, N;
	static int[][] dice;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		hashMap = new HashMap<>();		// 주사위를 입력받았을 때 서로 반대면에 해당하는 경우를 hashMap에 미리 저장
		hashMap.put(0, 5);
		hashMap.put(1, 3);
		hashMap.put(2, 4);
		hashMap.put(3, 1);
		hashMap.put(4, 2);
		hashMap.put(5, 0);

		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		
		for(int i = 0; i < N; i++) {
			dice[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = 1; i <= 6; i++) {
			count = 0;
			find_max(0, i);
//			System.out.println("--------count------- at : " +  i + ", count : " + count);
			answer = Math.max(count, answer);
		}
		System.out.println(answer);
	}

	public static void find_max(int index, int number) {
		if(index == N) {
			return;
		}
		
		int down_num = number;
		int up_num = 0;
		for(int i = 0; i < 6; i++) {
			if(dice[index][i] == down_num) {			// 현재 숫자가 밑면일 경우
				up_num = dice[index][hashMap.get(i)];	// 윗면을 찾아서 up_num에 저장
				break;
			} 
		}
		
		for(int i = 6; i > 0; i--) {					// 나머지 4면 중 최댓값을 찾아서 count에 추가		
			if(i != down_num && i != up_num) {
//				System.out.println("count : " + count + " + " + i);
				count += i;
				break;
			}
		}
		find_max(index + 1, up_num);
	}
}
