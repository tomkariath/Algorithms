package problems;

import java.util.Arrays;

public class BoxSize {

	public static void main(String[] args) {
		int[] boxSizes = {10,20,30,40,50,60,70,80,90};
		int objectSize = 97;
		
		System.out.println(getBoxSize(boxSizes, objectSize));
	}

	private static int getBoxSize(int[] boxSizes, int objectSize) {
		int length = boxSizes.length;
		
		System.out.println(length/2 +" "+ objectSize);
		if (boxSizes[length/2] > objectSize && (length/2 == 0 || boxSizes[(length/2)-1] < objectSize)) {
			return boxSizes[length/2];
		}
		else if (boxSizes[length/2] > objectSize) {
			return getBoxSize(Arrays.copyOf(boxSizes, length/2), objectSize);
		}
		else if (boxSizes[length/2] < objectSize && length/2 != 0) {
			return getBoxSize(Arrays.copyOfRange(boxSizes, length/2, length), objectSize);
		}
		else {
			return -1;
		}
	}
	
}
