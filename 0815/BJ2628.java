import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BJ2628 {
	static List<Integer> rows = new LinkedList<>(); 
	static List<Integer> cols = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		// list 2개를 이용하여 잘린 파트를 갖고 있기 {0, 2, 3, 8], [0, 4, 10]
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		rows.add(0);
		cols.add(0);
		
		int M = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);
		
		rows.add(N);
		cols.add(M);
		
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			String[] str1 = br.readLine().split(" ");
			int dir = Integer.parseInt(str1[0]);
			int val = Integer.parseInt(str1[1]);
			
			if(dir == 0) {
				rows.add(val);
			} else {
				cols.add(val);
			}
		}
		
		Collections.sort(rows);
		Collections.sort(cols);
		
		System.out.println(max_area());
	}
	private static int max_area() {
		int answer = 0;
		for(int i = 1; i < rows.size(); i++) {			
			for(int j = 1; j < cols.size(); j++) {
				int value = (cols.get(j) - cols.get(j - 1)) * (rows.get(i) - rows.get(i - 1));
				answer = Math.max(value, answer);
			}
		}
		
		return answer;
	}
}