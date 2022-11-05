package problems;

public class TwelveTo24 {
    private static boolean isAM (String input){
        return input.endsWith("AM");
    }

    public static String convert12to24 (String input){
        int endIndex = input.length()-2;
        if (isAM(input)){
            if (input.startsWith("12")){
                return "00" + input.substring(2, endIndex);
            }
            else {
                return input.substring(0, endIndex);
            }
        }
        else {
            if (input.startsWith("12")){
                if (input.startsWith("12:00:00")){
                    return "24" + input.substring(2, endIndex);
                }
                return input.substring(0, endIndex);
            }

            int convertedHour = Integer.parseInt(input.substring(0,2))+12;
            return convertedHour + input.substring(2, endIndex);
        }
    }

    public static void main(String[] args) {
        String input = "12:04:00AM";
        System.out.println(convert12to24(input));
    }
}
