import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ2578 {

	static int[][] user = new int[5][5];
	static boolean[][] visit = new boolean[5][5];
	static int[] mc = new int[25];
	static HashMap<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				user[i][j] = Integer.parseInt(st.nextToken());
				map.put(user[i][j], i * 5 + j);
			}
		}
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				mc[i * 5 + j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 25; i++) {			
			int row = map.get(mc[i]) / 5;
			int col = map.get(mc[i]) % 5;
			visit[row][col] = true;
			
			if(isBingo() >= 3) {
				System.out.println(i + 1);
				break;
			}
		}
	}
	
	public static int isBingo() {
		int bingo = 0; 
		int diagonal1 = 0;
		int diagonal2 = 0;
		for(int i = 0; i < 5; i++) {
			int row_sum = 0;
			int col_sum = 0;
			for(int j = 0; j < 5; j++) {
				row_sum += (visit[i][j]) ? 1 : 0;
				col_sum += (visit[j][i]) ? 1 : 0;
				if(i == j && visit[i][j]) {
					diagonal1 ++;
					if(diagonal1 == 5) {
						bingo ++;
					}
				}
				if(i + j == 4 && visit[i][j]) {
					diagonal2 ++;
					if(diagonal2 == 5) {
						bingo ++;
					}
				}
			}
			if(row_sum == 5) {
				bingo++;
			}
			if(col_sum == 5) {
				bingo++;
			}
		}
		return bingo;
	}

}
