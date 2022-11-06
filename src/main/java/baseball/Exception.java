package baseball;

public class Exception {

    public static void hasCharacters(String input) {
        String regex = "^[0-9]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

}

class ExceptionFor2 extends Exception {
    final static int NUMBER_LENGTH = 3;
    public static void checkGamePlayerNumberInput(String gamePlayerNumberInput) {
        checkNumberLength(gamePlayerNumberInput);
        hasSameNumber(gamePlayerNumberInput);
        hasCharacters(gamePlayerNumberInput);
    }

    private static void checkNumberLength(String stringGamePlayerInput) {
        int stringLength =  stringGamePlayerInput.length();
        if (stringLength > NUMBER_LENGTH || stringLength < 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void hasSameNumber(String gamePlayerInput) {
        for (int stringIndex = 0; stringIndex < NUMBER_LENGTH; stringIndex++) {
            if (gamePlayerInput.lastIndexOf(gamePlayerInput.charAt(stringIndex)) != stringIndex) {
                throw new IllegalArgumentException();
            }
        }
    }

}

class ExceptionFor4 extends Exception {
    final static Integer EXCEPTION4_NUMBER_LENGTH = 1;
    final static String ANSWER_REPEAT_GAME = "1";
    final static String ANSWER_QUIT_GAME = "2";

    public static void checkException(String input) {
        hasCharacters(input);
        checkInputLength(input);
        checkYesOrNo(input);
    }

    public static void checkInputLength(String input) {
        if (input.length() != EXCEPTION4_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkYesOrNo(String input) {
        if (input != ANSWER_REPEAT_GAME && input != ANSWER_QUIT_GAME) {
            throw new IllegalArgumentException();
        }
    }
}
