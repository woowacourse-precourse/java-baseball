package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumber {
    private final List<Integer> listNumber;

    BaseballNumber(int number) {
        listNumber = splitDigitsIntoList(number);
    }

    public static ArrayList<Integer> splitDigitsIntoList(int number) {
        ArrayList<Integer> resultList = new ArrayList<>();
        String stringNumber = Integer.toString(number);
        for (int i = 0; i < stringNumber.length(); i++) {
            char charDigit = stringNumber.charAt(i);
            resultList.add(Character.getNumericValue(charDigit));
        }
        return resultList;
    }
}
