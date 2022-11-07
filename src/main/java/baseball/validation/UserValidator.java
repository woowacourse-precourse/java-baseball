package baseball.validation;

public class UserValidator {

    public static boolean restartValidation(String input) {
        return isLengthOne(input) && isOneOrTwo(input);
    }

    private static boolean isLengthOne(String input) {
        return input.length() == 1;
    }

    private static boolean isOneOrTwo(String input) {
        int restartNumber = input.charAt(0) - '0';

        return restartNumber == 1 || restartNumber == 2;
    }
}
