package baseball.model;

import baseball.view.OutputView;
import java.util.List;
import java.util.stream.IntStream;

public class GameResult {

    private static final int ZERO = 0;
    private static final int NUM_SIZE = 3;
    private static final int THREE = 3;
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼 ";
    private static final String EMPTY = "";

    private final int strikeCount;
    private final int ballCount;

    public GameResult(List<Integer> answerNums, List<Integer> playerNums) {
        strikeCount = countStrike(answerNums, playerNums);
        ballCount = countBall(answerNums, playerNums);
        OutputView.printGameResult(this);
    }

    private int countBall(List<Integer> answerNums, List<Integer> playerNums) {
        return (int) IntStream.range(ZERO, NUM_SIZE)
                .filter(i -> !isStrike(answerNums, playerNums, i) && answerNums.contains(playerNums.get(i)))
                .count();
    }

    private int countStrike(List<Integer> answerNums, List<Integer> playerNums) {
        return (int) IntStream.range(ZERO, NUM_SIZE)
                .filter(i -> isStrike(answerNums, playerNums, i))
                .count();
    }

    private boolean isStrike(List<Integer> answerNums, List<Integer> playerNums, int i) {
        return answerNums.get(i)
                .equals(playerNums.get(i));
    }

    public boolean isNothing() {
        return strikeCount == ZERO && ballCount == ZERO;
    }

    public boolean isThreeStrike() {
        return strikeCount == THREE;
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return NOTHING;
        }
        return computeBallStr() + computeStrikeStr();
    }

    private String computeBallStr() {
        if (ballCount == ZERO) {
            return EMPTY;
        }
        return ballCount + BALL;
    }

    private String computeStrikeStr() {
        if (strikeCount == ZERO) {
            return EMPTY;
        }
        return strikeCount + STRIKE;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
