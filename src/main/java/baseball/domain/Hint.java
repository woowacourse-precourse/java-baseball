package baseball.domain;

import baseball.constant.Constant;

import java.util.List;

public class Hint {
    private int ballCount;
    private int strikeCount;


    public void calculateResult(List<Integer> playerInputs, List<Integer> randomNumbers) {
        initializeBallAndStrikeCount();
        for (int i = 0; i < Constant.SIZE_NUMBER; i++) {
            calculateStrikeCount(i, playerInputs, randomNumbers);
            calculateBallCount(i, playerInputs, randomNumbers);
        }
    }

    private void initializeBallAndStrikeCount() {
        ballCount = 0;
        strikeCount = 0;
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
}
