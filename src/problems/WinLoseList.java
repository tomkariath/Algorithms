package problems;

import java.util.*;

public class WinLoseList {
    /**
     * # Intuition
     * Thought of 2 possibilities.
     * 1. Use Integer array with indexes pointing to participants.
     * 2. Hashmap of participants with win count
     *
     * Array approach had the caveat that there might to unused index spaces amount to wasted space
     *
     * # Approach
     * Add match results to Hashmap and increment lose counter
     *
     * # Complexity
     * - Time complexity:
     * n -> number of matches
     * m -> number of participants
     * w -> win size
     * l -> lose size
     *
     * O(n) to iterate through matches array
     * O(m) to iterate throuh the participants
     * O(wlog(w)) to sort the win result
     * O(l*log(l)) to sort the win result
     *
     * - Space complexity:
     * O(m) + O(w) +O(l)
     */

    private static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> noLose = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();

        Map<Integer, Integer> scoreBoard = new HashMap<>();

        for (int[] result : matches){
            scoreBoard.putIfAbsent(result[0], 0);

            // key to get the value
            // default value
            // Operation to be performed with the parameters (oldValue, default value)
            scoreBoard.merge(result[1], 1, Integer::sum);


            //Initial code
            /*if (scoreBoard.get(result[1]) == null){
                scoreBoard.put(result[1], 1);
            }
            else {
                scoreBoard.put(result[1], scoreBoard.get(result[1])+1);
            }*/
        }

        for (Map.Entry<Integer, Integer> entry : scoreBoard.entrySet()) {
            if (entry.getValue() == 0){
                noLose.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                oneLose.add(entry.getKey());
            }
        }

        Collections.sort(noLose);
        Collections.sort(oneLose);

        answer.add(noLose);
        answer.add(oneLose);


        return answer;
    }

    public static void main(String[] args) {
        //int [][] matches = {{2,3},{1,3},{5,4},{6,4}};
        int [][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};

        for (List<Integer> list : findWinners(matches)){
            System.out.println(list);
        }
    }
}
