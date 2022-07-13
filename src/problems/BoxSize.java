package problems;

import java.util.Arrays;

/**
 * Given the box sizes find the least box size that can accommodate the object
 */

public class BoxSize {

	public static void main(String[] args) {
		int[] boxSizes = {2, 9, 41, 51, 58, 68, 74, 75, 80, 87};
		int objectSize = 1;
		System.out.println(getBestBox(boxSizes, objectSize));
	}

	private static int getBestBox(int[] boxSizes, int objectSize){
		Arrays.sort(boxSizes);

		if (objectSize > boxSizes[boxSizes.length-1]){
			return -1;
		}

		return getBestBox(boxSizes, objectSize, 0, boxSizes.length-1);
	}

	private static int getBestBox(int[] boxSizes, int objectSize, int low, int high){
		int mid = low + (high-low)/2;

		if (boxSizes[mid] == objectSize){
			return boxSizes[mid];
		}
		else if (boxSizes[mid] > objectSize){
			if (mid==0 || boxSizes[mid-1] < objectSize){
				return boxSizes[mid];
			}
			else {
				return getBestBox(boxSizes, objectSize, low, mid);
			}
		}
		else {
			return getBestBox(boxSizes, objectSize, mid, high);
		}
	}
	
}
