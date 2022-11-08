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

    public static void verify(String gamePlayerNumbers) {
        verifyLength(gamePlayerNumbers);
        verifyUniqueness(gamePlayerNumbers);
        hasCharacters(gamePlayerNumbers);
        isNumberOutOfRange(gamePlayerNumbers);
    }

    private static void verifyLength(String gamePlayerNumbers) {
        if (gamePlayerNumbers.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void verifyUniqueness(String gamePlayerNumbers) {
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (gamePlayerNumbers.lastIndexOf(gamePlayerNumbers.charAt(stringIndex)) != stringIndex) {
                throw new IllegalArgumentException();
            }
        }
    }
}

class GameRepeatInputException extends Exception {
    final static Integer NUMBER_LENGTH = 1;
    final static String ANSWER_RESTART_GAME = "1";
    final static String ANSWER_QUIT_GAME = "2";

    public static void verify(String answerOfRestartGame) {
        answerOfRestartGame = answerOfRestartGame.trim();
        verifyLength(answerOfRestartGame);
        hasCharacters(answerOfRestartGame);
        verifyRange(answerOfRestartGame);
    }

    public static void verifyLength(String answerOfRestartGame) {
        if (answerOfRestartGame.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("exception occurs at checkInputLength()");
        }
    }

    public static void verifyRange(String input) {
        if (!input.contains(ANSWER_RESTART_GAME) && !input.contains(ANSWER_QUIT_GAME)) {
            throw new IllegalArgumentException("exception occurs at checkYesOrNo()");
        }
    }
}
