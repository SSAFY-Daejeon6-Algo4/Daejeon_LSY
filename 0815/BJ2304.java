import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ2304 {
	static int[][] rod;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		rod = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			rod[i][0] = Integer.parseInt(st.nextToken());
			rod[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(rod, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		int max = 0;
		int index = 0;
		for (int i = 0; i < N; i++) {
			if (rod[i][1] >= max) {
				max = rod[i][1];
				index = i;
			}

		}
		
		boolean startOrEnd = true;
		int height = 0, width = 0;

		for (int i = 0; i <= index; i++) {	// 정방향 계산
			if (i == 0) {					// 시작되면 초깃값 저장
				width = rod[i][0];
				height = rod[i][1];
				if(index == i) {
					answer += rod[i][1];
					startOrEnd = false;
					break;
				}
			} else {						
				if (rod[i][1] > height) {	// 나보다 큰 값을 만났을 때
					answer += (rod[i][0] - width) * height;		// 직사각형 넓이만큼 더해주고
					width = rod[i][0];							// 새로운 width, height 설정
					height = rod[i][1];	
				} else {					// 나보다 작은 값인 경우
					if(index == i) {
						answer += (rod[i][0] - width) * height;		// 직사각형 넓이만큼 더해주고
						width = rod[i][0];							// 새로운 width, height 설정
						height = rod[i][1];	
					}
				}
			}
		}

		for (int i = N - 1; i >= index; i--) {
			if (i == N - 1) {
				width = rod[i][0];
				height = rod[i][1];
				if(index == i && startOrEnd) {
					answer += rod[i][1];
					startOrEnd = false;
					break;
				}
			} else {
				if (rod[i][1] > height) {
					answer += (width - rod[i][0]) * height;
					width = rod[i][0];
					height = rod[i][1];
				} else {
					if(index == i) {
						answer += (width - rod[i][0]) * height;		
						width = rod[i][0];							
						height = rod[i][1];	
					}
				}
			}
		}

		if(startOrEnd) {	// 최댓값을 기준으로 좌우를 살폈기 때문에 최댓값이 더해지지 않았으면 그 값을 더해준다.
			answer += max;
		}
		
		System.out.println(answer);
	}
}
