package baseball.model;

import baseball.util.DuplicateChecker;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final String INPUT_THREE_NUMBERS = "3자리의 숫자를 입력해주세요.";
    public static final String CANNOT_INPUT_ZERO = "숫자 0은 입력할 수 없습니다.";
    public static final int MAX_INPUT_LENGTH = 3;

    private List<Integer> answer = new ArrayList<>();

    public List<Integer> input() {
        String input = Console.readLine();
        validateInput(input);
        answer = inputToNumbers(input);
        return answer;
    }

    private void validateInput(String input) {
        isThreeWords(input);
        hasZero(input);
        DuplicateChecker.hasSameNumber(input);
    }

    private void isThreeWords(String input) {
        if (isDifferentLength(input)) {
            throw new IllegalArgumentException(INPUT_THREE_NUMBERS);
        }
    }

    private boolean isDifferentLength(String input) {
        return input.length() != MAX_INPUT_LENGTH;
    }

    private void hasZero(String input) {
        for (int index = 0; index < MAX_INPUT_LENGTH; index++) {
            ifZeroThrowException(input, index);
        }
    }

    private void ifZeroThrowException(String input, int index) {
        if (isZero(input, index)) {
            throw new IllegalArgumentException(CANNOT_INPUT_ZERO);
        }
    }

    private boolean isZero(String input, int index) {
        return input.charAt(index) == 0;
    }

    private List<Integer> inputToNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (int index = 0; index < input.length(); index++) {
            int number = inputToInt(input, index);
            numbers.add(number);
        }

        return numbers;
    }

    private int inputToInt(String input, int index) {
        return input.charAt(index) - '0';
    }
}
