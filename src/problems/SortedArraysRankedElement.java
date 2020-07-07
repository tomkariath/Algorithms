package problems;


/*Selection in two sorted arrays. Given two sorted arrays a[] and b[], of lengths n1 and n2 and an 
 * integer 0 < k < n1 + n2, design an algorithm to find a key of rank k. The order of growth of the 
 * worst case running time of your algorithm should be logn, where n=n1+n2.*/

public class SortedArraysRankedElement {
	public static void main(String[] args) {
		int[] array1 = {1,2,3,4,5};
		int[] array2 = {0,6,7,8,9};
		int index = 7;
		
		System.out.println(findKthElement(array1, array2, index));
	}

	private static int findKthElement(int[] array1, int[] array2, int index) {
		boolean arraysInOrder = array1[array1.length-1]<array2[0];
		boolean arraysInReverse = array2[array1.length-1]<array1[0];
		
		// check if arrays2 comes after arrays1
		if (arraysInOrder) {
			if (index<=array1.length) {
				return array1[index];
			}
			else {
				return array2[index-array1.length];
			}
		}
		
		// check if arrays1 comes after arrays2
		else if (arraysInReverse) {
			if (index<=array2.length) {
				return array2[index];
			}
			else {
				return array1[index-array2.length];
			}
		}
		//increment indices and add elements to temp array of size k
		else {
			int[] temp = new int[index];
			for (int i=0,j=0,k=0; k< index; k++) {
				if (i< array1.length && array1[i]<array2[j]) {
					temp[k]=array1[i];
					i++;
				}
				else {
					temp[k]=array2[j];
					j++;
				}
			}
			return temp[index-1];
		}
	}
}