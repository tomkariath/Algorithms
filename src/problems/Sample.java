package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sample {

    private static int testCases;
    private static final Map<Integer, String[][]> testCaseMap = new HashMap<>();

    private static void readInput(){
        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i=0; i<testCases; i++){
            getLeftOverCandy(i,scanner);
        }
    }

    private static void getLeftOverCandy(int testCase, Scanner scanner){
        String[] inputs = scanner.nextLine().split(" ");

        int bags = Integer.parseInt(inputs[0]);
        int children = Integer.parseInt(inputs[1]);

        String[] candyCounts = scanner.nextLine().split(" ");
        int totalCandy = 0;

        for (int i=0;i<bags; i++){
            totalCandy += Integer.parseInt(candyCounts[i]);
        }

        System.out.println("Case #"+(testCase+1)+": "+totalCandy%children);
    }

    public static void main(String[] args) {
        readInput();
    }
}
