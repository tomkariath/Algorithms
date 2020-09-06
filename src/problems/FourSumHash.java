package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class FourSumHash {

	public static ArrayList<int[]> getThreeSumArray(int[] givenArray, int sumValue) {
		ArrayList<int[]> sumArrayList = new ArrayList<int[]>();
		int twoSumValue;

		Arrays.parallelSort(givenArray);

		for (int i = 0; i < givenArray.length - 2; i++) {
			twoSumValue = sumValue + givenArray[i];
			HashSet<Integer> candidateSet = new HashSet<Integer>();
			for (int j = i+1; j < givenArray.length; j++) {
				if (candidateSet.contains(twoSumValue-givenArray[j])) {
					sumArrayList.add(new int[] {sumValue, givenArray[i], twoSumValue-givenArray[j], givenArray[j]});
				}
				candidateSet.add(givenArray[j]);
			}
		}

		return sumArrayList;
	}
	
	public static void main(String[] args) {
		int[] givenArray = new int[] {0,1,2,3,4,5,6,7,8,9};
		
		ArrayList<int[]> resultList = null;
		for (int number : givenArray) {
			resultList = FourSumHash.getThreeSumArray(givenArray, number);
		}
		
		for (Iterator<int[]> iterator = resultList.iterator(); iterator.hasNext();) {
			int[] is = (int[]) iterator.next();
			for (int i = 0; i < is.length; i++) {
				System.out.print(is[i]);
			}
			System.out.println();
		}
	}
}
