package baseball;

import java.util.HashSet;
import java.util.Set;

public class ValidateGameComponent {
    public static boolean validNumberLength(String baseballNumber) {
        if (baseballNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean validNumberOutRange(String baseballNumber) {
        char[] userInputList = baseballNumber.toCharArray();
        for (char userChar : userInputList) {
            if (userChar < '1' || userChar > '9') {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public static boolean validNumberDuplicate(String baseballNumber) {
        Set<Character> userInputCharHashSet = new HashSet<>();
        for (int i = 0; i < baseballNumber.length(); i++) {
            userInputCharHashSet.add(baseballNumber.charAt(i));
        }
        if (userInputCharHashSet.size() != 3) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
