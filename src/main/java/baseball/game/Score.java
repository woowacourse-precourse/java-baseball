package baseball.game;

/**
 * 점수 계산의 책임을 담당하는 클래스
 */
final class Score {
    private final Ball ball;
    private final Strike strike;

    private Score(Digits player, Digits computer) {
        ScoreCalculator scoreCalculator = ScoreCalculator.create(player, computer);
        this.ball = scoreCalculator.getBall();
        this.strike = scoreCalculator.getStrike();
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

    /**
     * Ball, score 모두 0인 여부를 반환함
     *
     * @return 모두 0이라면 true
     */
    public boolean isZeroScore() {
        return ball == Ball.ZERO && strike == Strike.ZERO;
    }

    /**
     * 점수가 0볼인지 여부를 반환함
     *
     * @return 0볼이라면 true
     */
    public boolean isZeroBall() {
        return ball == Ball.ZERO;
    }

    /**
     * 점수가 1볼인지 여부를 반환함
     *
     * @return 1볼이라면 true
     */
    public boolean isOneBall() {
        return ball == Ball.ONE;
    }

    /**
     * 점수가 2볼인지 여부를 반환함
     *
     * @return 2볼이라면 true
     */
    public boolean isTwoBall() {
        return ball == Ball.TWO;
    }

    /**
     * 점수가 3볼인지 여부를 반환함
     *
     * @return 3볼이라면 true
     */
    public boolean isThreeBall() {
        return ball == Ball.THREE;
    }

    /**
     * 점수가 0스트라이크인지 여부를 반환함
     *
     * @return 0스트라이크라면 true
     */

    public boolean isZeroStrike() {
        return strike == Strike.ZERO;
    }

    /**
     * 점수가 1스트라이크인지 여부를 반환함
     *
     * @return 1스트라이크라면 true
     */
    public boolean isOneStrike() {
        return strike == Strike.ONE;
    }

    /**
     * 점수가 2스트라이크인지 여부를 반환함
     *
     * @return 2스트라이크라면 true
     */
    public boolean isTwoStrike() {
        return strike == Strike.TWO;
    }

    /**
     * 점수가 3스트라이크인지 여부를 반환함
     *
     * @return 3스트라이크라면 true
     */

    public boolean isThreeStrike() {
        return strike == Strike.THREE;
    }
}
