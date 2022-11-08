package baseball;

import static baseball.Constants.MAX_NUMBER;
import static baseball.Constants.MIN_NUMBER;
import static baseball.Constants.NUMBER_LENGTH;
import static baseball.Constants.RESTART;
import static baseball.Constants.STOP;
import static java.lang.String.format;

import java.util.HashMap;
import java.util.Map;

public class InputValidation {
    static final String LENGTH_ERROR = NUMBER_LENGTH + "자리 수를 입력해야 합니다.";
    static final String NUMBER_RANGE_ERROR = format("%s부터 %s까지의 수를 입력해야 합니다.", MIN_NUMBER, MAX_NUMBER);
    static final String DUPLICATION_ERROR = "각 자리의 수가 서로 달라야 합니다.";
    static final String CHOICE_ERROR = RESTART + " 또는 " + STOP + "를 입력해야 합니다.";

    public String validatePlayerNumbersInput(String input) {
        validateLength(input);
        validateNumberRange(input);
        validateDuplication(input);

        return input;
    }

    public String validateRestartInput(String input) {
        validateChoice(input);

        return input;
    }

    private void validateLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR);
        }
    }

    private void validateNumberRange(String input) {
        char[] chars = input.toCharArray();

        for (char letter : chars) {
            if (!('1' <= letter && letter <= '9')) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
            }
        }
    }

    private void validateDuplication(String input) {
        Map<String, Integer> map = new HashMap<>();

        for (String letter : input.split("")) {
            map.put(letter, map.getOrDefault(letter, 0) + 1);

            if (map.get(letter) >= 2) {
                throw new IllegalArgumentException(DUPLICATION_ERROR);
            }
        }
    }

    private void validateChoice(String input) {
        if (!(input.equals(RESTART) || input.equals(STOP))) {
            throw new IllegalArgumentException(CHOICE_ERROR);
        }
    }
}
