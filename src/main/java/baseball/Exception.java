package baseball;

public class Exception {

    public static void hasCharacters(String input) {
        String regex = "^[0-9]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

}

class PlayerNumbersException extends Exception {
    final static int NUMBER_LENGTH = 3;

    public static void verifyPlayerNumbers(String gamePlayerNumberInput) {
        verifyNumberLength(gamePlayerNumberInput);
        verifyUniqueNumber(gamePlayerNumberInput);
        hasCharacters(gamePlayerNumberInput);
    }

    private static void verifyNumberLength(String stringGamePlayerInput) {
        if (stringGamePlayerInput.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void verifyUniqueNumber(String gamePlayerInput) {
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (gamePlayerInput.lastIndexOf(gamePlayerInput.charAt(stringIndex)) != stringIndex) {
                throw new IllegalArgumentException();
            }
        }
    }

}

class GameRepeatMessageException extends Exception {
    final static Integer EXCEPTION4_NUMBER_LENGTH = 1;
    final static String ANSWER_REPEAT_GAME = "1";
    final static String ANSWER_QUIT_GAME = "2";

    public static void verifyGameRepeatMessage(String input) {
        input = input.trim();
        verifyMessageLength(input);
        hasCharacters(input);
        checkYesOrNo(input);
    }

    public static void verifyMessageLength(String input) {
        if (input.length() != EXCEPTION4_NUMBER_LENGTH) {
            throw new IllegalArgumentException("exception occurs at checkInputLength()");
        }
    }

    public static void checkYesOrNo(String input) {
        if (!input.contains(ANSWER_REPEAT_GAME) && !input.contains(ANSWER_QUIT_GAME)) {
            throw new IllegalArgumentException("exception occurs at checkYesOrNo()");
        }
    }
}
