package baseball.game.utils;

import java.util.ArrayList;
import java.util.List;

import static baseball.game.config.constants.GameRule.*;
import static baseball.game.config.constants.IntegerValidatorMessage.*;

public class IntegerValidator {

    public static void validatePresume(List<Integer> numbers) {
        checkPresumeSize(numbers);
        checkDuplicatedNumber(numbers);

        for (int number : numbers) {
            checkNumberInRange(number);
        }
    }

    public static void validateRestartChoice(int input) {
        if (!RESTART_CHOICE_OPTION.contains(input)) {
            throw new IllegalArgumentException(NOT_IN_OPTION);
        }
    }

    private static void checkPresumeSize(List<Integer> numbers) {
        if (numbers.size() != GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException(GAME_NUMBER_SIZE + SIZE_ERROR);
        }
    }

    private static void checkDuplicatedNumber(List<Integer> numbers) {
        List<Integer> checkedList = new ArrayList<>();

        for (int number : numbers) {
            checkContainNumber(checkedList, number);
            checkedList.add(number);
        }
    }

    private static void checkContainNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(FORBID_DUPLICATED);
        }
    }

    private static void checkNumberInRange(int number) {
        if (number < START_INCLUSIVE_INTEGER || number > END_INCLUSIVE_INTEGER) {
            throw new IllegalArgumentException(
                    START_INCLUSIVE_INTEGER + "~" + END_INCLUSIVE_INTEGER + "사이의 숫자만 입력할 수 있습니다.");
        }
    }

}
