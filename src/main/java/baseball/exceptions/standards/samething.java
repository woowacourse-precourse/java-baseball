package baseball.exceptions.standards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class samething {
    private static int index = 0;
    private static int value = 0;
    public static boolean isSame(List<Integer> number){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        for(int i = 0 ; i< number.size();i++){
            if(numbers.contains(number.get(i))){
                value = number.get(i);
                index = numbers.indexOf(value);
                numbers.remove(index);
                continue;
            }
            return true;
        }
        return false;
    }
}
