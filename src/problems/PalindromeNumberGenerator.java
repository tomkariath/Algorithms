package problems;

import java.util.LinkedList;
import java.util.List;

public class PalindromeNumberGenerator {
    public static void main(String[] args) {
        generateOddPalindromes(5000);
        generateEvenPalindromes(5000);
    }

    //axa
    public static List<Integer> generateOddPalindromes(int upperLimit){
        List<Integer> oddPalindromes = new LinkedList<>();

        String palindrome;
        int number = 0;
        for (int a=0; number<upperLimit; a++){
            for (int x=0; x<10; x++){
                if (a==0){
                    palindrome = String.valueOf(x);
                }
                else {
                    palindrome = a +String.valueOf(x)+ a;
                }
                number = Integer.parseInt(palindrome);
                if (number < upperLimit){
                    oddPalindromes.add(number);
                }
            }
        }

        return oddPalindromes;
    }

    //abba
    public static List<Integer> generateEvenPalindromes(int upperLimit){
        List<Integer> evenPalindromes = new LinkedList<>();

        String palindrome;
        int number = 0;
        for (int a=1; number<upperLimit; a++){
            if (a%10 == 0){
                continue;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(a));
            palindrome = sb.toString();
            palindrome = palindrome + sb.reverse();

            number = Integer.parseInt(palindrome);
            if (number < upperLimit){
                evenPalindromes.add(number);
            }
        }

        return evenPalindromes;
    }
}
