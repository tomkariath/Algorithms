package problems;

public class CeaserCipher {

    public static String caesarCipher(String s, int k) {
        k=k%26;
        // Write your code here
        StringBuilder output = new StringBuilder();
        // Write your code here
        for (char character : s.toCharArray()){
            char ceaserChar=' ';
            if (character<='Z' && character>='A'){
                ceaserChar= (char) (character+k);

                if (ceaserChar >'Z'){
                    ceaserChar= (char) (((ceaserChar)%'Z')+'A'-1);
                }
                output.append(ceaserChar);
            }

            else if (character<='z' && character>='a'){
                ceaserChar= (char) (character+k);
                if (ceaserChar >'z'){
                    ceaserChar= (char) (((ceaserChar)%'z')+'a'-1);
                }
                output.append(ceaserChar);
            }
            else {
                output.append(character);
            }


        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(caesarCipher("Pz-/aI/J`EvfthGH", 66));
    }
}
