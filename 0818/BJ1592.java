import java.util.Scanner;

public class BJ1592 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] ball = new int[N];
		int has_ball = 0;
		ball[has_ball]++;
		int cnt = 0;
		
		while(ball[has_ball] < M) {
			System.out.println(has_ball);
			if(ball[has_ball] % 2 == 1) {
				has_ball = (has_ball + L) % N;				
			} else {	
				if(has_ball >= L) {
					has_ball -= L;
				} else {
					has_ball = N - Math.abs(has_ball - L);					
				}
			}
			ball[has_ball]++;
			cnt ++;
		}
		System.out.println(cnt);
	}

}
