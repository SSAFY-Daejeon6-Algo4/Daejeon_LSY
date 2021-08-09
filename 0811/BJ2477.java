import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2477 {
	static int max_row = Integer.MIN_VALUE, max_col = Integer.MIN_VALUE;
	static int r_index = 0, answer = 0; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<int[]>();
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {direction, value});
			if(direction <= 2) {
				if(value > max_row) {
					max_row = value;
					r_index = i;
				}
			} else {
				if(value > max_col) {
					max_col = value;
				}
			}
		}
		
		if (list.get(r_index)[0] == 2) { // ㄱ과 90도
			if(list.get((r_index + 1) % 6)[1] == max_col) {	// 90도
				answer = ((max_row * max_col) - (list.get((r_index + 3) % 6)[1] * list.get((r_index + 4) % 6)[1])) * N;
			} else {										// ㄱ 모양
				answer = ((max_row * max_col) - (list.get((r_index + 2) % 6)[1] * list.get((r_index + 3) % 6)[1])) * N;
			}
		} else {	// 180도와 270도
			if(list.get((r_index + 1) % 6)[1] == max_col) {	// 270도
				answer = ((max_row * max_col) - (list.get((r_index + 3) % 6)[1] * list.get((r_index + 4) % 6)[1])) * N;
			} else {										// 180도
				answer = ((max_row * max_col) - (list.get((r_index + 2) % 6)[1] * list.get((r_index + 3) % 6)[1])) * N;
			}
		}
		
		System.out.println(answer);
	}
}
