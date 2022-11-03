package baseball.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class NumberScanner {

    public String inputNumber() {
        String inputValue = readLine();
        validateInputValue(inputValue);

        return inputValue;
    }

    public int inputOneOrTwo() {
        String inputValue = readLine();
        validateOneOrTwo(inputValue);

        return Integer.parseInt(inputValue);
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    private void validateInputValue(String inputValue) {
        validateItIsNumber(inputValue);
        validatePositiveNumber(inputValue);
        validateLengthForGame(inputValue);
        validateContainsZero(inputValue);
        validateDuplicate(inputValue);
    }

    private void validateItIsNumber(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    private void validatePositiveNumber(String inputValue) {
        if (inputValue.contains("-")) {
            throw new IllegalArgumentException("양수만 입력해 주세요.");
        }
    }

    private void validateLengthForGame(String inputValue) {
        int length = inputValue.length();
        final int digit = 3;

        if (length != digit) {
            throw new IllegalArgumentException("세 자리의 숫자를 입력해 주세요.");
        }
    }

    private void validateContainsZero(String inputValue) {
        if (inputValue.contains("0")) {
            throw new IllegalArgumentException("0은 포함될 수 없습니다. 다시 입력해 주세요.");
        }
    }

    private void validateDuplicate(String inputValue) {
        long count = IntStream.range(0, 3)
                .mapToObj(inputValue::charAt)
                .distinct()
                .count();

        if (count < 3) {
            throw new IllegalArgumentException("중복 숫자는 입력할 수 없습니다.");
        }
    }

    private void validateOneOrTwo(String inputValue) {
        if (!(inputValue.equals("1") || inputValue.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요. (게임 재시작 : 1 / 게임 종료 : 2)");
        }
    }

}
