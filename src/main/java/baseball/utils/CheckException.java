package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class CheckException {
    public static List<Integer> checkUserInput(String input) throws IllegalArgumentException {
        List<Integer> returnInput = new ArrayList<>();

        checkInputSize(input);
        for (int i = 0; i < input.length(); i++) {
            checkInputBoundary(input.charAt(i));
            returnInput.add(Character.getNumericValue(input.charAt(i)));
        }
        return returnInput;
    }

    private static void checkInputSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkInputBoundary(char c) {
        if (c < '0' || c > '9') {
            throw new IllegalArgumentException();
        }
    }
}
