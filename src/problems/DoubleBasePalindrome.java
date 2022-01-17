package problems;

import java.util.List;

/**
 * Numbers which are palindromes in more than 1 bases are called double base palindromes
 */

public class DoubleBasePalindrome {
    public static void main(String[] args) {
        getDoubleBasePalindromes(100, 2);
    }

    private static void getDoubleBasePalindromes(int limit, int base){
        List<Integer> oddPalindromes = PalindromeNumberGenerator.generateEvenPalindromes(limit);
        List<Integer> evenPalindromes = PalindromeNumberGenerator.generateOddPalindromes(limit);

        for (Integer number: oddPalindromes) {
            if (isBaseKPalindrome(number, base)){
                System.out.println(number);
            }
        }

        for (Integer number: evenPalindromes) {
            if (isBaseKPalindrome(number, base)){
                System.out.println(number);
            }
        }
    }

    private static boolean isBaseKPalindrome (int number, int base){
        StringBuilder convertedNumber = new StringBuilder();
        while (number > 0) {
            int digit = number % base;
            number /= base;
            convertedNumber.append(digit);
        }

        String reversed = convertedNumber.toString();

        if (reversed.equalsIgnoreCase(convertedNumber.reverse().toString())){
            return true;
        }

        return false;
    }
}
