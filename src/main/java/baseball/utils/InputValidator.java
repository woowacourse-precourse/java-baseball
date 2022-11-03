package baseball.utils;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.resources.GameConfig.*;
import static baseball.resources.Sentence.EXCEPTION;
import static baseball.utils.SentencePrint.cause;

public class InputValidator {
    public static void validate(String input){
        validateThreeLength(input);
        validateDuplicate(input);
    }

    private static void validateThreeLength(String input) {
        if (!input.matches(PATTERN)) {
            cause(EXCEPTION);
        }
    }

    private static void validateDuplicate(String input) {
        Set<Character> inputNumber = IntStream.range(0, input.length())
                .mapToObj(input::charAt)
                .collect(Collectors.toSet());

        if (inputNumber.size() < SIZE) {
            cause(EXCEPTION);
        }
    }
}
