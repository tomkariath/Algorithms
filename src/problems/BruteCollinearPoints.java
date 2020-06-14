package problems;
import java.util.ArrayList;
import java.util.Arrays;

import dataStructures.LineSegment;
import dataStructures.Point;

public class BruteCollinearPoints {

	private int linesCount = 0;
	private final ArrayList<LineSegment> lineSegments = new ArrayList<LineSegment>();

	public BruteCollinearPoints(Point[] points) {
		if (points==null && nullCheck(points)) {
			throw new IllegalArgumentException("Null Point");
		}
		Point[] tempArray = Arrays.copyOf(points, points.length);
		Arrays.sort(tempArray);
		checkForDuplicateEntry(tempArray);	
		findLineSegments(tempArray);
	}

	private boolean nullCheck(Point[] points) {
		for (Point point : points) {
			if (point==null) {
				return true;
			}
		}
		return false;
	}

	private void checkForDuplicateEntry(Point[] points) {
		Point lastPoint = null; 
		for (Point point : points) {
			if (point.equals(lastPoint)) {
				throw new IllegalArgumentException("Duplicated Point");
			}
			lastPoint = point;
		}
	}

	public int numberOfSegments() {
		return linesCount;
	}

	public LineSegment[] segments() {
		LineSegment[] segments = new LineSegment[lineSegments.size()];
		
		for (int i = 0; i < segments.length; i++) {
			segments[i] = lineSegments.get(i);
		}
		
		return segments;
	}

	private void findLineSegments(Point[] points) {
		int colPointCount;
		double baseSlope;

		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				baseSlope = points[i].slopeTo(points[j]);
				colPointCount = 2;

				for (int k = j + 1; k < points.length; k++) {
					if (points[i].slopeTo(points[k]) == baseSlope) {
						if (++colPointCount > 3) {
							linesCount++;
							lineSegments.add(new LineSegment(points[i], points[k]));
							//System.out.println(points[i] + "" + points[k] + "" + baseSlope);
							break;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Point a1 = new Point(10000, 0);
		Point a2 = new Point(0, 10000);
		Point a3 = new Point(3000, 7000);
		Point a4 = new Point(7000, 3000);
		Point a5 = new Point(20000, 21000);
		Point a6 = null;
		Point a7 = new Point(14000, 15000);
		Point a8 = new Point(6000, 7000);

		Point[] points = { a1, a2, a3, a4, a5, a6, a7, a8 };

		BruteCollinearPoints bcp = new BruteCollinearPoints(points);

		System.out.println(bcp.linesCount);
		
		for (LineSegment segment : bcp.segments()) {
			System.out.println(segment.toString());
		}
	}
}