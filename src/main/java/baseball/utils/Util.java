package baseball.utils;

import java.util.ArrayList;

public final class Util {
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
