package problems;

class LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        if (n == 1)
            return 9;

        final int maxValue = (int) Math.pow(10, n) - 1;
        final int minValue = (int) Math.pow(10, n - 1) - 1;

        for (int i=maxValue; i>minValue; i--){
            long palindrome = convertToPalindrome(i);
            //99660
            System.out.println(palindrome);
            for (long j=maxValue; j*j>=palindrome; j--){
                //System.out.println(j+" "+palindrome%j);
                if (palindrome%j == 0){
                    System.out.println(palindrome);
                    return (int) (palindrome%1337);
                }
            }
        }

        throw new IllegalArgumentException();
    }

    private long convertToPalindrome(int number){
        StringBuilder reverse = new StringBuilder().append(number).reverse();
        return Long.parseLong(number+reverse.toString());
    }

    public static void main(String[] args) {
        LargestPalindromeProduct lpp = new LargestPalindromeProduct();
        System.out.println(lpp.largestPalindrome(5));
    }
}
