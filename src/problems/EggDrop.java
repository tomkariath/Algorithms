package problems;

public class EggDrop {

	public static int getMinTries(int eggCount, int floorCount) {
		int[][] eggFloor = new int[eggCount + 1][floorCount + 1];
		int result;

		for (int i = 1; i < eggCount; i++) {
			eggFloor[i][0] = 0;
			eggFloor[i][1] = 1;
		}

		for (int j = 1; j < floorCount; j++) {
			eggFloor[1][j] = j;
		}

		for (int i = 2; i <= eggCount; i++) {
			for (int j = 2; j <= floorCount; j++) {
				eggFloor[i][j] = Integer.MAX_VALUE;

				for (int trialStep = 1; trialStep <= j; trialStep++) {
					result = 1 + max(eggFloor[i - 1][trialStep - 1], eggFloor[i][j - trialStep]);
					if (result < eggFloor[i][j]) {
						eggFloor[i][j] = result;
					}
				}
			}
		}
		return eggFloor[eggCount][floorCount];
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	public static void main(String[] args) {
		System.out.println(getMinTries(2, 10));
	}
}
