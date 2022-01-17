package problems;

public class BaseKConverter {

    private static String convertToBase(int number, int base)
    {
        StringBuilder convertedNumber = new StringBuilder();
        while (number > 0) {
            int digit = number % base;
            number /= base;
            convertedNumber.append(digit);
        }
        return convertedNumber.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase(6,2));
    }
}
