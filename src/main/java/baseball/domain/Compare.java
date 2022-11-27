package baseball.domain;

import baseball.service.OutputViewService;
import baseball.view.InputView;

import java.util.List;

public class Compare {

    private int strikeCount;
    private int ballCount;

    public boolean compareTo(List<Integer> computerNumbers, Player player) {
        while (!isPass()) {
            List<Integer> playerNumbers = player.selectNumbers(InputView.readNumbers());
            for (int index = 0; index < computerNumbers.size(); index++) {
                if (computerNumbers.get(index).equals(playerNumbers.get(index))) {
                    strikeCount += 1;
                    continue;
                }

                if (computerNumbers.contains(playerNumbers.get(index))) {
                    ballCount += 1;
                }
            }

            OutputViewService.of(strikeCount, ballCount).test();
        }

        return isPass();
    }

    private boolean isPass() {
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
