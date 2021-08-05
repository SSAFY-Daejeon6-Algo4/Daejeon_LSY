import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10163 {
	static int[][] area;
	static int[] count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		area = new int[1001][1001];
		
		int N = Integer.parseInt(br.readLine());
		count = new int[N + 1];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start_row = Integer.parseInt(st.nextToken());
			int start_col = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			check(i + 1, start_row, start_col, start_row + width, start_col + height);
		}
		for(int i = 1; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}
	private static void check(int index, int s_row, int s_col, int e_row, int e_col) {
		for (int i = s_row; i < e_row; i++) {
			for (int j = s_col; j < e_col; j++) {
				if(area[i][j] != 0) {
					count[area[i][j]]--;
				}
				area[i][j] = index;
				count[index]++;
			}
		}
	}
}
