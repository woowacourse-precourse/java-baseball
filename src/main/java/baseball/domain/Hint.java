package baseball.domain;

import baseball.constant.Constant;
import java.util.List;

public class Hint {
    private int ballCount;
    private int strikeCount;

    public final String BALL = "%d볼";
    public final String STRIKE = "%d스트라이크";
    public final String BALL_AND_STRIKE = "%d볼 %d스트라이크";
    public final String NOTHING = "낫싱";

    public boolean isThreeStrike() {
        if (strikeCount == Constant.SIZE_NUMBER) {
            initializeBallAndStrikeCount();
            return true;
        }
        return false;
    }

    private void initializeBallAndStrikeCount() {
        ballCount = 0;
        strikeCount = 0;
    }

    public String calculateResult(List<Integer> playerInputs, List<Integer> randomNumbers) {
        initializeBallAndStrikeCount();
        for (int i = 0; i < Constant.SIZE_NUMBER; i++) {
            calculateStrikeCount(i, playerInputs, randomNumbers);
            calculateBallCount(i, playerInputs, randomNumbers);
        }
        return countOfBallAndStrike();
    }

    private void calculateStrikeCount(int index, List<Integer> playerInputs, List<Integer> randomNumbers) {
        if (playerInputs.get(index).equals(randomNumbers.get(index))) {
            strikeCount++;
        }
    }

    private void calculateBallCount(int index, List<Integer> playerInputs, List<Integer> randomNumbers) {
        if (!playerInputs.get(index).equals(randomNumbers.get(index))
                && randomNumbers.contains(playerInputs.get(index))) {
            ballCount++;
        }
    }

    private String countOfBallAndStrike() {
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING;
        }
        if (strikeCount == 0) {
            return String.format(BALL, ballCount);
        }
        if (ballCount == 0) {
            return String.format(STRIKE, strikeCount);
        }
        return String.format(BALL_AND_STRIKE, ballCount, strikeCount);
    }
}
