package problems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class NMostRecurringWords {

	public static void main(String[] args) {
		try {
			Integer wordCount;
			Stream<String> stream = Files.lines(Paths.get("resources/recurringWordsTest.txt"));
			String[] inputLines = stream.map(String::toLowerCase).toArray(String[]::new);
			stream.close();

			HashMap<String, Integer> wordMap = new HashMap<>();
			ArrayList<String> resultMap = new ArrayList<>();

			for (String line : inputLines) {
				System.out.println(line);

				String[] inputWords = line.split(" ");
				for (String word : inputWords) {
					wordCount = wordMap.get(word);

					if (wordCount != null) {
						wordMap.put(word, wordCount + 1);
					} else {
						wordMap.put(word, 1);
					}
				}
			}

			List<Integer> countList = new ArrayList<>(wordMap.values());
			Collections.sort(countList);
			Collections.reverse(countList);

			int i = 0;
			for (Integer count : countList) {
				if (i == 10) {
					break;
				}
				for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
					if (Objects.equals(count, entry.getValue())) {
						if (!resultMap.contains(entry.getKey())) {
							resultMap.add(entry.getKey());
							i++;
							break;
						}
					}
				}
			}

			for (String entry : resultMap) {
				System.out.println(entry);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
