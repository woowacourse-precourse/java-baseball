package baseball;

import java.util.regex.Pattern;

public class Player {
    private static final String VALID_ANSWER_PATTERN = "[1-9][0-9][0-9]";
    private static final String VALID_CONTINUE_ANSWER_PATTERN = "[1-2]";
    public static Boolean isValidAnswer(String answer) {

        if (!Pattern.matches(VALID_ANSWER_PATTERN, answer)) {
            throw new IllegalArgumentException();
        }
        if (answer.charAt(0) == answer.charAt(1) ||
                answer.charAt(1) == answer.charAt(2) ||
                answer.charAt(0) == answer.charAt(2)) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    public static Boolean isValidContinueAnswer(String answer) {
        if (!Pattern.matches(VALID_CONTINUE_ANSWER_PATTERN, answer)) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
