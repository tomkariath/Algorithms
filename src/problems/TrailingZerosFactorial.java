package problems;

/**
 * For an integer N find the number of trailing zeroes in N!.
 * Example 1:
 * Input:
 * N = 5
 * Output: 1
 * Explanation: 5! = 120 so the number of trailing zero is 1.
 */

public class TrailingZerosFactorial {

    public static void main(String[] args) {
        int input = 384;
        int denominator = 5;
        int zeroes = 0;

        while (denominator <= input) {
            zeroes = zeroes + input / denominator;
            denominator = denominator * 5;
        }

        System.out.println(zeroes);
    }
}
