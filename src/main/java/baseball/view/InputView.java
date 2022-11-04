package baseball.view;

import baseball.RandomUtil;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String EXCEPTION_PREFIX = "[ERROR] : ";
    private static final String INPUT_NUMBER_IS_NOT_DIGIT_EXCEPTION = "입력하는 수는 숫자여야합니다.";
    private static final String INPUT_NUMBER_LENGTH_EXCEPTION = "입력하는 수는 3자리여야합니다.";
    private static final String INPUT_NUMBER_CONTAIN_ZERO_EXCEPTION = "입력하는 수는 0이 포함될 수 없습니다. 1~9까지의 수를 입력해주세요.";
    private static final String INPUT_NUMBER_EACH_DIGIT_DUPLICATE_EXCEPTION = "입력하는 수는 서로 다른 수여야합니다. ";
    private static final String RESTART_OR_END_NUMBER_NOT_ONE_OR_TWO_EXCEPTION = "재시작 또는 종료 Number는 1, 2입니다. 그 외는 입력할 수 없습니다.";
    private static final int INPUT_NUMBER_CORRECT_LENGTH = 3;
    private static final String INPUT_NUMBER_CORRECT_TYPE = "^[0-9]*$";
    private static final String ZERO_STRING_VALUE = "0";
    private static final String EACH_DIGIT_SPLIT_REGEX = "";
    private static final String ONE_STRING_VALUE = "1";
    private static final String TWO_STRING_VALUE = "2";

    public static String inputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String inputNumber = Console.readLine();
        validateInputNumber(inputNumber);
        return inputNumber;
    }

    public static String inputRestartOrEndNumber() {
        String inputRestartOrEndNumber = Console.readLine();
        validateInputRestartOrEndNumber(inputRestartOrEndNumber);
        return inputRestartOrEndNumber;
    }

    private static void validateInputNumber(String inputNumber) {
        if (isInputNumberNotDigit(inputNumber)) {
            throw new IllegalArgumentException(EXCEPTION_PREFIX + INPUT_NUMBER_IS_NOT_DIGIT_EXCEPTION);
        }
        if (isInputNumberLengthNotSameThree(inputNumber)) {
            throw new IllegalArgumentException(EXCEPTION_PREFIX + INPUT_NUMBER_LENGTH_EXCEPTION);
        }
        if (isInputNumberContainZero(inputNumber)) {
            throw new IllegalArgumentException(EXCEPTION_PREFIX + INPUT_NUMBER_CONTAIN_ZERO_EXCEPTION);
        }
        if (isDuplicateInputNumber(inputNumber)) {
            throw new IllegalArgumentException(EXCEPTION_PREFIX + INPUT_NUMBER_EACH_DIGIT_DUPLICATE_EXCEPTION);
        }
    }

    private static void validateInputRestartOrEndNumber(String inputRestartOrEndNumber) {
        if (isInputRestartOrEndNumberNotOneOrTwo(inputRestartOrEndNumber)) {
            throw new IllegalArgumentException(EXCEPTION_PREFIX + RESTART_OR_END_NUMBER_NOT_ONE_OR_TWO_EXCEPTION);
        }
    }

    private static boolean isInputNumberLengthNotSameThree(String inputNumber) {
        return inputNumber.length() != INPUT_NUMBER_CORRECT_LENGTH;
    }

    private static boolean isInputNumberNotDigit(String inputNumber) {
        return !inputNumber.matches(INPUT_NUMBER_CORRECT_TYPE);
    }

    private static boolean isInputNumberContainZero(String inputNumber) {
        return inputNumber.contains(ZERO_STRING_VALUE);
    }

    private static boolean isDuplicateInputNumber(String InputNumber) {
        List<String> inputNumberEachDigitList = Arrays.asList(InputNumber.split(EACH_DIGIT_SPLIT_REGEX));
        Set<String> inputNumberEachDigitSet = new HashSet<>(inputNumberEachDigitList);
        return inputNumberEachDigitSet.size() != INPUT_NUMBER_CORRECT_LENGTH;
    }

    private static boolean isInputRestartOrEndNumberNotOneOrTwo(String inputRestartOrEndNumber) {
        return (!inputRestartOrEndNumber.equals(ONE_STRING_VALUE) && !inputRestartOrEndNumber.equals(TWO_STRING_VALUE));
    }
}
