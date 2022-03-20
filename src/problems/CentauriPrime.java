package problems;

import java.util.*;

public class CentauriPrime {

    private static String getRuler(String kingdom) {
        if (kingdom.matches(".*[AEIOUaeiou]$")){
            return "Alice";
        }
        else if (kingdom.endsWith("y") || kingdom.endsWith("Y")){
            return "nobody";
        }
        return "Bob";
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int T = in.nextInt();

            for (int t = 1; t <= T; ++t) {
                String kingdom = in.next();
                System.out.println(
                        "Case #" + t + ": " + kingdom + " is ruled by " + getRuler(kingdom) + ".");
            }
        }
    }
}