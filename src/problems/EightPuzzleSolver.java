package problems;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import edu.princeton.cs.algs4.MinPQ;

public class EightPuzzleSolver {

	private class SearchNode {
		private EightPuzzleBoard board;
		private int moves;
		private SearchNode previousNode;
		private int manhattan;

		public EightPuzzleBoard getBoard() {
			return board;
		}

		public int getMoves() {
			return moves;
		}

		public SearchNode getPreviousNode() {
			return previousNode;
		}

		public int getManhattan() {
			return manhattan;
		}

		public SearchNode(EightPuzzleBoard board) {
			this.board = board;
			this.moves = 0;
			this.previousNode = null;
			this.manhattan = 0;
		}

		public SearchNode(EightPuzzleBoard board, SearchNode previousNode) {
			this.board = board;
			this.moves = previousNode.moves + 1;
			this.previousNode = previousNode;
			this.manhattan = board.manhattan();
		}
	}

	// add comparator

	private class ManhattanCompare implements Comparator<SearchNode> {

		@Override
		public int compare(SearchNode node1, SearchNode node2) {
			int priority1 = node1.getMoves() + node1.getManhattan();
			int priority2 = node2.getMoves() + node2.getManhattan();

			if (priority1 > priority2) {
				return 1;
			} else if (priority1 < priority2) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	private MinPQ<SearchNode> possibleBoards = new MinPQ<SearchNode>(new ManhattanCompare());
	private MinPQ<SearchNode> possibleBoardsTwin = new MinPQ<SearchNode>(new ManhattanCompare());
	private boolean goalReached = false, goalReachedTwin = false;
	private SearchNode finalNode;
	
	// find a solution to the initial board (using the A* algorithm)
	public EightPuzzleSolver(EightPuzzleBoard initial) {
		if (initial == null) {
			throw new IllegalArgumentException("Null Board");
		}

		SearchNode initialNode = new SearchNode(initial);
		SearchNode twinNode = new SearchNode(initial.twin());
		possibleBoards.insert(initialNode);
		possibleBoardsTwin.insert(twinNode);

		while (true) {
			finalNode = solverFn();
			if (goalReached || goalReachedTwin) {
				break;
			}
		}
	}

	private SearchNode solverFn() {
		// deque min
		SearchNode minNode = possibleBoards.delMin();
		SearchNode minNodeTwin = possibleBoardsTwin.delMin();

		goalReached = minNode.board.isGoal();
		goalReachedTwin = minNodeTwin.board.isGoal();

		if (goalReached || goalReachedTwin) {
			return minNode;
		}

		// insert neighboars
		for (EightPuzzleBoard neighbor : minNode.getBoard().neighbors()) {
			if (minNode.getPreviousNode() != null && neighbor.equals(minNode.getPreviousNode().getBoard())) {
				continue;
			}
			possibleBoards.insert(new SearchNode(neighbor, minNode));
		}

		for (EightPuzzleBoard neighbor : minNodeTwin.getBoard().neighbors()) {
			if (minNodeTwin.getPreviousNode() != null && neighbor.equals(minNodeTwin.getPreviousNode().getBoard())) {
				continue;
			}
			possibleBoardsTwin.insert(new SearchNode(neighbor, minNodeTwin));
		}
		// continue recursively until goal
		return null;
	}

	// is the initial board solvable? (see below)
	public boolean isSolvable() {
		return !goalReachedTwin;
	}

	// min number of moves to solve initial board; -1 if unsolvable
	public int moves() {
		if (!isSolvable()) {
			return -1;
		} else {
			return finalNode.moves;
		}
	}

	// sequence of boards in a shortest solution; null if unsolvable
	public Iterable<EightPuzzleBoard> solution() {
		List<EightPuzzleBoard> boardProgression = new ArrayList<EightPuzzleBoard>();
		if (!isSolvable()) {
			return null;
		} else {
			SearchNode node = finalNode;
			getBoardProgression(boardProgression, node);
			return boardProgression;
		}
	}

	private List<EightPuzzleBoard> getBoardProgression(List<EightPuzzleBoard> boardProgression, SearchNode node) {
		if (node.previousNode != null) {
			getBoardProgression(boardProgression, node.previousNode);
		}
		boardProgression.add(node.board);
		return boardProgression;
	}

	// test client (see below)
	public static void main(String[] args) {
		// int[][] tiles = { { 3, 5, 6 }, { 2, 1, 4 }, { 8, 7, 0 } };
		 int[][] tiles = { { 8, 6, 7 }, { 2, 0, 4 }, { 3, 5, 1 } };
		// int[][] tiles = { { 1, 2, 3 }, { 4, 5, 6 }, { 8, 7, 0 } };

		EightPuzzleBoard board = new EightPuzzleBoard(tiles);

		EightPuzzleSolver solver = new EightPuzzleSolver(board);

		System.out.println(solver.isSolvable());
		System.out.println(solver.moves());

		for (EightPuzzleBoard result : solver.solution()) {
			System.out.println(result);
			System.out.println("---------------");
		}

	}

}