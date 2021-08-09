import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ2635 {
	static int answer;
	static List<Integer> arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		arr = new ArrayList<>();
		answer = 0;
		
		int N = Integer.parseInt(br.readLine());
		
		findVal(N);
		System.out.println(answer);
		for(int n : arr) {
			System.out.print(n + " ");
		}
	}
	private static void findVal(int N) {
		List<Integer> list;
		for(int i = N / 2; i <= N; i++) {		// N까지로 설정을 안하면 1일 때 오류가 발생함(1일때 0밖에 체크를 안해서 답이 틀려짐)
			list = new ArrayList<>();
			list.add(N);
			list.add(i);
			int value = N - i;
			while(list.get(list.size() - 1) - value >= 0) {
				list.add(value);
				value = list.get(list.size() - 2) - list.get(list.size() - 1);
			}
			list.add(value);
			
			if(list.size() > answer) {
				arr = list;
				answer = arr.size();
			}
		}
	}
}
