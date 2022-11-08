package baseball;

import java.util.ArrayList;
import java.util.List;

public class ValidCheck {


    public static boolean checkIsContinueError(Integer toBeContinue) {
        if (toBeContinue != ReferenceValue.AGAIN && toBeContinue != ReferenceValue.EXIT) {
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

        for (int i = 0; i < ReferenceValue.SIZE; i++) {
            char value = input.charAt(i);
            int number = Character.getNumericValue(value);

            boolean rangeCheck = (number >= ReferenceValue.START_RANGE) && (number <= ReferenceValue.END_RANGE);

            if (!rangeCheck) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSizeError(String input) {
        int size = input.length();

        if (size != ReferenceValue.SIZE) {
            return true;
        }

        return false;
    }

    public static boolean checkVisitedError(String input) {
        List<Integer> visitedList = new ArrayList<>();

        for (int i = 0; i < ReferenceValue.SIZE; i++) {
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
