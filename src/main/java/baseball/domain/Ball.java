package baseball.domain;

public class Ball {

    private final String numberBall;
    private final String threeNumberRegularExpression = "\\d{3}";

    public Ball(String numberBall) {
        validateForm(numberBall);
        validateDuplication(numberBall);
        this.numberBall = numberBall;
    }

    private void validateForm(String numberBall) {
        if (!numberBall.matches(threeNumberRegularExpression)) {
            throw new IllegalArgumentException("세 자리 숫자만 가능합니다.");
        }
    }

    private void validateDuplication(String numberBall) {
        if (hasDuplicates(numberBall)) {
            throw new IllegalArgumentException("숫자가 중복되지 않아야 합니다.");
        }
    }

    private boolean hasDuplicates(String number) {
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
        int count = 0;
        for (int i = 0; i < expectedBall.length(); i++) {
            if (numberBall.charAt(i) == expectedBall.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public int compareByValue(Ball ball) {
        String expectedBall = ball.toString();
        return (int) expectedBall.chars()
                .mapToObj(Character::toString)
                .filter(numberBall::contains)
                .count();
    }
}
