package problems;

import java.util.Arrays;

public class SortPebble {

	public static void sort (char[] buckets) {
		int hGap = 1;
		int count = 0;
		while (hGap < buckets.length / 3) {
			hGap = 3 * hGap + 1;
		}
		while (hGap > 0) {
			for (int i = hGap; i < buckets.length; i++) {
				for (int j = i; j - hGap >= 0; j -= hGap) {
					if (buckets[j] < buckets[j - hGap]) {
						swap(buckets, j, j - hGap);
						count++;
					}
					System.out.println(Arrays.toString(buckets) + " "+ count);
				}
			}
			hGap /= 3;
		}
	}
	
	private static void swap(char[] buckets, int firstBucket, int secondBucket) {
		char temp = buckets[secondBucket];
		buckets[secondBucket] = buckets[firstBucket];
		buckets[firstBucket] = temp;
	}
	
	public static void main(String[] args) {
		//char[] inputArray = {'r','w','b','r','w','b','r','w','b','r','w','b'};
		//char[] inputArray = {'b','b','b','b','r','r','r','r', 'w','w','w','w'};
		char[] inputArray = {'w','w','w','w','r','r','r','r','b','b','b','b' };
		sort(inputArray);
		
		System.out.println(Arrays.toString(inputArray));
	}
}
