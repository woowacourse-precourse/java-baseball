package baseball;

import java.util.ArrayList;
import java.util.List;

public class Change {
    public static List<Integer> numberToList(int number){
        List<Integer> newList = new ArrayList<>();
        String string = String.valueOf(number);
        for (int i = 0; i<string.length(); i++){
            newList.add(string.charAt(i) - '0');
        }
        return newList;
    }
}
