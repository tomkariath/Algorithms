package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//You have a queue of integers, you need to retrieve the first unique integer in the queue.
public class FirstUniqueNumber {
    private final List<Integer> numbers;
    private boolean isArrayModified = false;

    Map<Integer, Boolean> isUnique;

    FirstUniqueNumber(List<Integer> numbers){
        this.numbers = numbers;
        isUnique = new HashMap<>();
    }

    int getFirstUniqueNumber(){
        int i=0;
        Boolean isElementUnique;
        while (i<numbers.size()){
            isElementUnique = isUnique.get(numbers.get(i));
            if(isElementUnique == null){
                return checkUniqueness(i);
            } else if (isElementUnique){
                return numbers.get(i);
            } else {
                i++;
            }
        }

        return -1;
    }

    void add (int value){
        numbers.add(value);

        if(isUnique.get(value) != null){ //value present
            isUnique.put(value, false);
        }

        isArrayModified = true;
    }

    void printFirstNumber(){
        System.out.println(getFirstUniqueNumber());
    }

    private int checkUniqueness(int i){
        int j = numbers.size()-1;
        Boolean isIUnique=null;

        while(i<j){
            isIUnique = isUnique.get(numbers.get(i));
            if(isIUnique!=null && isIUnique && isArrayModified){ //uniqueness verified during addition, so elements in between might not be checked yet
                i++;
                continue;
            }
            else if (isIUnique!=null && isIUnique){
                return numbers.get(i);
            }
            else if (isIUnique!=null){ //not Unique
                i++;
                continue;
            }

            if (numbers.get(i).equals(numbers.get(j))){
                isIUnique = false;
                isUnique.put(numbers.get(i), false);
                i++;
            }
            else {
                j--;
            }
        }

        if (isIUnique==null && i != numbers.size()-1){
            isUnique.put(numbers.get(i), true);
            return numbers.get(i);
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) {
        FirstUniqueNumber fun = new FirstUniqueNumber(new ArrayList<>(List.of(2, 3, 5)));
        fun.printFirstNumber();
        fun.add(5);
        fun.printFirstNumber();
        fun.add(2);
        fun.printFirstNumber();
        fun.add(3);
        fun.printFirstNumber();
    }
}
