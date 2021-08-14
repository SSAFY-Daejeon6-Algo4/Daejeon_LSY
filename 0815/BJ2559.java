import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2559 수열, S3
public class BJ2559 {
	static int[] fever;
	static int[] sum;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int range = Integer.parseInt(st.nextToken());
		
		answer = Integer.MIN_VALUE;
		fever = new int[N];
		sum = new int[N - (range - 1)];
		
		int cnt = 1;
		int index = 0;
		int sumF = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			fever[i] = Integer.parseInt(st.nextToken());
			if(i == 0) {
				index = 0;
				sumF += fever[i];
				if(cnt == range) {
					sum[index] = sumF;
					sumF -= fever[index];
					index += 1;
					cnt -= 1;
				}
			} else {
				cnt += 1;
				sumF += fever[i];
				
				if(cnt == range) {
					sum[index] = sumF;
					sumF -= fever[index];
					index += 1;
					cnt -= 1;
				}
			}
		}
		
		for(int i = 0; i < sum.length; i++) {
			answer = Math.max(answer, sum[i]);
		}
		
		System.out.println(answer);
	}
}
