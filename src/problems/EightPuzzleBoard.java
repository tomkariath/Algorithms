package problems;
import java.util.ArrayList;
import java.util.List;

public class EightPuzzleBoard {

	private final int[][] tiles;
	private final int dimension;
	private int blankRow, blankColumn;

	// create a board from an n-by-n array of tiles,
	// where tiles[row][col] = tile at (row, col)
	public EightPuzzleBoard(int[][] tiles) {
		dimension = tiles[0].length;
		this.tiles = new int[dimension][dimension];
		for (int i = 0; i < dimension(); i++) {
			for (int j = 0; j < dimension(); j++) {
				if (tiles[i][j] == 0) {
					blankRow = i;
					blankColumn = j;
				}
				this.tiles[i][j] = tiles[i][j];
			}
		}
	}

	// string representation of this board
	public String toString() {
		StringBuilder result = new StringBuilder(Integer.toString(dimension()));
		for (int i = 0; i < dimension(); i++) {
			result.append("\n");
			for (int j = 0; j < dimension(); j++) {
				result.append(tiles[i][j] + "\t");
			}
		}
		return result.toString();
	}

	// board dimension n
	public int dimension() {
		return dimension;
	}

	// number of tiles out of place
	public int hamming() {
		int count = 0;
		for (int i = 0; i < dimension(); i++) {
			for (int j = 0; j < dimension(); j++) {
				if (tiles[i][j] == 0) {
					continue;
				}
				int pos = i * dimension() + j;
				if (tiles[i][j] - 1 != pos) {
					count++;
				}
			}
		}
		return count;
	}

	// sum of Manhattan distances between tiles and goal
	public int manhattan() {
		int goalRow, goalColumn, currentColumn, currentRow, diff, sum = 0;
		for (int i = 0; i < dimension(); i++) {
			for (int j = 0; j < dimension(); j++) {
				if (tiles[i][j] == 0) {
					continue;
				}
				currentRow = i;
				currentColumn = j;

				goalRow = (tiles[i][j] - 1) / dimension();
				goalColumn = (tiles[i][j] - 1) % dimension();

				diff = Math.abs(goalRow - currentRow) + Math.abs(goalColumn - currentColumn);

				sum = sum + diff;
			}
		}
		return sum;
	}

	// is this board the goal board?
	public boolean isGoal() {
		return hamming() == 0;
	}

	// does this board equal y?
	public boolean equals(Object y) {
		if (y == null) {
			return false;
		}
		if (y.getClass()!=EightPuzzleBoard.class) {
			return false;
		}
		
		EightPuzzleBoard board2 = (EightPuzzleBoard) y;
		
		if (board2.dimension()!=this.dimension()) {
			return false;
		}
		
		for (int i = 0; i < dimension(); i++) {
			for (int j = 0; j < dimension(); j++) {
				if(board2.tiles[i][j] != this.tiles[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	// all neighboring boards
	public Iterable<EightPuzzleBoard> neighbors() {
		List<EightPuzzleBoard> neighborsList = new ArrayList<EightPuzzleBoard>();
		if (blankRow - 1 != -1) {
			neighborsList.add(getNeighborBoards(tiles, blankRow - 1, blankColumn));
		}
		if (blankRow + 1 < dimension()) {
			neighborsList.add(getNeighborBoards(tiles, blankRow + 1, blankColumn));
		}
		if (blankColumn - 1 != -1) {
			neighborsList.add(getNeighborBoards(tiles, blankRow, blankColumn - 1));
		}
		if (blankColumn + 1 < dimension()) {
			neighborsList.add(getNeighborBoards(tiles, blankRow, blankColumn + 1));
		}
		return neighborsList;
	}

	private EightPuzzleBoard getNeighborBoards(int[][] tiles, int newRow, int newColumn) {
		int[][] tempBoard = new int[dimension()][dimension()];
		copy(tiles, tempBoard);
		return swap(tempBoard, blankRow, blankColumn, newRow, newColumn);

	}

	private void copy(int[][] tiles1, int[][] tiles2) {
		for (int i = 0; i < dimension(); i++) {
			for (int j = 0; j < dimension(); j++) {
				tiles2[i][j] = tiles1[i][j];
			}
		}
	}

	private EightPuzzleBoard swap(int[][] tiles, int... indices) {
		int tempTile = tiles[indices[0]][indices[1]];
		tiles[indices[0]][indices[1]] = tiles[indices[2]][indices[3]];
		tiles[indices[2]][indices[3]] = tempTile;

		return new EightPuzzleBoard(tiles);
	}

	// a board that is obtained by exchanging any pair of tiles
	public EightPuzzleBoard twin() {
		int[][] tempBoard = new int[dimension()][dimension()];
		copy(tiles, tempBoard);
		int[] indices = new int[4];
		int index = 0;
		for (int i = 0; i<dimension() && index < 4; i++) {
			for (int j = 0; j<dimension() && index < 4; j++) {
				if (tiles[i][j] == 0) {
					continue;
				}
				indices[index++] = i;
				indices[index++] = j;
			}
		}
		return swap(tempBoard, indices);
	}

	// unit testing (not graded)
	public static void main(String[] args) {
		//int[][] tiles = { { 3, 1, 0, 9 }, { 4, 2, 5, 10 }, { 7, 8, 6, 11 }, { 12, 13, 14, 15 } };
		int[][] tiles = {{1,0},{3,2}};
		
		EightPuzzleBoard board = new EightPuzzleBoard(tiles);
		EightPuzzleBoard board2 = new EightPuzzleBoard(tiles);

		System.out.println(board.toString());
		System.out.println(board.dimension());
		System.out.println(board.hamming());
		System.out.println(board.manhattan());
		System.out.println(board.equals(board2));
		for (EightPuzzleBoard neighbours : board.neighbors()) {
			System.out.println("------------");
			System.out.println(neighbours.toString());
		}
		System.out.println(board.equals(board2));
		System.out.println(board.twin().toString());
	}

}