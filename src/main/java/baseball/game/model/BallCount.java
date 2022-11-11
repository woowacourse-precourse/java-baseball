package baseball.game.model;

import java.util.Objects;

public class BallCount {
    private int strike;
    private int ball;

    public BallCount(TargetNumber answer, TargetNumber input) {
        answer.indexedForEach((a, i) -> input.indexedForEach((n, j) -> {
            if (!a.equals(n)) {
                return;
            }
            if (i.equals(j)) {
                this.strike++;
            } else {
                this.ball++;
            }
        }));
    }

    private String getStrike() {
        if (strike > 0) {
            return strike + "스트라이크 ";
        }
        return "";
    }

    private String getBall() {
        if (ball > 0) {
            return ball + "볼 ";
        }
        return "";
    }

    @Override
    public String toString() {
        String ballString = getBall();
        String strikeString = getStrike();

        if (isNothing(ballString, strikeString)) {
            return "낫싱";
        }

        return ballString + strikeString;
    }

    private static boolean isNothing(String ballString, String strikeString) {
        return Objects.equals(ballString, "") && Objects.equals(strikeString, "");
    }

    public boolean isCorrect(int count) {
        return strike == count;
    }
}
