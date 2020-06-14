package problems;
import java.util.ArrayList;
import java.util.Arrays;

import dataStructures.LineSegment;
import dataStructures.Point;

public class FastCollinearPoints {

	private int linesCount = 0;
	private final ArrayList<LineSegment> lineSegments = new ArrayList<LineSegment>();
	private final ArrayList<Point> existingpointList = new ArrayList<Point>();
	private final ArrayList<Double> slopeList = new ArrayList<Double>();

	public FastCollinearPoints(Point[] points) {
		if (points==null && nullCheck(points)) {
			throw new IllegalArgumentException("Null Point");
		}
		Point[] tempArray = points;
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
				throw new IllegalArgumentException("Duplicated Point or Null Point");
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

	private boolean isLineAdded(Point startPoint, Point endPoint, double slope) {
		for (int i=0; i<existingpointList.size(); i++) {
			if (existingpointList.get(i) == endPoint) {
				//////System.out.println("1");
				return true;
			}
			if (existingpointList.get(i) == startPoint && slopeList.get(i) != slope) {
				////System.out.println("2");
				return false;
			}
			if (slope == existingpointList.get(i).slopeTo(endPoint)){
				////System.out.println("3");
				return true;
			}
		}

		return false;
	}

	private void findLineSegments(Point[] points) {
		double baseSlope;
		int colPointCount;
		/*
		 * //Arrays.sort(tempArray);
		 * ////System.out.println("------------****--------------"); for (int j = 0; j <
		 * tempArray.length; j++) { ////System.out.println(tempArray[j].toString()); }
		 * ////System.out.println("--------------------------");
		 */

		for (int i = 0; i < points.length; i++) {
			Point[] tempArray = Arrays.copyOf(points, points.length);
			Arrays.sort(tempArray, tempArray[i].slopeOrder());
			
			//System.out.println("------------****--------------");
			for (int j = 0; j < tempArray.length; j++) {
				//System.out.println(tempArray[j].toString());
			}
			//System.out.println("--------------------------");

			baseSlope = tempArray[0].slopeTo(tempArray[1]);
			colPointCount = 2;

			for (int j = 2; j < tempArray.length; j++) {
				if (tempArray[0].slopeTo(tempArray[j]) == baseSlope) {
					colPointCount++;
					//System.out.println("Cand " + tempArray[0] + "" + tempArray[j] + "" + baseSlope + " " + colPointCount);

					if (j == tempArray.length - 1 && colPointCount > 3
							&& !isLineAdded(tempArray[0], tempArray[j], baseSlope)) {
						linesCount++;
						lineSegments.add(new LineSegment(tempArray[0], tempArray[j]));
						existingpointList.add(tempArray[0]);
						slopeList.add(baseSlope);

						//System.out.println("End " + tempArray[0] + "" + tempArray[j] + "" + baseSlope);

					}
				}
				if (tempArray[0].slopeTo(tempArray[j]) != baseSlope) {
					if (colPointCount > 3 && !isLineAdded(tempArray[0], tempArray[j - 1], baseSlope)) {
						linesCount++;
						lineSegments.add(new LineSegment(tempArray[0], tempArray[j - 1]));
						existingpointList.add(tempArray[0]);
						slopeList.add(baseSlope);
						//System.out.println("Inter " + tempArray[0] + "" + tempArray[j - 1] + "" + baseSlope);
					}
					baseSlope = tempArray[0].slopeTo(tempArray[j]);
					colPointCount = 2;
					//System.out.println("Cand2 " + tempArray[0] + "" + tempArray[j] + "" + baseSlope + " " + colPointCount);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		  Point a1 = new Point(10000, 0); Point a2 = new Point(0, 10000); Point a3 =
		  new Point(3000, 7000); Point a4 = new Point(7000, 3000); Point a5 = new
		  Point(20000, 21000); Point a6 = new Point(3000, 4000); Point a7 = new
		  Point(14000, 15000); Point a8 = new Point(6000, 7000);
		 

		/*
		 * Point a1 = new Point(10000, 0); Point a2 = new Point(8000, 2000); Point a3 =
		 * new Point(2000, 8000); Point a4 = new Point(0, 10000); Point a5 = new
		 * Point(20000, 0); Point a6 = new Point(18000, 2000); Point a7 = new
		 * Point(2000, 18000); Point a8 = new Point(10000, 20000); Point a9 = new
		 * Point(30000, 0); Point a10 = new Point(0, 30000); Point a11 = new
		 * Point(20000, 10000); Point a12 = new Point(13000, 0); Point a13 = new
		 * Point(11000, 3000); Point a14 = new Point(5000, 12000); Point a15 = new
		 * Point(9000, 6000);
		 */

		//Point[] points = { a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15 };
		  Point[] points = { a1, a2, a3, a4, a5, a6, a7, a8};

		FastCollinearPoints fcp = new FastCollinearPoints(points);

		System.out.println(fcp.linesCount);
		for (LineSegment segment : fcp.segments()) {
			System.out.println(segment.toString());
		}
	}
}