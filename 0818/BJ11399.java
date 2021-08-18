import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ11399 { 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] people = new int[N][2];
		int sum = 0;
		
		String[] str = br.readLine().split(" ");

		for (int i = 0; i < people.length; i++) {
			people[i][0] = Integer.parseInt(str[i]);
		}

		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		
		for (int i = 0; i < people.length; i++) {
			if(i == 0) {
				people[i][1] = people[i][0];
				sum += people[i][1];
			} else {
				people[i][1] = people[i - 1][1] + people[i][0];
				sum += people[i][1];
			}
		}
		
		System.out.println(sum);
	}
}
