package baseball.view;

public class Input {

    public static void validateNumber(String text) {
        if (!text.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자가 아닌 값이 있습니다.");
        }
    }

    public static void validateLength(String text) {
        if (text.length() != 3) {
            throw new IllegalArgumentException("3자리가 아닙니다.");
        }
    }
}
