package problems;

public class BitonicArray {
	public static int findElement(int[] givenArray, int element) {
		int leftIndex = 0, rightIndex = givenArray.length - 1;

		while ((leftIndex <= rightIndex)) {
			if (givenArray[leftIndex] == element) {
				return leftIndex;
			} else if (givenArray[rightIndex] == element) {
				return rightIndex;
			} else {
				leftIndex++;
				rightIndex--;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] givenArray = new int[] {0,2,4,6,5,3,1};
		
		System.out.println(BitonicArray.findElement(givenArray, 1));
	}
}
