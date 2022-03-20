package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 6
 * 2 cheese peppers
 * 0
 * 1 basil
 * 1 pineapple
 * 2 mushrooms tomatoes
 * 1 basil
 */

public class Generic {
    private static int testCases;
    private static final Map<Integer, String[]> testCaseMap = new HashMap<>();

    private static void readInput(){
        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i=0; i<testCases; i++){
            getTestCaseData(i,scanner);
        }
    }

    private static void getTestCaseData(int testCase, Scanner scanner){
       // int inputCount = scanner.nextInt();
       // scanner.nextLine();
        String[] inputArray = new String[2];

        //for (int i=0;i<inputCount; i++){
            String input = scanner.nextLine();
            inputArray = input.split(" ");
        //}
        testCaseMap.put(testCase, inputArray);
    }

    public static void main(String[] args) {
        readInput();

        for(Map.Entry<Integer, String[]> entry : testCaseMap.entrySet()){
            System.out.println(entry.getKey());

            for (String input: entry.getValue()){
                System.out.println(input);
            }
        }
    }
}
