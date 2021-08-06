import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13300 {
	static int[][] students = new int[6][2];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int student = Integer.parseInt(st.nextToken());
		int room_max = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			students[grade - 1][gender]++;
		}
		
		int answer = 0;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 2; j++) {
				answer += Math.ceil(students[i][j] / (double)room_max);
			}
		}
		System.out.println(answer);
	}
}
