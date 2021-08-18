import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 2798, 블랙잭 B2
public class BJ2798 {
	static int N, M, answer;
	static int[] cards;
	static int[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		answer = 0;
		
		cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		selected = new int[3];
		
		comb(0, 0);
		System.out.println(answer);
	}
	
	private static void comb(int count, int start) {
		if(count == 3) {
			int sum = 0;
			
			for(int i = 0; i < 3; i++) {
				sum += selected[i];
			}
			
			if(sum <= M) {
				answer = Math.max(answer, sum);
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			selected[count] = cards[i];
			comb(count + 1, i + 1);
		}
	}
}
