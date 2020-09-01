package dataStructures;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

public class KdTree {

	private static final boolean VERTICAL = Boolean.TRUE;
	private static final boolean HORIZONTAL = Boolean.FALSE;
	private static final boolean RIGHT = Boolean.TRUE;
	// private static final boolean LEFT = Boolean.FALSE;
	private static final double CANVAS_MIN = 0;
	private static final double CANVAS_MAX = 1;

	private class PointNode {
		Point2D point;
		RectHV rect;
		boolean orientation;

		PointNode rightChild;
		PointNode leftChild;

		public PointNode(Point2D point, RectHV line, boolean orientation) {
			super();
			this.point = point;
			this.rect = line;
			this.orientation = orientation;

			rightChild = null;
			leftChild = null;
		}

		@Override
		public String toString() {
			return point.toString() + orientation + " " + rect;
		}
	}

	private PointNode root;
	private int size = 0;

	public KdTree() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return size;
	}

	public void insert(Point2D p) {
		if (p == null) {
			throw new IllegalArgumentException("Null pointer exception :P");
		}

		if (this.contains(p)) {
			return;
		}

		root = insert(null, root, p, VERTICAL);
		size++;
	}

	private PointNode insert(PointNode parent, PointNode node, Point2D p, boolean orientation) {
		boolean cmp = false;
		if (node == null) {
			return new PointNode(p, getRect(parent, p, orientation), orientation);
		}

		if (node.orientation == VERTICAL) {
			cmp = compare(p.x(), node.point.x());
		} else {
			cmp = compare(p.y(), node.point.y());
		}

		if (cmp) {
			node.rightChild = insert(node, node.rightChild, p, !orientation);
		} else {
			node.leftChild = insert(node, node.leftChild, p, !orientation);
		}
		return node;
	}

	private boolean compare(double coord1, double coord2) {
		if (coord1 > coord2) {
			return true;
		} else {
			return false;
		}
	}

	private RectHV getRect(PointNode parent, Point2D p, boolean orientation) {
		RectHV rect;
		boolean cmp;
		if (parent == null) {
			rect = new RectHV(CANVAS_MIN, CANVAS_MIN, CANVAS_MAX, CANVAS_MAX);
		} else if (orientation == HORIZONTAL) {
			cmp = (p.x() > parent.point.x());
			if (cmp == RIGHT) {
				rect = new RectHV(parent.point.x(), parent.rect.ymin(), parent.rect.xmax(), parent.rect.ymax());
			} else {
				rect = new RectHV(parent.rect.xmin(), parent.rect.ymin(), parent.point.x(), parent.rect.ymax());
			}
		} else {
			cmp = (p.y() > parent.point.y());
			if (cmp == RIGHT) {
				rect = new RectHV(parent.rect.xmin(), parent.point.y(), parent.rect.xmax(), parent.rect.ymax());
			} else {
				rect = new RectHV(parent.rect.xmin(), parent.rect.ymin(), parent.rect.xmax(), parent.point.y());
			}	
		}

		return rect;
	}

	public boolean contains(Point2D p) {
		if (p == null) {
			throw new IllegalArgumentException("Null pointer exception :P");
		}
		return contains(p, root);
	}

	private boolean contains(Point2D p, PointNode node) {
		if (node == null) {
			return false;
		}

		if (p.compareTo(node.point) == 0) {
			return true;
		}
		boolean cmp = false;
		if (node.orientation == VERTICAL) {
			cmp = compare(p.x(), node.point.x());
		} else {
			cmp = compare(p.y(), node.point.y());
		}

		if (cmp) {
			return contains(p, node.rightChild);
		} else {
			return contains(p, node.leftChild);
		}
	}

	public void draw() {
		draw(root);
	}

	private void draw(PointNode node) {
		if (node == null) {
			return;
		}

		if (node.orientation == VERTICAL) {
			StdDraw.setPenColor(StdDraw.RED);
		} else {
			StdDraw.setPenColor(StdDraw.BLUE);
		}
		StdDraw.line(node.rect.xmin(), node.rect.ymin(), node.rect.xmax(), node.rect.ymax());

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.point(node.point.x(), node.point.y());

		draw(node.leftChild);
		draw(node.rightChild);
	}

	public Iterable<Point2D> range(RectHV rect) {
		if (rect == null) {
			throw new IllegalArgumentException("Null pointer exception :P");
		}

		if (root == null) {
			return null;
		}

		Queue<PointNode> possibleNodes = new Queue<PointNode>();
		List<Point2D> points = new ArrayList<Point2D>();

		possibleNodes.enqueue(root);

		while (!possibleNodes.isEmpty()) {
			PointNode node = possibleNodes.dequeue();
			if (node == null) {
				continue;
			}

			if (node.rect.intersects(rect)) {
				if (rect.contains(node.point)) {
					points.add(node.point);
				}
				possibleNodes.enqueue(node.leftChild);
				possibleNodes.enqueue(node.rightChild);
			} else if (node.orientation == VERTICAL) {
				if (rect.xmax() < node.rect.xmax()) {
					possibleNodes.enqueue(node.leftChild);
				} else {
					possibleNodes.enqueue(node.rightChild);
				}
			} else {
				if (rect.ymax() < node.rect.ymax()) {
					possibleNodes.enqueue(node.leftChild);
				} else {
					possibleNodes.enqueue(node.rightChild);
				}
			}
		}
		return points;
	}

	public Point2D nearest(Point2D p) {
		if (p == null) {
			throw new IllegalArgumentException("Null pointer exception :P");
		}

		if (root == null) {
			return null;
		}

		double nearestDistance = 1;
		Point2D nearestPoint = null;
		Queue<PointNode> possibleNodes = new Queue<PointNode>();

		possibleNodes.enqueue(root);

		while (!possibleNodes.isEmpty()) {
			PointNode node = possibleNodes.dequeue();
			if (node == null) {
				continue;
			}

			double distance = node.point.distanceSquaredTo(p);

			if (node.point.distanceSquaredTo(p) < nearestDistance) {
				nearestPoint = new Point2D(node.point.x(), node.point.y());
				nearestDistance = distance;
			}
			
			boolean cmp;
			if (node.orientation == VERTICAL) {
				cmp = p.x() < node.point.x();
			} else {
				cmp = p.y() < node.point.y();
			}
			
			if (cmp) {
				possibleNodes.enqueue(node.leftChild);
				possibleNodes.enqueue(node.rightChild);
			} else {
				possibleNodes.enqueue(node.rightChild);
				possibleNodes.enqueue(node.leftChild);
			}
		}

		return nearestPoint;
	}

	public static void main(String[] args) {
		KdTree kdTree = new KdTree();

		Point2D p1 = new Point2D(0.0,0.5);
		Point2D p2 = new Point2D(0.25,0.25);
		Point2D p3 = new Point2D(0.75,1.0);
		Point2D p4 = new Point2D(1.0,0.75);// answer
		Point2D p5 = new Point2D(0.5,1.0);
		Point2D p6 = new Point2D(0.0,0.25);
		Point2D p7 = new Point2D(0.75,0.75);
		Point2D p8 = new Point2D(0.25,0.5);
		Point2D p9 = new Point2D(0.0,1.0);

		kdTree.insert(p1);
		kdTree.insert(p2);
		kdTree.insert(p3);
		kdTree.insert(p4);
		kdTree.insert(p5);
		kdTree.insert(p6);
		kdTree.insert(p7);
		kdTree.insert(p8);
		kdTree.insert(p9);

		Point2D p = new Point2D(1.0, 0.0);

		System.out.println(kdTree.nearest(p));
	}
}
