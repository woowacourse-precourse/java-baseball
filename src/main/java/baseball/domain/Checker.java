package baseball.domain;

public class Checker {
    private static final int GAME_NUMBER = 3;
    public static boolean hasDifferentNumbers(String numbers) {
        return numbers.chars().distinct().count() == numbers.length();
    }

    public static boolean isValidInputNumbers(String input) {
        if (!hasDifferentNumbers(input))
            throw new IllegalArgumentException("서로 다른 숫자를 가져야 합니다.");
        if (!isSameAsGameNumberSize(input.length()))
            throw new IllegalArgumentException("숫자는 3개만 입력해야 합니다.");
        return true;
    }

    private static boolean isSameAsGameNumberSize(int numberSize) {
        return numberSize == GAME_NUMBER;
    }
}
