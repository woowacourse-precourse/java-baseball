package baseball.utils;

import java.util.HashSet;
import java.util.Set;

import static baseball.resources.GameConfig.PATTERN;
import static baseball.resources.GameConfig.SIZE;
import static baseball.resources.Sentence.EXCEPTION;
import static baseball.resources.Sentence.throwException;

public class InputNumberValidator {
    public void validate(String inputNumber){
        validateThreeLength(inputNumber);
        validateDuplicate(inputNumber);
    }

    private void validateThreeLength(String inputNumber) {
        if (!inputNumber.matches(PATTERN)) {
            throwException(EXCEPTION);
        }
    }

    private void validateDuplicate(String inputNumber) {
        Set<Character> inputNumbers = new HashSet<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            inputNumbers.add(inputNumber.charAt(i));
        }

        if (inputNumbers.size() < SIZE) {
            throwException(EXCEPTION);
        }
    }
}
