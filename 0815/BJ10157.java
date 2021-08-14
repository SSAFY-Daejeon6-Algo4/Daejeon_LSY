import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10157 {
	static int answer;
	static int N, M, K;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] seat;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(br.readLine());
		seat = new int[N][M];
		findSeat();
	}
	private static void findSeat() {
		if(K > N * M) {
			answer = 0;
			System.out.println(answer);
			return;
		}
		
		int cnt = 1;
		int row = 0;
		int col = 0;
		int direction = 0;
		
		while(cnt != K + 1) {
			if(row >= 0 && row < N && col >= 0 && col < M) {		// 범위 계산
				if(seat[row][col] != 0) {							// 자리에 누군가 앉아있으면
					row -= dx[direction];							// 칸 이동을 취소하고 방향을 틀어서 이동
					col -= dy[direction];
					direction = (direction + 1) % 4;
					row += dx[direction];
					col += dy[direction];
				} else {											// 자리에 아무도 없다면 사람을 앉히고 다음 칸으로 이동
					seat[row][col] = cnt++;
					if(cnt == K + 1) {
						System.out.println((row + 1) + " " + (col + 1));
					}
					row += dx[direction];
					col += dy[direction];
				}
			} else {												// 범위를 초과해버리면 이동을 취소하고 방향을 틀어서 이동
				row -= dx[direction];
				col -= dy[direction];
				direction = (direction + 1) % 4;
				row += dx[direction];
				col += dy[direction];
			}
		}
	}
}
