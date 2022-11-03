package baseball.utils;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.resources.GameConfig.PATTERN;
import static baseball.resources.GameConfig.SIZE;
import static baseball.resources.Sentence.EXCEPTION;
import static baseball.resources.Sentence.throwException;

public class InputNumberValidator {
    public static void validate(String inputNumber){
        validateThreeLength(inputNumber);
        validateDuplicate(inputNumber);
    }

    private static void validateThreeLength(String inputNumber) {
        if (!inputNumber.matches(PATTERN)) {
            throwException(EXCEPTION);
        }
    }

    private static void validateDuplicate(String inputNumber) {
        Set<Character> inputNumbers = IntStream.range(0, inputNumber.length())
                .mapToObj(inputNumber::charAt)
                .collect(Collectors.toSet());

        if (inputNumbers.size() < SIZE) {
            throwException(EXCEPTION);
        }
    }
}
