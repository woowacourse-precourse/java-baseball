package baseball;

public class InputChecker {

    private static boolean hasLengthOf(String input, int length) {
        return input.length() == length;
    }

    private static boolean hasDigitsOnly(String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

}
