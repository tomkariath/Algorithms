package problems;

import dataStructures.LLQueue;

public class Clusters {

	public static void main(String[] args) {
		int[][] input = { { 1, 1, 1, 0, 0, 0 }, 
						  { 0, 1, 1, 0, 0, 1 }, 
						  { 0, 0, 0, 1, 1, 0 }, 
						  { 1, 1, 0, 0, 0, 0 },
						  { 1, 0, 0, 0, 0, 0 }, 
						  { 0, 1, 0, 0, 0, 1 } };

		System.out.println(countClusters(input));
	}

	private static int countClusters(int[][] input) {
		int length = input.length;
		int count = 0;
		int[][] visited = new int[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (visited[i][j] != 1 && input[i][j] == 1) {
					getCluster(input, visited, i, j);
					count++;
				}
			}
		}

		return count;
	}

	private static void getCluster(int[][] input, int[][] visited, int row, int col) {
		LLQueue<String> queue = new LLQueue<String>();
		queue.enqueue(row + "," + col);

		while (queue.getSize() != 0) {
			String[] coord = queue.dequeue().split(",");
			int i = Integer.parseInt(coord[0]);
			int j = Integer.parseInt(coord[1]);

			if (i - 1 != -1 && visited[i - 1][j] == 0) {
				visited[i - 1][j] = 1;
				if (input[i - 1][j] == 1) {
					queue.enqueue((i - 1) + "," + j);
				}
			}
			if (i + 1 != input.length && visited[i + 1][j] == 0) {
				visited[i + 1][j] = 1;
				if (input[i + 1][j] == 1) {
					queue.enqueue((i + 1) + "," + j);
				}
			}
			if (j - 1 != -1 && visited[i][j - 1] == 0) {
				visited[i][j - 1] = 1;
				if (input[i][j - 1] == 1) {
					queue.enqueue(i + "," + (j - 1));
				}
			}
			if (j + 1 != input.length && visited[i][j + 1] == 0) {
				visited[i][j + 1] = 1;
				if (input[i][j + 1] == 1) {
					queue.enqueue(i + "," + (j + 1));
				}
			}
		}
	}
}
