package algorithms;

public class MergeSort {

	static int[] tempArray;
	static int tempindex=0;
	
	//sort
	public static void sort (int[] inputArray) {
		tempArray = new int[inputArray.length];
		sort(inputArray, 0, inputArray.length/2, inputArray.length);
	}
	//sort
	private static void sort (int[] inputArray, int low, int mid, int high) {
		sort(inputArray, low, (low+mid)/2, mid+1);
		sort(inputArray, mid+1, (mid+high)/2, high);
		merge(inputArray, low, mid, high);
		
	}

	//merge
	private static void merge (int[] inputArray, int low, int mid, int high) {
		if(inputArray[mid]<inputArray[mid+1]) {
			for (int i = 0; i < high; i++,tempindex++) {
				tempArray[tempindex] = inputArray[i];
			}
		}
		else {
			int i = low, j = mid+1;
			
			while(i < mid+1 && j < high) {// TODO check if or?? and fill rest
				if (inputArray[i]<=inputArray[j]) {
					tempArray[tempindex++] = inputArray[i++];
				}
				else {
					tempArray[tempindex++] = inputArray[j++];
				}
			}
		}
	}
}
