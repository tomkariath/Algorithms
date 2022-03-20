package problems;

import edu.princeton.cs.algs4.SET;

import java.util.*;

//AB
//BC
//CD
//DE
//EA

/**
 *A B
 *C D
 *E A
 * A-B-C-D-E-A
 * Check if the flow is cyclical and path length is odd
 * recurrence, mark as visited
 */

public class BadHorse {
    private static int testCases;
    private static final Map<Integer, String[][]> testCaseMap = new HashMap<>();
    private static final Map<String, Set<String>> conflictMap = new HashMap<>();
    private static final Set<String> visitedNames = new TreeSet<>();
    private static int nameSize=0;

    public static void main(String[] args) {
        readInput();
        for (Map.Entry<Integer, String[][]> entry : testCaseMap.entrySet()){
            plotConflictMap(entry.getValue());
        }

        for (Map.Entry<String, Set<String>> entry : conflictMap.entrySet()){
            System.out.println(entry.getKey() + " " +entry.getValue());
        }

        System.out.println(checkIfSplittable());
    }

    private static boolean checkIfSplittable(){
        nameSize = conflictMap.entrySet().size();
        Map.Entry<String, Set<String>> entry = conflictMap.entrySet().iterator().next();
        return traverseConflictMap(entry.getKey(), entry.getValue(), "", 1);
    }

    private static boolean traverseConflictMap(String name, Set<String> conflicts, String previousName, int pathSize){
        visitedNames.add(name);

        /*if (visitedNames.size() == nameSize){
            return true;
        }*/

        for(String nextName : conflicts){
            if(nextName.equalsIgnoreCase(previousName)){
               continue;
            }
            if (visitedNames.contains(nextName)){
                if (pathSize%2 != 0){
                    return false;
                }
                continue;
            }
            return traverseConflictMap(nextName, conflictMap.get(nextName), name, ++pathSize);
        }

        return true;
    }

    private static void plotConflictMap (String[][] conflicts){
        for (String[] conflict : conflicts) {
            populateMap(conflict[0], conflict[1]);
            populateMap(conflict[1], conflict[0]);
        }
    }

    private static void populateMap (String conflictor, String conflictee){
        if (conflictMap.get(conflictor) == null) {
            Set<String> conflictList = new TreeSet<>();
            conflictList.add(conflictee);
            conflictMap.put(conflictor, conflictList);
        } else {
            Set<String> conflictList = conflictMap.get(conflictor);
            conflictList.add(conflictee);
            conflictMap.put(conflictor, conflictList);
        }
    }

    private static void readInput(){
        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextInt();

        for (int i=0; i<testCases; i++){
            getTestCaseData(i,scanner);
        }
    }

    private static void getTestCaseData(int testCase, Scanner scanner){
        int pairCount = scanner.nextInt();
        scanner.nextLine();
        String[][] troublesomePairs = new String[pairCount][2];

        for (int i=0;i<pairCount; i++){
            String pair = scanner.nextLine();
            troublesomePairs[i] = pair.split(" ");
        }
        testCaseMap.put(testCase, troublesomePairs);
    }
}
