package problems;

public class LongestCommonSubsequence {
    private static Integer[][] memo;
    private static final StringBuilder sequence = new StringBuilder();

    public static void main(String[] args) {
        String input1 = "bheeshmaparvam";
        String input2 = "sushinshyam";
        memo = new Integer[input1.length()][input2.length()];

        int length = findLCS(input1, input2);
        System.out.println();

        /*for(Integer[] array : memo){
            for(Integer n : array){
                System.out.print(n +" ");
            }
            System.out.println();
        }*/

        getSequence(input1.toCharArray(), input2.toCharArray(), length);

        System.out.println(sequence);
    }

    public static int findLCS(String input1, String input2){
        char[] input1Array = input1.toCharArray();
        char[] input2Array = input2.toCharArray();
        return findLCS(input1Array, input2Array, 0,0);
    }

    private static void getSequence(char[] input1Array, char[] input2Array, int length){
        int i=0, j=0;
        boolean verticalHit=false;

        while (length>0){
            if (memo[i][j] == length && !verticalHit){
                if (i==input1Array.length-1){
                    verticalHit = true;
                }
                else {
                    i++;
                }
            }
            if (memo[i][j] != length && !verticalHit){
                i--;
                verticalHit = true;
            }
            if (memo[i][j] == length && verticalHit){
                if (j==input2Array.length-1){
                    sequence.append(input1Array[i]);
                    break;
                }
                else {
                    j++;
                }
            }
            if ((memo[i][j] != length && verticalHit)){
                //System.out.println(input1Array[i]);
                sequence.append(input1Array[i]);
                length--;
                verticalHit=false;
            }
        }
    }

    private static int findLCS(char[] input1Array, char[] input2Array, int index1, int index2){
        int length;

        if (index1 == input1Array.length || index2 == input2Array.length){
            return 0;
        }

        if (memo[index1][index2] != null){
            return memo[index1][index2];
        }

        //if same, check next of both
        if(input1Array[index1] == input2Array[index2]){
            //System.out.print(input1Array[index1]);
            length = findLCS(input1Array, input2Array, index1+1, index2+1)+1;
        }
        else {
            length = Math.max(findLCS(input1Array, input2Array, index1+1, index2),
                    findLCS(input1Array, input2Array, index1, index2+1));
        }

        memo[index1][index2] = length;

        return length;
    }
}
