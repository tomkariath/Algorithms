package problems;

import edu.princeton.cs.algs4.In;

public class ReverseBinaryBetter {
    private static int reverseBits (int number){
        int reversedNumber = 0;

        while (number > 0){
            reversedNumber<<=1; //left shift by 1 bit Eg: 1111->1110

            if ((number & 1) == 1){ // Eg: 1101 & 0001 -> 0001, 1000 & 0001 = 0000
                reversedNumber ^= 1; //Eg: 1100 ^ 0001 -> 1101 (XOR, same 0, diff 1)
            }

            number >>= 1; //right shift by 1 bit Eg:1111->0111
        }

        return reversedNumber;
    }

    public static void main(String[] args) {
        int input = 6;
        System.out.println(reverseBits(input));
    }
}
