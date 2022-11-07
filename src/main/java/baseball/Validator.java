package baseball;

import java.util.List;

public class Validator {
    public static boolean checkUserNumException(List<Integer> inputNumberList) {
        return checkLength(inputNumberList)
                && checkNumberRange(inputNumberList)
                && checkDuplicateNumber(inputNumberList);
    }

    public static boolean checkLength(List<Integer> inputNumberList) {
        return inputNumberList.size() == GameConstants.NUMBER_LENGTH;
    }

    public static boolean checkNumberRange(List<Integer> inputNumberList) {
        return inputNumberList.stream()
                .filter(number -> GameConstants.MIN_NUMBER <= number && number <= GameConstants.MAX_NUMBER)
                .count() == GameConstants.NUMBER_LENGTH;
    }

    public static boolean checkDuplicateNumber(List<Integer> inputNumberList) {
        return inputNumberList.stream()
                .distinct()
                .count() == GameConstants.NUMBER_LENGTH;
    }

    public static boolean checkRestartException(String restart) {
        return restart.equals(GameConstants.RESTART) || restart.equals(GameConstants.QUIT);
    }
}