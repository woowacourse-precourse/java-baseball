package baseball.domain;

import baseball.constant.Constant;

public class Ball {
    private final String numberBall;
    private static final String THREE_NUMBER_REGULAR_EXPRESSION = "\\d{3}";
    public static final String EXCEPTION_MESSAGE_FOR_INVALID_FORM = "세 자리 숫자만 가능합니다.";
    public static final String EXCEPTION_MESSAGE_FOR_DUPLICATION = "숫자가 중복되지 않아야 합니다.";

    public Ball(String numberBall) {
        validateForm(numberBall);
        validateDuplication(numberBall);
        this.numberBall = numberBall;
    }

    private void validateForm(String numberBall) {
        if (!numberBall.matches(THREE_NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FOR_INVALID_FORM);
        }
    }

    private void validateDuplication(String numberBall) {
        if (isContainingDuplication(numberBall)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FOR_DUPLICATION);
        }
    }

    private boolean isContainingDuplication(String number) {
        return number.length() != number.chars()
                .distinct()
                .count();
    }

    @Override
    public String toString() {
        return numberBall;
    }

    public int compareByIndex(Ball ball) {
        String expectedBall = ball.toString();
        int count = Constant.ZERO_NUM;
        for (int i = 0; i < expectedBall.length(); i++) {
            count += compareByChar(numberBall.charAt(i), expectedBall.charAt(i));
        }
        return count;
    }

    private int compareByChar(char characterA, char characterB) {
        if (characterA == characterB) {
            return Constant.ONE_NUM;
        }
        return Constant.ZERO_NUM;
    }

    public int compareByValue(Ball ball) {
        String expectedBall = ball.toString();
        return (int) expectedBall.chars()
                .filter(expectedChar -> numberBall.chars().
                        anyMatch(actualChar -> expectedChar == actualChar))
                .count();
    }
}
