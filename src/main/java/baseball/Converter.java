package baseball;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List stringToList(String input) {
        List numberList = new ArrayList();
        for(char c : input.toCharArray()) {
            numberList.add(Character.getNumericValue(c));
        }
        return numberList;
    }
}
