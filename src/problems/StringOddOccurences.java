package problems;

import java.util.Arrays;

public class StringOddOccurences {

	public static void main(String[] args) {
		//97-122
		int[] duplicateChecker = new int[27];
		int index = 0;
		char[] inputArray = "you got beautiful eyes".toCharArray();

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i]==' ') {
				if (duplicateChecker[26]==0) {
					duplicateChecker[26]++;
					inputArray[index++] = inputArray[i];
				}
				else {
					duplicateChecker[26]--;
				}
			}
			else { 
				if (duplicateChecker[inputArray[i]-97] == 0) {
					duplicateChecker[inputArray[i]-97]++;
					inputArray[index++] = inputArray[i];
				}
				else {
					duplicateChecker[inputArray[i]-97]--;
				}
			}
		}

		inputArray = Arrays.copyOf(inputArray, index);

		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i]);
		}
	}
}
