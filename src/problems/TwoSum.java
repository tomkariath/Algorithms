package problems;

import java.util.HashMap;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
    	int[] returnArray = new int[2];
    	HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();
    	temp.put(list[0],0);
    	
    	for (int i = 1; i < list.length; i++) {
    		if (temp.get(sum - list[i]) == null) {
    			temp.put(list[i], i);
    		}
    		else {
    			returnArray[0] = i;
    			returnArray[1] = temp.get(sum - list[i]);
    			return returnArray;
    		}
    	}
    	
    	return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
