import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ14696 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			Integer[] A = new Integer[Integer.parseInt(st.nextToken())];
			for(int i = 0; i < A.length; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			Integer[] B = new Integer[Integer.parseInt(st.nextToken())];	// Collection의 reverseOrder를 사용하기 위해 래퍼클래스로 지정
			for(int i = 0; i < B.length; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A, Collections.reverseOrder());
			Arrays.sort(B, Collections.reverseOrder());
			
			for(int i = 0; i < Math.min(A.length, B.length); i++) {
				if(A[i] > B[i]) {
					sb.append("A\n");
					break;
				} else if(A[i] == B[i]) {
					if(i == Math.min(A.length, B.length) - 1) {
						if(A.length == B.length) {
							sb.append("D\n");
						} else {
							if(A.length > B.length) {
								sb.append("A\n");
							} else {
								sb.append("B\n");
							}
						}
					}
					continue;
				} else {
					sb.append("B\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
