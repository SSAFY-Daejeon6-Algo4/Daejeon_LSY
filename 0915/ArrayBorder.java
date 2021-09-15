package Level2;

import java.util.Arrays;

public class ArrayBorder {
	static int[] answer;
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 6, new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}})));
		System.out.println(Arrays.toString(solution(6, 3, new int[][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}})));
		System.out.println(Arrays.toString(solution(100, 97, new int[][] {{1,1,100,97}})));
	}
	
	public static int[] solution(int rows, int columns, int[][] queries) {
		answer = new int[queries.length];
		int[][] map = new int[rows][columns];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				map[i][j] = i * columns + j + 1;
			}
		}
		
		int index = 0;
		
		for(int i = 0; i < queries.length; i++) {
			answer[index++] = conversion(queries[i][0], queries[i][1], queries[i][2], queries[i][3], map);
		}
		
        return answer;
    }
	
	public static int conversion(int r1, int c1, int r2, int c2, int[][] map) {
		int[] dirX = {1, 0, -1, 0};
		int[] dirY = {0, 1, 0, -1};
		
		int direction = 0;
		int row = r1 - 1;
		int col = c1 - 1;
		int startVal = map[row][col];
		int count = 0;

		int min_val = startVal;
		
		while(count < (r2 - r1) * 2 + (c2 - c1) * 2) {
			int new_row = row + dirX[direction];
			int new_col = col + dirY[direction];
			
			if(new_row >= r1 - 1 && new_row < r2 && new_col >= c1 - 1 && new_col < c2) {
				if(count == (r2 - r1) * 2 + (c2 - c1) * 2 - 1) {
					map[row][col] = startVal;
					break;
				}
				map[row][col] = map[new_row][new_col];
				
				row = new_row;
				col = new_col;
				
				min_val = Math.min(min_val, map[row][col]);
				
				count++;
			} else {
				direction++;
			}
		}
		
		return min_val;
	}
}
