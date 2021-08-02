import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ2605 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		String row = br.readLine();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(row.split(" ")[i]), i + 1);
		}
		Collections.reverse(list);
		int[] arr = list.stream().mapToInt(i -> i).toArray();
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
