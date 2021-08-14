import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10158 {
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());
		
		int r;
		int c;
		
		if(time - (N - row) > 0) {
			int firstToEnd = time - (N - row);
			int repeat = firstToEnd / N;

			if(repeat % 2 == 0) {
				r = N - (firstToEnd % N);			
			} else {
				r = firstToEnd % N;
			}
		} else {
			r = row + time;
		}
		
		if(time - (M - col) > 0) {
			int firstToEnd = time - (M - col);
			int repeat = firstToEnd / M;
			
			if(repeat % 2 == 0) {
				c = M - (firstToEnd % M);
			} else {
				c = firstToEnd % M;
			}
		} else {
			c = col + time;
		}
		
		sb.append(r).append(" ").append(c);		// 문자열 연산에서 시간초과 발생..
		System.out.println(sb);
	}
}