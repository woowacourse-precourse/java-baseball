package baseball.model;

import java.util.Objects;

public class Answer {
    private static final String STRIKE_AND_BALL_CANNOT_BE_OVER_THREE = "스트라이크와 볼의 합이 3초과 일수는 없습니다.";

    private int strike;
    private int ball;

    public Answer(int strike, int ball) {
        validateUnderThree(strike, ball);
        this.strike = strike;
        this.ball = ball;
    }

    private void validateUnderThree(int strike, int ball) {
        if (isOverThree(strike, ball)) {
            throw new RuntimeException(STRIKE_AND_BALL_CANNOT_BE_OVER_THREE);
        }
    }

    private static boolean isOverThree(int strike, int ball) {
        return strike + ball > 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return strike == answer.strike && ball == answer.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
