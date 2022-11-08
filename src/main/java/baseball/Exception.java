package baseball;

public class Exception {
    public static void hasCharacters(String input) {
        String regex = "^[0-9]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    public static void isNumberOutOfRange(String input) {
        String regex = "^[1-9]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}

class PlayerNumbersException extends Exception {
    final static int NUMBER_LENGTH = 3;

    public static void verify(String playerNumbers) {
        verifyLength(playerNumbers);
        verifyUniqueness(playerNumbers);
        hasCharacters(playerNumbers);
        isNumberOutOfRange(playerNumbers);
    }

    private static void verifyLength(String playerNumbers) {
        if (playerNumbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void verifyUniqueness(String playerNumbers) {
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (playerNumbers.lastIndexOf(playerNumbers.charAt(stringIndex)) != stringIndex) {
                throw new IllegalArgumentException();
            }
        }
    }
}

class GameRepeatInputException extends Exception {
    final static Integer NUMBER_LENGTH = 1;
    final static String RESTART_GAME = "1";
    final static String QUIT_GAME = "2";

    public static void verify(String restartOption) {
        verifyLength(restartOption);
        hasCharacters(restartOption);
        verifyRange(restartOption);
    }

    public static void verifyLength(String restartOption) {
        if (restartOption.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("exception occurs at checkInputLength()");
        }
    }

    public static void verifyRange(String restartOption) {
        if (!restartOption.contains(RESTART_GAME) && !restartOption.contains(QUIT_GAME)) {
            throw new IllegalArgumentException("exception occurs at checkYesOrNo()");
        }
    }
}
