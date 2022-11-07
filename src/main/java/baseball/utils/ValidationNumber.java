package baseball.utils;

import static baseball.utils.Constant.GAME_NUMBER_SIZE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ValidationNumber {

    public List<Integer> checkTotalAndConvertIntegerList(String number) {
        checkHaveZero(number);
        List<Integer> numberList = stringToIntegerList(number);
        checkOverlap(numberList);
        checkNumberSize(numberList);
        return numberList;
    }

    private List<Integer> stringToIntegerList(String number) {
        List<Integer> returnList = new ArrayList<>();
        String[] split = number.split("");
        for (String target : split) {
            returnList.add(stringToInt(target));
        }
        return returnList;
    }

    private int stringToInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionType.NOT_NUMBER.getMessage());
        }
    }

    private void checkHaveZero(String number) {
        String noZeroRegex = "^((?!0).)*$";
        if (!number.matches(noZeroRegex)) {
            throw new IllegalArgumentException(ExceptionType.HAVE_ZERO.getMessage());
        }
    }

    private void checkOverlap(List<Integer> number) {
        HashSet<Integer> numberSet = new HashSet<>(number);

        if (numberSet.size() != GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionType.HAVE_OVERLAP.getMessage());
        }
    }

    private void checkNumberSize(List<Integer> number) {
        if (number.size() != GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException(ExceptionType.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public void checkEndOrRestartNumber(String number) {
        String endOrRestartRegex = "^[1-2]$";

        if (!number.matches(endOrRestartRegex)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_NUMBER_END_OR_RESTART.getMessage());
        }
    }
}
