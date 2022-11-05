package baseball;

public final class Validator {

    public static void isVaildNumber(String userNumber, int digit) throws IllegalArgumentException {
        if (userNumber.length() != digit) {
            throw new IllegalArgumentException();
        }

        if (userNumber.contains("0")) {
            throw new IllegalArgumentException();
        }

        if (isDuplicated(userNumber, digit)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isRestartCommand(int command) throws IllegalArgumentException {
        if (command == 1 || command == 2) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private static boolean isDuplicated(String userNumber, int digit) {
        return userNumber.chars()
                .distinct()
                .count() < digit;
    }

}
