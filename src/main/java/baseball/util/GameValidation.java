package baseball.util;

public class GameValidation {

    private final static int GAME_NUMBER_LENGTH = 3;
    private final static char START_RANGE = '1';
    private final static char END_RANGE = '9';

    private GameValidation() {
    }

    public static boolean validateLength(String input) {
        return input.length() == GAME_NUMBER_LENGTH;
    }

    public static boolean validateDigit(String input) {
        return input.chars()
            .allMatch(Character::isDigit);
    }

    public static boolean validateRange(String input) {
        return input.chars()
            .allMatch(GameValidation::inRange);
    }

    private static boolean inRange(int codePoint) {
        return START_RANGE <= codePoint && codePoint <= END_RANGE;
    }

}
