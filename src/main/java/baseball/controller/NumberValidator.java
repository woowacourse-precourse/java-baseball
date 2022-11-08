package baseball.controller;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberValidator {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final String WRONG_LENGTH_INPUT_MESSAGE = "숫자 세 자리를 입력해주세요.";
    private static final String WRONG_RANGE_INPUT_MESSAGE = "1 ~ 9 사이의 숫자만 입력 가능합니다.";
    private static final String DUPLICATE_NUMBER_INPUT_MESSAGE = "서로 다른 세 자리의 숫자만 입력 가능합니다.";
    private static final char BASEBALL_GAME_START_NUMBER_CHAR = '1';
    private static final char BASEBALL_GAME_END_NUMBER_CHAR = '9';

    public int[] toValidateData(String inputNumber) {
        if (!isTreeLetters(inputNumber)) {
            throw new IllegalArgumentException(WRONG_LENGTH_INPUT_MESSAGE);
        } else if (!isNumericString(inputNumber)) {
            throw new IllegalArgumentException(WRONG_RANGE_INPUT_MESSAGE);
        } else if (!isDifferentCharacters(inputNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_INPUT_MESSAGE);
        }

        return convertStringToIntArray(inputNumber);
    }

    public boolean isTreeLetters(String inputNumber) {
        return inputNumber.length() == BASEBALL_GAME_NUMBER_LENGTH;
    }

    public boolean isNumericString(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (!isBetween1And9(inputNumber.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private boolean isBetween1And9(char checkChar) {
        return checkChar >= BASEBALL_GAME_START_NUMBER_CHAR && checkChar <= BASEBALL_GAME_END_NUMBER_CHAR;
    }

    public boolean isDifferentCharacters(String inputNumber) {
        String[] numbers = inputNumber.split("");
        Set<String> setNumbers = Arrays.stream(numbers).collect(Collectors.toSet());

        return setNumbers.size() == BASEBALL_GAME_NUMBER_LENGTH;
    }

    public int[] convertStringToIntArray(String inputNumber) {
        return Stream.of(inputNumber.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
