package baseball.domain;

public class Checker {
    private static final int GAME_NUMBER = 3;
    public static boolean hasDifferentNumbers(String numbers) {
        return numbers.chars().distinct().count() == numbers.length();
    }

    public static boolean isValidInputNumbers(String input) {
        return hasDifferentNumbers(input) && isSameAsGameNumber(input.length());
    }

    private static boolean isSameAsGameNumber(int numberSize) {
        return numberSize == GAME_NUMBER;
    }
}
