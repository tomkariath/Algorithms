package problems;

import java.util.Arrays;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Stack;

public class ConvexHull {
	public static void generateHull (Point2D[] inputArray) {
		Arrays.sort(inputArray, Point2D.Y_ORDER);
		Arrays.sort(inputArray, inputArray[0].polarOrder());
		
		
		Stack<Point2D> hull = new Stack<Point2D>();
		hull.push(inputArray[0]);
		hull.push(inputArray[1]);
		
		for (int i = 2; i < inputArray.length; i++) {
			Point2D stackTop = hull.pop();
			
			while (Point2D.ccw(hull.peek(), stackTop ,inputArray[i])<=0) { //eliminating counter clockwise points and colinear ones
				stackTop = hull.pop();
			}
			
			hull.push(stackTop);
			hull.push(inputArray[i]);
		}
		
		for (Point2D point : hull) {
			System.out.println(point.x()+" "+point.y());
		}
	}
	
	public static void main(String[] args) {
		Point2D p1 = new Point2D(0, 1);
		Point2D p2 = new Point2D(1, 1);
		Point2D p3 = new Point2D(1, 0);
		Point2D p4 = new Point2D(-1, -1);
		//Point2D p5 = new Point2D(4, 5);
		Point2D p5 = new Point2D(0, 0);
		
		Point2D[] inputArray = {p1,p2,p3,p4,p5};
		
		ConvexHull.generateHull(inputArray);
		
	}
}
