package baseball.exception;

import java.util.List;

import static baseball.exception.ErrorMessage.*;

public class InputException extends IllegalArgumentException {
    private static final int RESTART = 1;
    private static final int STOP = 2;

    /**
     * 입력받은 문자중에 숫자가 아닌 문자가 포함시 예외를 던진다.
     *
     * @param inputNumbers 입력받은 숫자들
     */
    public void isDigitException(String inputNumbers) {
        char[] chars = inputNumbers.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(NOT_DIGIT.getMessage());
            }
        }
    }

    /**
     * 저장된 숫자 리스트에 중복 숫자가 있으면 예외를 던진다.
     *
     * @param number  저장할 숫자
     * @param numbers 저장된 숫자 리스트
     */
    public void isDuplicationNumberException(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATION_NUMBER.getMessage());
        }
    }

    /**
     * 입력받은 재시작/종료 코드가 RESTART 또는 STOP 가 아니면 예외를 던진다.
     *
     * @param code 재시작/종료 코드
     */
    public void isInvalidCode(int code) {
        if (code != RESTART && code != STOP) {
            throw new IllegalArgumentException(NOT_RUN_CODE.getMessage());
        }
    }

    /**
     * 입력받은 재시작/종료 코드의 크기가 1이 아니면 예외를 던진다.
     *
     * @param code 재시작/종료 코드
     */
    public void isInvalidCodeSize(String code) {
        if (code.length() != 1) {
            throw new IllegalArgumentException(INPUT_SIZE.getMessage());
        }
    }

    /**
     * 입력받은 숫자의 개수가 3이 아니면 예외를 던진다.
     *
     * @param numbers 입력받은 숫자의 개수
     */
    public void isInvalidNumbersSize(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException(INPUT_SIZE.getMessage());
        }
    }
}