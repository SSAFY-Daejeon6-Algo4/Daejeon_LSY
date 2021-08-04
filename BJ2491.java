import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2491 {
	static int[][] arr;
	static int answer = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int str_len = Integer.parseInt(br.readLine());
		arr = new int[str_len][3];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < str_len; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
		}

		arr[0][1] = 1;
		arr[0][2] = 1;

		// [값][커지는 방향 최댓값][작아지는 방향 최댓값][내 값과 같았던 개수]
		for (int j = 1; j < str_len; j++) {
			if (arr[j][0] > arr[j - 1][0]) { // 내가 내 뒤보다 클 때, 커지는 진행 방향 설정
				arr[j][1] = arr[j - 1][1] + 1;
				arr[j][2] = 1;
			} else if (arr[j][0] == arr[j - 1][0]) { // 내가 내 뒤랑 같을 때
				arr[j][1] = arr[j - 1][1] + 1;
				arr[j][2] = arr[j - 1][2] + 1;
			} else { // 내가 내 뒤보다 작을 때, 작아지는 진행 방향 설정
				arr[j][1] = 1;
				arr[j][2] = arr[j - 1][2] + 1;
			}
			answer = Math.max(answer, Math.max(arr[j][1], arr[j][2]));	
		}

		System.out.println(answer);
	}
}
