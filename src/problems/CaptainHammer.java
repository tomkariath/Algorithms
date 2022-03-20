package problems;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * angle = 1/2 * sin^-1(gD/v^2)
 *
 * 3
 * 98 980
 * 98 490
 * 299 1234
 */
public class CaptainHammer {
    private static int testCases;
    private static final Map<Integer, String> testCaseMap = new HashMap<>();
    private static final double G = 9.8;
    private static final double RADIAN_TO_DEGREE = 180/Math.PI;

    public static void main(String[] args) {
        readInput();

        for (Map.Entry<Integer, String> entry : testCaseMap.entrySet()){
            double launchAngle = getLaunchAngle(entry.getValue().split(" "));
            System.out.println("Case #"+entry.getKey()+": "+launchAngle);
            //System.out.println("Case #"+entry.getKey()+": "+String.format("%.9f", launchAngle));
        }
    }

    private static void readInput(){
        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i=0; i<testCases; i++){
            getTestCaseData(i,scanner);
        }
    }

    private static void getTestCaseData(int testCase, Scanner scanner){
        String value = scanner.nextLine();
        testCaseMap.put(testCase+1, value);
    }

    private static double getLaunchAngle (String[] inputs){
        double velocity = Double.parseDouble(inputs[0]);
        double distance = Double.parseDouble(inputs[1]);

        double a = roundToPrecision(G*distance);
        double b = roundToPrecision(Math.pow(velocity, 2));

        return RADIAN_TO_DEGREE * 0.5 * Math.asin(a/b);
    }

    private static double roundToPrecision(double value){
        int precision = 10;
        return BigDecimal.valueOf(value).setScale(precision, RoundingMode.HALF_UP).doubleValue();
    }
}
