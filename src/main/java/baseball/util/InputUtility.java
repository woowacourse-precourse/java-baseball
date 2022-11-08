package baseball.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputUtility {

    private static void isValidProcess(String input) {
        List<String> validProcess = Arrays.asList("1", "2");
        if (!validProcess.contains(input)) {
            throw new IllegalArgumentException("유효하지 않은 문자입니다.");
        }
    }

    private static boolean isDuplicated(String input) {
        String deduplicatedInput = String.join("", new HashSet<>(List.of(input.split(""))));
        return deduplicatedInput.length() != input.length();
    }

    private static boolean isNaturalNumber(String input) {
        return input.matches("[1-9]+");
    }


}
