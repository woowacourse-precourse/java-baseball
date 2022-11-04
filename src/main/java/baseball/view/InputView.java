package baseball.view;

import baseball.RandomUtil;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public static String inputNumber() {
        String inputNumber = Console.readLine();
        validateInputNumber(inputNumber);
        return inputNumber;
    }

    private static void validateInputNumber(String inputNumber) {
        if (isInputNumberNotDigit(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] : 입력하는 수는 숫자여야합니다.");
        }
        if (isInputNumberLengthNotSame3(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] : 입력하는 수는 3자리여야합니다.");
        }
        if (isInputNumberContainZero(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] : 입력하는 수는 0이 포함될 수 없습니다. 1~9까지의 수를 입력해주세요.");
        }
        if (isDuplicateInputNumber(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] : 입력하는 수는 서로 다른 수여야합니다.");
        }
    }

    private static boolean isInputNumberLengthNotSame3(String inputNumber) {
        return inputNumber.length() != 3;
    }

    private static boolean isInputNumberNotDigit(String inputNumber) {
        return !inputNumber.matches("^[0-9]*$");
    }

    private static boolean isInputNumberContainZero(String inputNumber) {
        return inputNumber.contains("0");
    }

    private static boolean isDuplicateInputNumber(String InputNumber) {
        List<String> inputNumberEachDigitList = Arrays.asList(InputNumber.split(""));
        Set<String> inputNumberEachDigitSet = new HashSet<>(inputNumberEachDigitList);
        return inputNumberEachDigitSet.size() != 3;
    }
}
