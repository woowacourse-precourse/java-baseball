package baseball.domain;

public class Ball {

    private final String numberBall;
    private final String threeNumberRegularExpression = "\\d{3}";

    public Ball(String numberBall) {
        validateForm(numberBall);
        this.numberBall = numberBall;
    }

    private void validateForm(String numberBall) {
        if (!numberBall.matches(threeNumberRegularExpression)) {
            throw new IllegalArgumentException("세 자리 숫자만 가능합니다.");
        }
    }
}
