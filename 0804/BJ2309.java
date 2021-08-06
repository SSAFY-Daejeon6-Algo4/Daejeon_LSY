import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BJ2309 {
	static ArrayList<Integer> dwarf = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i++) {
			dwarf.add(Integer.parseInt(br.readLine()));
		}
		
		xx:for(int i = 8; i >= 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if(i != j) {
					if(sum(dwarf, i, j) == 100) {
						dwarf.remove(i);
						dwarf.remove(j);						
						break xx;
					}
				}
			}
		}
		int[] arr = dwarf.stream().mapToInt(i -> i).toArray();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	public static int sum(ArrayList<Integer> arr, int x, int y) {
		int arr_sum = 0;
		for(int i = 0; i < arr.size(); i++) {
			if(i != x && i != y) {
				arr_sum += arr.get(i);
			}
		}
		return arr_sum;
	}
}
