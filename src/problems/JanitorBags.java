package problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A janitor has bags with weights varying from 1.0 to 3.0
 * in one trip, the janitor carries a max weight of 3.0
 * calc min number of trips for the janitor to carry all the bags to trash
 */

public class JanitorBags {
    public static void main(String[] args) {
        int max_weight = 5;
        List<Double> bags = Arrays.asList(1.1, 1.6, 2.0, 1.9, 2.5, 2.6, 1.0, 2.0, 1.4, 1.4);
        Collections.sort(bags);
        System.out.println(getNumberOfTrips(bags, max_weight));
    }

    private static int getNumberOfTrips(List<Double> bags, int max){
        int count=0;
        int left=0;
        int right=bags.size()-1;
        printRemainingBags(bags, left, right);

        while (left<right){
            if ((bags.get(right) + bags.get(left)) > max){
                count ++;
                System.out.println(bags.get(right));
                right --;
                printRemainingBags(bags, left, right);
            }
            else {
                double weight = bags.get(right) + bags.get(left);
                System.out.print(bags.get(right) +"+"+ bags.get(left));
                left++;
                right--;

                boolean loopFlag=true;
                while (loopFlag){
                    weight += bags.get(left);
                    if (weight < max) {
                        System.out.print("+"+bags.get(left));
                        left++;
                    }
                    else {
                        loopFlag = false;
                        count++;
                        System.out.println();
                        printRemainingBags(bags, left, right);
                    }
                }
            }
        }

        return count;
    }

    private static void printRemainingBags(List<Double> bags, int left, int right){
        for(int i=left; i<=right; i++){
            System.out.print(bags.get(i)+" ");
        }
        System.out.println();
    }
}
