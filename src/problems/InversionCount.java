package problems;

public class InversionCount {
	
	public static int getCount (int[] inputArray) {
		int count = 0;
		
		for (int j=inputArray.length-1; j>=0; j--) {
			for (int i = 0; i < j; i++) {
				if (inputArray[i]>inputArray[j]) {
					count++;
				} 
			}
		}
		return count;
	}

	public static void main(String[] args) {
		//int[] inputArray = {1,0,2,9,3,8,4,7,5,6};
		int[] inputArray = {0,1,2,3,4,5,6,7,8,9};
		//int[] inputArray = {9,8,7,6,5,4,3,2,1,0};
		System.out.println(getCount(inputArray));

	}
}
