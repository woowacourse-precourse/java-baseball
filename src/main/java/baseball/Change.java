package baseball;

import java.util.ArrayList;
import java.util.List;

public class Change {
    public static List<Integer> numberToList(String number) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            newList.add(number.charAt(i) - '0');
        }
        return newList;
    }
}
