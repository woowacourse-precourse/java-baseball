package baseball;

public class InputChecker {

    private static boolean hasLengthOf(String input, int length) {
        return input.length() == length;
    }

    private static boolean hasDigitsOnly(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    public static void isGuessCommandValid(String input, int length) {
        if (!hasDigitsOnly(input) || !hasLengthOf(input, length)) {
            throw new IllegalArgumentException();
        }
    }

}
