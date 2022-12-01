package exceptions;

public class GameCommandException extends Exception {
    final static Integer NUMBER_LENGTH = 1;
    final static String RESTART_GAME = "1";
    final static String QUIT_GAME = "2";

    public static void validate(String restartOption) {
        validateCommonException(restartOption);
        validateLength(restartOption);
        validateRange(restartOption);
    }

    private static void validateLength(String restartOption) {
        if (restartOption.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(String restartOption) {
        if (!restartOption.contains(RESTART_GAME) && !restartOption.contains(QUIT_GAME)) {
            throw new IllegalArgumentException();
        }
    }
}
