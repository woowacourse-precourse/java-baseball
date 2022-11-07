package baseball.validatioon;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static baseball.Constants.*;

public class Validation {

    public static boolean isValidNumber(int number, List<Integer> lst) {
        if (number < NUMBER_RANGE_START || number > NUMBER_RANGE_END) {
            return false;
        }
        return !lst.contains(number);
    }

    public static void validateNumber(int number, List<Integer> lst) {
        if (number < NUMBER_RANGE_START || number > NUMBER_RANGE_END) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
        if (lst.contains(number)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER);
        }
    }

    public static void validateCharIsDigit(char c) {
        if (Character.isDigit(c)) {
            throw new IllegalArgumentException(NOT_A_NUMBER);
        }
    }

    public static void validateOption(int number) {
        if (number == RESTART_OPTION || number == END_OPTION) {
            throw new IllegalArgumentException(INVALID_OPTION);
        }
    }

    public static void validateSize(String input, int size) {
        if (input.length() != size) {
            throw new IllegalArgumentException(String.format("%d 사이즈의 입력이 아닙니다.", size));
        }
    }

    public static boolean isRestart(int restartOption) {
        return restartOption == RESTART_OPTION;
    }
}
