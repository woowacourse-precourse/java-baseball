package baseball.validator;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.Const.*;

public class NumberValidator {

    public static void validate(String checkNumber) {
        checkNumberCondition(checkNumber);
        checkSize(checkNumber);
        checkUnique(checkNumber);
    }

    public static void checkSize(String checkNumber) throws IllegalArgumentException {
        if (checkNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력 숫자의 크기(길이)를 확인하세요.");
        }
    }

    public static void checkUnique(String checkNumber) throws IllegalArgumentException {
        List<Character> characterList = new ArrayList<>();

        for (int i = 0; i < checkNumber.length(); i++) {
            char currentChar = checkNumber.charAt(i);
            if (characterList.contains(currentChar)) {
                throw new IllegalArgumentException("각 자리수는 중복을 허락하지 않습니다.");
            }
            characterList.add(currentChar);
        }
    }

    public static void checkNumberCondition(String checkNumber) throws IllegalArgumentException {
        for (int i = 0; i < checkNumber.length(); i++) {
            if (isNumberWrongCondition(convertCharToInt(checkNumber.charAt(i)))) {
                throw new IllegalArgumentException("1~9 까지의 수 조건에 충족하지 않습니다.");
            }
        }
    }

    private static int convertCharToInt(char currentChar) {
        return currentChar - '0';
    }

    private static boolean isNumberWrongCondition(int currentNumber) {
        return (currentNumber < NUMBER_MIN_VALUE || currentNumber > NUMBER_MAX_VALUE);
    }

    public static void checkRetryNumber(String retryNumber) {
        if (isNotRetryOrExit(retryNumber)) {
            throw new IllegalArgumentException("게임 재시작 여부는 1또는 2 숫자만 가능합니다.");
        }
    }

    private static boolean isNotRetryOrExit(String retryNumber) {
        return !(retryNumber.equals(RETRY) || retryNumber.equals(EXIT));
    }
}
