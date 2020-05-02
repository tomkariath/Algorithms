package problems;

public class PermutationArray {

	public static boolean isSameSet (int[] firstArray, int[] secondArray) {
		boolean flag;
		
		if (firstArray.length!=secondArray.length) {
			return false;
		}

		for (int i = 0; i < firstArray.length; i++) {
			flag=false;
			
			for (int j = 0; j < secondArray.length; j++) {
				if (firstArray[i] == secondArray[j]) {
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] inputArray1 = {1,2,3,4,5};
		int[] inputArray2 = {4,2,5,3,1};
		
		System.out.println(isSameSet(inputArray2, inputArray1));
	}
}
