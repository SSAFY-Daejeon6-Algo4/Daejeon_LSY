import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백준 2564
public class BJ2564 {
	static int[][] place;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputNM = br.readLine();
		int M = Integer.parseInt(inputNM.split(" ")[0]);
		int N = Integer.parseInt(inputNM.split(" ")[1]);

		int loc = 0;
		int val = 0;

		int market = Integer.parseInt(br.readLine());
		place = new int[market][2];
		
		for(int i = 0; i < place.length; i++) {
			String inputMarket = br.readLine();
			place[i][0] = Integer.parseInt(inputMarket.split(" ")[0]);
			place[i][1] = Integer.parseInt(inputMarket.split(" ")[1]);
		}
		String Security = br.readLine();
		loc = Integer.parseInt(Security.split(" ")[0]);
		val = Integer.parseInt(Security.split(" ")[1]);
		
		for(int i = 0; i < place.length; i++) {
			if(Math.abs(loc - place[i][0]) == 0) {	// 동일 라인에 있을때
				answer += (Math.abs(val - place[i][1]));
			} else if(Math.abs(loc - place[i][0]) == 1) {	// 반대 라인에 있을때
				if(loc < 3 && place[i][0] < 3) {			// 남북 or 북남
					answer += Math.min(val + place[i][1] + N, (M - val) + (M - place[i][1]) + N);					
				} else if(loc > 2 && place[i][0] > 2){		// 동서 or 서동
					answer += Math.min(val + place[i][1] + M, (N - val) + (N - place[i][1]) + M);
				} else {									// 남서 or 서남
					if(loc == 2) {	// 남서
						answer += val + (N - place[i][1]);
					} else {		// 서남
						answer += (N - val) + place[i][1];
					}
				}
			} else if(Math.abs(loc - place[i][0]) == 2) {	// 동남 or 남동 or 북서 or 서북
				if(loc % 2 == 0) {	
					if(loc == 2) {	// 남동
						answer += (M - val) + (N - place[i][1]);
					} else {		// 동남
						answer += (N - val) + (M - place[i][1]);
					}
				}
				else {				
					answer += val + place[i][1];
				}
			} else {										// 북동 or 동북
				if(loc == 2) {	// 북동
					answer += (M - val) + place[i][1];
				} else {		// 동북
					answer += val + (M - place[i][1]);
				}
			}
		}
		
		System.out.println(answer);
	}
}

