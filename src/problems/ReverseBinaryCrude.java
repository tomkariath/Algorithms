package problems;

/**
 * 6->110
 * 110->011
 * 011->3
 */
public class ReverseBinaryCrude {

    private static String generateBinary(int decimal){
        StringBuilder binary = new StringBuilder();

        while (decimal > 0){
            binary.append(decimal % 2);
            decimal = decimal/2;
        }
        binary.reverse();

        return binary.toString();
    }

    //Actual Binary needs to be reversed
    private static String generateReverseBinary(int decimal){
        StringBuilder binary = new StringBuilder();

        while (decimal > 0){
            binary.append(decimal % 2);
            decimal = decimal/2;
        }

        return binary.toString();
    }

    private static int generateDecimal(String binary){
        double decimal = 0.0;
        int power = binary.length()-1;
        for (char digit : binary.toCharArray()){
            decimal = decimal + (Character.getNumericValue(digit) * Math.pow(2, power));
            power--;
        }

        return (int) decimal;
    }

    public static void main(String[] args) {
        int input = 6;
        System.out.println(generateDecimal(generateReverseBinary(input)));
    }
}
