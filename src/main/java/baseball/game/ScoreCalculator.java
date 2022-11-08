package baseball.game;

import java.util.stream.IntStream;

import static baseball.config.GameConstants.BASEBALL_NUMBER_LENGTH;

/**
 * 순수하게 점수를 계산하는 책임만을 가지고 있는 클래스이다
 */
final class ScoreCalculator {
    private static final int ZERO = 0;
    private final Digits player;
    private final Digits computer;

    private ScoreCalculator(Digits player, Digits computer) {
        this.computer = computer;
        this.player = player;
    }

    /**
     * ScoreCalculator 를 만드는 정적 팩토리 메서드
     *
     * @param player   player 가 입력한 Digits 를 넣는다
     * @param computer computer 가 생성한 Digits 를 넣는다
     * @return ScoreCalculator 객체
     */
    public static ScoreCalculator create(Digits player, Digits computer) {
        return new ScoreCalculator(player, computer);
    }

    /**
     * Ball 이 몇 개가 있었는 지 확인하는 메서드
     *
     * @return Ball 의 수에 해당하는 점수
     */

    public Ball getBall() {
        return Ball.from(IntStream.range(ZERO, BASEBALL_NUMBER_LENGTH)
                .reduce(ZERO, this::updateTotalBallCount));
    }

    private int updateTotalBallCount(int totalBall, int index) {
        if (isBall(index)) {
            return totalBall + 1;
        }
        return totalBall;
    }

    private boolean isBall(int index) {
        if (isStrike(index)) {
            return false;
        }
        return computer.contains(player.getDigitInIndex(index));
    }

    public Strike getStrike() {
        return Strike.from(IntStream.range(ZERO, BASEBALL_NUMBER_LENGTH)
                .reduce(ZERO, this::updateTotalStrikeCount));
    }

    private int updateTotalStrikeCount(int totalStrike, int index) {
        if (isStrike(index)) {
            return totalStrike + 1;
        }
        return totalStrike;
    }

    private boolean isStrike(int index) {
        return player.getDigitInIndex(index) == computer.getDigitInIndex(index);
    }
}
