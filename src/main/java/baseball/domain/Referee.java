package baseball.domain;

import baseball.view.OutputView;

import java.util.List;

public class Referee {

    private int strikeCount;
    private int ballCount;

    public void compareTo(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        for (int index = 0; index < computerNumbers.size(); index++) {
            if (computerNumbers.get(index).equals(playerNumbers.get(index))) {
                strikeCount += 1;
                continue;
            }

            if (computerNumbers.contains(playerNumbers.get(index))) {
                ballCount += 1;
            }
        }

        OutputView.printBaseBallResult(strikeCount, ballCount);
    }

    public boolean isPass() {
        if (isThreeStrike()) {
            countReset();
            return true;
        }

        countReset();
        return false;
    }

    private boolean isThreeStrike() {
        return strikeCount == 3;
    }

    private void countReset() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }
}
