package problems;

import java.util.ArrayList;
import java.util.HashMap;

public class WordOrder {

	public static void main(String[] args) {
		String[] input = { "Chinnamma", "Chilakamma", "AR", "Rahman", "AR", "Rahman", "the", "Other", "Side", "2004" };
		String[] searchWords = { "AR", "Rahman", "the", "Other", "Side" };

		searchPattern(input, searchWords);
	}

	private static void searchPattern(String[] input, String[] searchWords) {
		HashMap<String, ArrayList<Integer>> inputMap = resolveToMap(input);
		search(inputMap, searchWords);
		
	}

	private static void search(HashMap<String, ArrayList<Integer>> inputMap, String[] searchWords) {
		int prevIndex = -1;
		for (String word : searchWords) {
			prevIndex = getCeiling(inputMap.get(word), prevIndex);
		}
		System.out.println(prevIndex);
		for (int i = searchWords.length-1; i>=0; i--) {
			prevIndex = getFloor(inputMap.get(searchWords[i]), prevIndex);
		}
		System.out.println(prevIndex);
	}

	private static int getFloor(ArrayList<Integer> indexList, int prevIndex) {
		for (int i = indexList.size()-1; i >= 0; i--) {
			if (indexList.get(i) <= prevIndex) {
				return indexList.get(i);
			}
		}
		return -1;
	}

	private static int getCeiling(ArrayList<Integer> indexList, int prevIndex) {
		for (int i = 0; i < indexList.size(); i++) {
			if (indexList.get(i) >= prevIndex) {
				return indexList.get(i);
			}
		}
		return -1;
	}

	private static HashMap<String, ArrayList<Integer>> resolveToMap(String[] input) {
		HashMap<String, ArrayList<Integer>> inputMap = new HashMap<String, ArrayList<Integer>>();
		int count = 0;
		ArrayList<Integer> tempList;
		for (String word : input) {
			tempList = inputMap.get(word);
			if (tempList == null) {
				tempList = new ArrayList<Integer>();
			}
			tempList.add(count);
			inputMap.put(word, tempList);
			count++;
		}
		return inputMap;
	}
}
