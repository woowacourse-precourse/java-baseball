package baseball.model;

import java.util.List;
import java.util.stream.IntStream;

public class GameResult {

    private static final int ZERO = 0;
    private static final int NUM_SIZE = 3;
    private static final int THREE = 3;
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼 ";

    private final int strikeCount;
    private final int ballCount;

    public GameResult(List<Integer> answerNums, List<Integer> playerNums) {
        strikeCount = countStrike(answerNums, playerNums);
        ballCount = countBall(answerNums, playerNums);
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
        return answerNums.get(i) == playerNums.get(i);
    }

    public boolean isNothing() {
        return strikeCount == ZERO && ballCount == ZERO;
    }

    public boolean isThreeStrike() {
        return strikeCount == THREE;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isNothing()) {
            return NOTHING;
        }
        if (ballCount != ZERO) {
            sb.append(ballCount + BALL);
        }
        if (strikeCount != ZERO) {
            sb.append(strikeCount + STRIKE);
        }
        return sb.toString();
    }
}
