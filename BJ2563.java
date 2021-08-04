import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 2563
public class BJ2563 {
	static int answer;
	static boolean[][] area;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int paper = Integer.parseInt(br.readLine());
		area = new boolean[100][100];
		answer = 0;
		
		for(int t = 0; t < paper; t++) {
			String input = br.readLine();
			int row = Integer.parseInt(input.split(" ")[0]);
			int col = Integer.parseInt(input.split(" ")[1]);
			
			cal_area(row, col);
		}
		System.out.println(answer);
	}	
	
	private static void cal_area(int row, int col) {
		for(int i = row; i < row + 10; i++) {
			for(int j = col; j < col + 10; j++) {
				if(!area[i][j]) {
					area[i][j] = true;
					answer++;
				}
			}
		}
	}
}
