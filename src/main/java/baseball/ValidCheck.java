package baseball;

import java.util.ArrayList;
import java.util.List;

public class ValidCheck {
    private static final int TOTAL_SIZE = 3;
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int AGAIN = 1;
    private static final int EXIT = 2;

    public static boolean checkIsContinueError(int toBeContinue) {
        if (toBeContinue != AGAIN && toBeContinue != EXIT) {
            return true;
        }
        return false;
    }

    public static boolean checkIsNumberError(String input) {
        try {
            int value = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public static boolean checkRangeError(String input) {

        for (int i = 0; i < TOTAL_SIZE; i++) {
            char value = input.charAt(i);
            int number = Character.getNumericValue(value);

            boolean rangeCheck = (number >= START_RANGE) && (number <= END_RANGE);

            if (!rangeCheck) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSizeError(String input) {
        int size = input.length();

        if (size != TOTAL_SIZE) {
            return true;
        }

        return false;
    }

    public static boolean checkVisitedError(String input) {
        List<Integer> visitedList = new ArrayList<>();

        for (int i = 0; i < TOTAL_SIZE; i++) {
            char value = input.charAt(i);
            int number = Character.getNumericValue(value);

            if (visitedList.contains(number)) {
                return true;
            }

            visitedList.add(number);
        }

        return false;
    }

}
