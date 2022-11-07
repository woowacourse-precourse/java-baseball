package baseball;

import java.util.List;

import static baseball.GameConstants.*;

public class Validator {
    public static boolean checkUserNumException(List<Integer> inputNumberList) {
        return checkLength(inputNumberList)
                && checkNumberRange(inputNumberList)
                && checkDuplicateNumber(inputNumberList);
    }

    public static boolean checkLength(List<Integer> inputNumberList) {
        return inputNumberList.size() == NUMBER_LENGTH;
    }

    public static boolean checkNumberRange(List<Integer> inputNumberList) {
        return inputNumberList.stream()
                .filter(number -> MIN_NUMBER <= number && number <= MAX_NUMBER)
                .count() == NUMBER_LENGTH;
    }

    public static boolean checkDuplicateNumber(List<Integer> inputNumberList) {
        return inputNumberList.stream()
                .distinct()
                .count() == NUMBER_LENGTH;
    }

    public static boolean checkRestartException(String restart) {
        return restart.equals(RESTART) || restart.equals(QUIT);
    }
}