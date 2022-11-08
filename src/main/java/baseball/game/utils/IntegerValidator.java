package baseball.game.utils;

import java.util.ArrayList;
import java.util.List;

public class IntegerValidator {

    private static final int GAME_NUMBER_SIZE = 3;

    private static final int START_INCLUSIVE_INTEGER = 1;
    private static final int END_INCLUSIVE_INTEGER = 9;

    private static final List<Integer> RESTART_CHOICE_OPTION = List.of(1, 2);

    public static void validatePresume(List<Integer> numbers) {
        checkPresumeSize(numbers);
        checkDuplicatedNumber(numbers);

        for (int number : numbers) {
            checkNumberInRange(number);
        }
    }

    public static void validateRestartChoice(int input) {
        if (!RESTART_CHOICE_OPTION.contains(input)) {
            throw new IllegalArgumentException("선택 옵션에 없는 숫자입니다.");
        }
    }

    private static void checkPresumeSize(List<Integer> numbers) {
        if (numbers.size() != GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException(GAME_NUMBER_SIZE + "자리 숫자만 입력할 수 있습니다.");
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
            throw new IllegalArgumentException("중복된 숫자를 포함할 수 없습니다.");
        }
    }

    private static void checkNumberInRange(int number) {
        if (number < START_INCLUSIVE_INTEGER || number > END_INCLUSIVE_INTEGER) {
            throw new IllegalArgumentException(
                    START_INCLUSIVE_INTEGER + "~" + END_INCLUSIVE_INTEGER + "사이의 숫자만 입력할 수 있습니다.");
        }
    }

}
