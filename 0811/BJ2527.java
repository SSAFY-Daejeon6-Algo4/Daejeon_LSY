import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2527 {
	static int[] rectangle1;
	static int[] rectangle2;
	static char answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int t = 0; t < 4; t++) {
			answer = 'd';
			st = new StringTokenizer(br.readLine());
			rectangle1 = new int[4];
			rectangle2 = new int[4];
			
			for (int i = 0; i < 8; i++) {
				if(i < 4) {
					rectangle1[i] = Integer.parseInt(st.nextToken());					
				} else {
					rectangle2[i - 4] = Integer.parseInt(st.nextToken());					
				}
			}
			
			if(rectangle1[0] > rectangle2[2] || rectangle2[0] > rectangle1[2]) {	// x좌표 엇갈림
				answer = 'd';
			} else if(rectangle1[0] == rectangle2[2] || rectangle2[0] == rectangle1[2]) {
				if(rectangle1[1] > rectangle2[3] || rectangle2[1] > rectangle1[3]) {	// y좌표 엇갈림
					answer = 'd';
				} else if(rectangle1[1] == rectangle2[3] || rectangle1[3] == rectangle2[1]) {
					answer = 'c';
				} else {
					answer = 'b';
				}
			} else {
				if(rectangle1[1] > rectangle2[3] || rectangle2[1] > rectangle1[3]) {	// y좌표 엇갈림
					answer = 'd';
				} else if(rectangle1[1] == rectangle2[3] || rectangle1[3] == rectangle2[1]) {
					answer = 'b';
				} else {
					answer = 'a';
				}
			}
			
			sb.append(answer + "\n");
		}
		System.out.println(sb.toString());
	}
}


/*
*	문제 선택 이유 : IM 필수 문제로 적혀있고, 스터디에서 언젠간 풀 문제라서 풀었습니다.
*	예상한 풀이 시간 / 실제 걸린 시간 : 30분 / 1시간
*	오래 걸린 이유 : 좌표를 계산하는 if/else문을 깔끔하게 리팩토링 하느라 시간이 추가적으로 걸렸습니다.
*	해결한 keyPoint : x좌표와 y좌표가 놓일 수 있는 모든 경우의 수를 if/else로 구현했습니다.(데이터를 입력받아서 하면 50000 X 50000이라 시간초과가 날 수 있어서) 
*/