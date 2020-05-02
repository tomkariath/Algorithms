package problems;

import edu.princeton.cs.algs4.Point2D;

public class IntersectingPointSet {

	public static int getCommonPoints(Point2D[] pointsArray1, Point2D[] pointsArray2){
		int count=0;
		
		for (int i = 0; i < pointsArray1.length; i++) {
			for (int j = 0; j < pointsArray2.length; j++) {
				if (pointsArray1[i].equals(pointsArray2[j])) {
					count ++;
					break;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Point2D p1 = new Point2D(0, 1);
		Point2D p2 = new Point2D(1, 1);
		Point2D p3 = new Point2D(1, 0);
		Point2D p4 = new Point2D(-1, -1);
		Point2D p5 = new Point2D(4, 5);
		Point2D p6 = new Point2D(0, 0);
		
		Point2D[] inputArray1 = {p1,p2,p3,p4,p5};
		Point2D[] inputArray2 = {p5,p4,p3,p2,p6,p1};
		
		System.out.println(getCommonPoints(inputArray2, inputArray1));
	}
	
}
