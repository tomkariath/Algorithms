package problems;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[][] test = {{1,2},{3,4},{5,6}};
		int[][] tempBoard = new int[3][2];
		tempBoard = Arrays.copyOf(test, 3);
		System.out.println(Arrays.deepToString(tempBoard));
		
		double a = 0.0;
		double b = -0.0;
		Double x = Double.valueOf(a);
		Double y = Double.valueOf(b);
		
		double c = Double.NaN;
		double d = Double.NaN;
		Double p = Double.valueOf(c);
		Double q = Double.valueOf(d);
		
		if (a==b) {
			System.out.println("double: 0.0 == -0.0");
		}
		if (!x.equals(y)) {
			System.out.println("Double: 0.0 != -0.0");
		}
		
		if (c!=d) {
			System.out.println("double: NaN != NaN");
		}
		if (p.equals(q)) {
			System.out.println("Double: NaN == NaN");
		}
		
		String test1="..H"; 
		if (test1.contains("HH")||!(test1.contains("H"))){
			System.out.println("fail");
		}
		System.out.println(test1.replaceAll("\\.", "B"));
		
		int ab = 3;
		int xy = 2;
		
		System.out.println(Math.pow(ab, xy));
	}
}
