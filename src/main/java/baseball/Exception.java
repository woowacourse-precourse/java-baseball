package baseball;

public class Exception {
    final static Integer EXCEPTION4_NUMBER_LENGTH = 1;
    final static String ANSWER_REPEAT_GAME = "1";
    final static String ANSWER_QUIT_GAME = "2";

    public static void hasCharacters(String input) {
        String regex = "^[0-9]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

}

class ExceptionFor4 extends Exception {

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
