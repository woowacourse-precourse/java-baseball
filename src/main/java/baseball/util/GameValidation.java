package baseball.util;

public class GameValidation {

    private final static int GAME_NUMBER_LENGTH = 3;

    private GameValidation() {
    }

    public static boolean validateLength(String input) {
        return input.length() == GAME_NUMBER_LENGTH;
    }

    public static boolean validateDigit(String input) {
        return input.chars()
            .allMatch(Character::isDigit);
    }

}
