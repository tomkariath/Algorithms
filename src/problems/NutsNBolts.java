package problems;

public class NutsNBolts {

	public static int sortBolt(int nutSize, int[] bolts, Integer low, Integer high) {
		int splitPosition = partition(nutSize, bolts, low, high);

		/*
		 * //sort left if (low<splitPosition-1){ sortBolt(nutSize, bolts, low,
		 * splitPosition-1); } //sort right if (splitPosition+1<high) sortBolt(nutSize,
		 * bolts, splitPosition+1, high);
		 */
		return splitPosition;
	}

	private static int partition(int partitionElement, int[] inputArray, Integer leftEnd, 
			Integer rightEnd) {
		
		int i=leftEnd, j=rightEnd;
		
		while (i<j) {
			while (inputArray[i]<partitionElement && i<rightEnd) {
				i++;
			}
			
			while (inputArray[j]>partitionElement) {
				j--;
			}
			
			if (i < j) {
				swap(inputArray, i, j);
			}
		}
		
		System.out.println(inputArray[j] +"="+ partitionElement);
		//System.out.println(inputArray[j-1] +"="+ partitionElement);
		
		return j;
	}

	private static void swap(int[] inputArray, int firstIndex, int secondIndex) {
		int temp = inputArray[firstIndex];
		inputArray[firstIndex] = inputArray[secondIndex];
		inputArray[secondIndex] = temp;
	}

	public static void main(String[] args) {
		int[] nuts = { 3, 4, 5, 2, 1, 7, 8, 9, 0, 6};
		int[] bolts = { 5, 4, 3, 2, 1 ,8,7,9,0, 6};
		
		Integer low = 0;
		Integer high = bolts.length-1;

		int splitPosition = -1;
		int previousNut = nuts[0];
		
		for (int i = 0; i < nuts.length; i++) {
			if (nuts[i] < previousNut) {
				splitPosition = sortBolt(nuts[i], bolts, low, splitPosition-1);
			}
			else if (nuts[i] >= previousNut) {
				splitPosition = sortBolt(nuts[i], bolts, splitPosition+1, high);
			}
			
		}
	}
}
