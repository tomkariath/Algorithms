package problems;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

public class PointSET {

	final private SET<Point2D> pointSet;

	public PointSET() {
		pointSet = new SET<Point2D>();
	}

	public boolean isEmpty() {
		return pointSet == null || pointSet.isEmpty();
	}

	public int size() {
		if (pointSet == null) {
			return 0;
		}
		return pointSet.size();
	}

	public void insert(Point2D p) {
		if (p == null) {
			throw new IllegalArgumentException("Null pointer exception :P");
		}

		if (pointSet != null && !pointSet.contains(p)) {
			pointSet.add(p);
		}
	}

	public boolean contains(Point2D p) {
		if (p == null) {
			throw new IllegalArgumentException("Null pointer exception :P");
		}

		return pointSet != null && pointSet.contains(p);
	}

	public void draw() {
		for (Point2D point2d : pointSet) {
			point2d.draw();
		}
	}

	public Iterable<Point2D> range(RectHV rect) {
		if (rect == null) {
			throw new IllegalArgumentException("Null Rectangle");
		}

		List<Point2D> containedPoints = new ArrayList<Point2D>();

		for (Point2D point2d : pointSet) {
			if (rect.contains(point2d)) {
				containedPoints.add(point2d);
			}
		}

		return containedPoints;
	}

	public Point2D nearest(Point2D p) {
		if (p == null) {
			throw new IllegalArgumentException("Null pointer exception :P");
		}

		double smallestDistance = 1;
		Point2D smallestPoint = new Point2D(0, 0);
		double distance;

		if (pointSet == null || pointSet.isEmpty()) {
			smallestPoint = null;
		}

		for (Point2D point2d : pointSet) {
			distance = p.distanceSquaredTo(point2d);
			if (distance < smallestDistance) {
				smallestDistance = distance;
				smallestPoint = point2d;
			}
		}

		return smallestPoint;
	}

	public static void main(String[] args) {
	}

}
