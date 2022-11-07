package baseball.domain;

import java.util.stream.IntStream;

public class Score {
    private Ball ball;
    private Strike strike;

    private Score(Digits player, Digits computer) {
        int strikeCount = calculateStrike(player, computer);
        int ballCount = calculateBall(player, computer);
        this.ball = Ball.from(ballCount);
        this.strike = Strike.from(strikeCount);
    }

    private Score() {
        this.ball = Ball.ZERO;
        this.strike = Strike.ZERO;
    }

    public static Score calculate(Digits player, Digits computer) {
        return new Score(player, computer);
    }

    public static Score ZERO() {
        return new Score();
    }


    private int calculateStrike(Digits player, Digits computer) {
        return IntStream.range(0, 3).reduce(0, (total, index) -> {
            if (isStrike(player, computer, index)) {
                return total + 1;
            }
            return total;
        });
    }

    private boolean isStrike(Digits player, Digits computer, int index) {
        return player.getDigitInIndex(index) == computer.getDigitInIndex(index);
    }

    private int calculateBall(Digits player, Digits computer) {
        return IntStream.range(0, 3).reduce(0, (total, index) -> {
            if (isBall(player, computer, index)) {
                return total + 1;
            }
            return total;
        });
    }

    private boolean isBall(Digits player, Digits computer, int index) {
        if (isStrike(player, computer, index)) {
            return false;
        }
        return computer.contains(player.getDigitInIndex(index));
    }

    public boolean isZeroScore() {
        return ball == Ball.ZERO && strike == Strike.ZERO;
    }

    public boolean isZeroBall() {
        return ball == Ball.ZERO;
    }

    public boolean isOneBall() {
        return ball == Ball.ONE;
    }

    public boolean isTwoBall() {
        return ball == Ball.TWO;
    }

    public boolean isThreeBall() {
        return ball == Ball.THREE;
    }

    public boolean isZeroStrike() {
        return strike == Strike.ZERO;
    }

    public boolean isOneStrike() {
        return strike == Strike.ONE;
    }

    public boolean isTwoStrike() {
        return strike == Strike.TWO;
    }

    public boolean isThreeStrike() {
        return strike == Strike.THREE;
    }
}
