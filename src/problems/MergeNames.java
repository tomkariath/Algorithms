package problems;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
    	SortedSet<String> set = new TreeSet<String>(Arrays.asList(names1));
    	set.addAll(Arrays.asList(names2));
    	
    	return set.toArray(new String[0]);
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}