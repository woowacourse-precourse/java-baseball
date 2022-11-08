package baseball;

import java.util.List;

public class Validator {
    public static boolean checkUserNumException(List<Integer> inputNumberList) {
        return checkLength(inputNumberList)
                && checkNumberRange(inputNumberList)
                && checkDuplicateNumber(inputNumberList);
    }

    public static boolean checkLength(List<Integer> inputNumberList) {
        return inputNumberList.size() == Constants.NUMBER_LENGTH;
    }

    public static boolean checkNumberRange(List<Integer> inputNumberList) {
        return inputNumberList.stream()
                .filter(number -> Constants.MIN_NUMBER <= number && number <= Constants.MAX_NUMBER)
                .count() == Constants.NUMBER_LENGTH;
    }

    public static boolean checkDuplicateNumber(List<Integer> inputNumberList) {
        return inputNumberList.stream()
                .distinct()
                .count() == Constants.NUMBER_LENGTH;
    }

    public static boolean checkRestartException(String restart) {
        return restart.equals(Constants.RESTART) || restart.equals(Constants.QUIT);
    }
}