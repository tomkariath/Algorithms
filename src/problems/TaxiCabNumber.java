package problems;

import java.util.Arrays;
import java.util.HashSet;

public class TaxiCabNumber {

	public static void main(String[] args) {
		int limit = 12;
		int[] cubicArray = new int[limit];

		for (int i = 1; i <= cubicArray.length; i++) {
			cubicArray[i - 1] = i * i * i;
		}

		findTaxiCab(cubicArray);

		System.out.println(Arrays.toString(cubicArray));
	}

	private static void findTaxiCab(int[] cubicArray) {
		int sum;
		HashSet<Integer> resultSet = new HashSet<Integer>();
		for (int i = cubicArray.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				sum = cubicArray[i] + cubicArray[j];
				if (resultSet == null || !resultSet.contains(sum)) {
					for (int k = 0; k < cubicArray.length; k++) {
						if (k != i && k != j) {
							if (Arrays.binarySearch(cubicArray, sum - cubicArray[k]) >= 0) {
								System.out.println(sum + "=" + cubicArray[k] + "+" + (sum - cubicArray[k]) + "="
										+ cubicArray[i] + "+" + (cubicArray[j]));
								resultSet.add(sum);
								break;
							}
						}
					}
				}
			}
		}
	}
}
