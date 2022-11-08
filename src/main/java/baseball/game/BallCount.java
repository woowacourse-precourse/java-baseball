package baseball.game;

import java.util.List;

public class BallCount {
    private int ball = 0;
    private int strike = 0;

    private void plusBall() {
        this.ball++;
    }

    public void checkStrikeOrBall(List<Integer> user, List<Integer> computer, int idx) {
        if (user.get(idx).equals(computer.get(idx))) {
            plusStrike();
        } else if (computer.contains(user.get(idx))) {
            plusBall();
        }
    }

    private void plusStrike() {
        this.strike++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (ball == 0) {
            return strike + "스트라이크";
        }

        if (strike == 0) {
            return ball + "볼";
        }

        return ball + "볼 " + strike + "스트라이크";
    }
}
