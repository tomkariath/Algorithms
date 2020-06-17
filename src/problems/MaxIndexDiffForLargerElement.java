package problems;

public class MaxIndexDiffForLargerElement {
	
	public static void main(String[] args) {
		int diff = 0;
		
		//int[] inputArray = {9,2,3,4,5,6,7,8,9,10};
		//int[] inputArray = {10,2,3,4,5,6,7,8,9,10};
		int[] inputArray = {10,9,11,7,6,5,4,3,2,1};
		
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = inputArray.length-1; j > i+1; j--) {
				if (inputArray[j]>inputArray[i]) {
					if (diff<(j-i)) {
						diff = j-i;
					}
					else {
						break;
					}
				}
			}
		}
		
		System.out.println(diff);
	}

}
