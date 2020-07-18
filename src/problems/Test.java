package problems;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[][] test = {{1,2},{3,4},{5,6}};
		int[][] tempBoard = new int[3][2];
		tempBoard = Arrays.copyOf(test, 3);
		System.out.println(Arrays.deepToString(tempBoard));
	}
}
