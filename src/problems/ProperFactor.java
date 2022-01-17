package problems;

/**
 * Proper Factor - numerator < denominator, HCF(numerator, denominator) = 1
 */

public class ProperFactor {
    public static void main(String[] args) {
        generateProperFactors(8);
    }

    private static void generateProperFactors(int number){
        for (int i=1; i<=number; i++){
            for (int j=1; j<i; j++){
                if (isProper(j,i)){
                    System.out.println(j+"/"+i);
                }
            }
        }
    }

    private static boolean isProper(int numerator, int denominator){
        if (numerator == 1){
            return  true;
        }

        if (denominator % numerator == 0){
            return false;
        }

        if (getHCF(denominator, numerator) > 1){
            return false;
        }

        return true;
    }

    private static int getHCF(int a, int b){
        if (b==0){
            return a;
        }

        return getHCF(b, a%b);
    }
}
