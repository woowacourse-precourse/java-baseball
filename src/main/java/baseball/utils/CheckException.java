package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class CheckException {
    public static List<Integer> checkUserInput(String input) throws IllegalArgumentException {
        List<Integer> returnInput = new ArrayList<>();

        checkInputSize(input);
        for (int i = 0; i < input.length(); i++) {
            checkInputBoundary(input.charAt(i));
            int convertedNumber = Character.getNumericValue(input.charAt(i));
            if (!checkDuplicate(returnInput, convertedNumber)) {
                returnInput.add(convertedNumber);
            }
        }
        return returnInput;
    }

    private static void checkInputSize(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkInputBoundary(char c) throws IllegalArgumentException {
        if (c < '1' || c > '9') {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkDuplicate(List<Integer> list, int num) throws IllegalArgumentException {
        if (list.contains(num)) {
            throw new IllegalArgumentException();
        }
        return false;
    }
}
