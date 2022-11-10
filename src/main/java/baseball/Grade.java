package baseball;

import java.util.Objects;

public class Grade {
    private int ball;

    private int strike;

    public Grade() {
    }

    public Grade(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void ballPlus() {
        ball++;
    }

    public void strikePlus() {
        strike++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return ball == grade.ball && strike == grade.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }
}
