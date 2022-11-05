package baseball.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static boolean hasDuplicatedChar(String target) {
        String[] targetArray = target.split("");
        Set<String> targetSet = new HashSet<>(Arrays.asList(targetArray));
        return targetSet.size() != target.length();
    }

}
