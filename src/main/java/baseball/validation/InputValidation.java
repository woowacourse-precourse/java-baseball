package baseball.validation;

public class InputValidation {
    public static boolean isThreeLength(String input) {
        return input.length() == 3;
    }

    public static boolean isNumber(String input) {
        return input.matches("^[1-9]+$");
    }

    public static boolean isDuplicate(String input) {
        return input.matches("^.(.)\\1$")
                || input.matches("^(.)\\1.$")
                || input.matches("^(.).\\1$");
    }
}
