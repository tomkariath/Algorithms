package problems;

import java.util.*;

public class HIndex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get number of test cases in input
        int testCaseCount = scanner.nextInt();

        // Iterate through test cases
        for (int tc = 1; tc <= testCaseCount; ++tc) {

            // Get number of papers for this test case
            int paperCount = scanner.nextInt();
            // Get number of citations for each paper
            int[] citations = new int[paperCount];
            for (int p = 0; p < paperCount; ++p) {
                citations[p] = scanner.nextInt();
            }

            // Print h-index score after each paper in this test case
            System.out.print("Case #" + tc + ":");
            for (int score : getHIndexScore(citations)) {
                System.out.append(" ").print(score);
            }
            System.out.println();
        }
    }

    public static int[] getHIndexScore(int[] citationsPerPaper) {
        int[] hIndices = new int[citationsPerPaper.length];
        int paper = 2;
        ArrayList<Integer> potentials = new ArrayList<>();
        hIndices[0] = 1;
        if (citationsPerPaper[0] >= 2){
            potentials.add(citationsPerPaper[0]);
        }

        for (int i=1; i< citationsPerPaper.length; i++){
            if (citationsPerPaper[i] < paper){
                hIndices[i] = hIndices[i-1];
            }
            else {
                potentials.add(citationsPerPaper[i]);
                if (potentials.size() == paper){
                    hIndices[i] = paper++;
                    cullPotentials(potentials, paper);
                }
                else {
                    hIndices[i] = hIndices[i-1];
                }
            }
        }

        return hIndices;
    }

    private static void cullPotentials(ArrayList<Integer> potentials, int paper){
        potentials.removeIf(potential -> potential < paper);
    }
}
