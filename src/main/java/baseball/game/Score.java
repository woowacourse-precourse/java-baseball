package baseball.game;

import java.util.stream.IntStream;

import static baseball.config.GameConstants.BASEBALL_NUMBER_LENGTH;

/**
 * 점수 계산의 책임을 담당하는 클래스
 */
public final class Score {
    private final Ball ball;
    private final Strike strike;

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

    /**
     * 숫자 배열 2가지를 받아서 점수를 계산한 후 Score객체를 반환하는 정적 팩토리 메서드
     *
     * @param player   플레이어가 만들어 낸 3자리 정수
     * @param computer 컴퓨터가 만들어낸 3자리 정수
     * @return 계산된 Score를 가지고 있는 Score객체
     */
    public static Score calculate(Digits player, Digits computer) {
        return new Score(player, computer);
    }

    /**
     * 0스트라이크 0볼의 점수를 가지고 있는 Score를 만들어 내는 정적 팩토리 메서드
     *
     * @return Ball, Strike 모두 0인 Strike 객체
     */
    public static Score ZERO() {
        return new Score();
    }


    private int calculateStrike(Digits player, Digits computer) {
        return IntStream.range(0, BASEBALL_NUMBER_LENGTH).reduce(0, (total, index) -> {
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
        return IntStream.range(0, BASEBALL_NUMBER_LENGTH).reduce(0, (total, index) -> {
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

    /**
     * Ball, score 모두 0인 여부를 반환함
     *
     * @return 모두 0이라면 true
     */
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
