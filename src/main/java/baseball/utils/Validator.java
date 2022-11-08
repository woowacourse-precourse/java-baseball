package baseball.utils;

public class Validator {
    private static final int GAME_NUMBER_SIZE = 3;

    public static void validateUserNumber(String input) {
        if (!hasDifferentNumbers(input))
            throw new IllegalArgumentException("서로 다른 숫자를 가져야 합니다.");
        if (!isSameAsGameNumberSize(input.length()))
            throw new IllegalArgumentException("숫자는 3개만 입력해야 합니다.");
        if (hasZero(input))
            throw new IllegalArgumentException("숫자는 1부터 9까지만 입력 가능합니다.");
        if (hasNotNumbers(input))
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
    }

    private static boolean hasDifferentNumbers(String numbers) {
        return numbers.chars().distinct().count() == numbers.length();
    }

    public static void validateResumeNumber(String input) {
        if ((!input.equals("1")) && (!input.equals("2")))
            throw new IllegalArgumentException("1 또는 2가 입력되어야 합니다.");
    }

    private static boolean isSameAsGameNumberSize(int numberSize) {
        return numberSize == GAME_NUMBER_SIZE;
    }

    private static boolean hasZero(String input) {
        return input.chars().filter(value -> (value != '0'))
                .count() != input.length();
    }

    private static boolean hasNotNumbers(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
