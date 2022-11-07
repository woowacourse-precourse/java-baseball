package baseball.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    public static void checkUserAnswerInput(String userAnswer) {
        checkStringLength(userAnswer, 3);
        checkNumber(userAnswer);
        checkDuplicated(userAnswer);
    }

    public static void checkUserFinishInput(String userInput) {
        if (!Objects.equals(userInput, "1") && !Objects.equals(userInput, "2")) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkStringLength(String string, int length) {
        if (string.length() != length) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumber(String string) {
        boolean isNumber = Pattern.matches("^[1-9]*$", string);
        if (!isNumber) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicated(String string) {
        String[] strings = string.split("");
        Set<String> uniqueValues = new HashSet<>(List.of(strings));
        if (strings.length != uniqueValues.size()) {
            throw new IllegalArgumentException();
        }
    }
}
