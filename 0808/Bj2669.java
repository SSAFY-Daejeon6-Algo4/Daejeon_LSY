import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2669 {
	static boolean[][] visit = new boolean[100][100];
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start_row = Integer.parseInt(st.nextToken());
			int start_col = Integer.parseInt(st.nextToken());
			int end_row = Integer.parseInt(st.nextToken());
			int end_col = Integer.parseInt(st.nextToken());
			
			check(start_row, start_col, end_row, end_col);
		}
		System.out.println(answer);
	}
	private static void check(int s_row, int s_col, int e_row, int e_col) {
		for (int i = s_row; i < e_row; i++) {
			for (int j = s_col; j < e_col; j++) {
				if(!visit[i][j]) {
					answer++;
					visit[i][j] = true;
				}
			}
		}
	}
}
