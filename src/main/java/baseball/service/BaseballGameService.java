package baseball.service;

import baseball.domain.BallCount;
import baseball.domain.BaseballNumber;
import baseball.view.BaseballGameInputView;
import baseball.view.BaseballGameOutputView;
import java.util.HashSet;
import java.util.Set;

public class BaseballGameService {
    private BaseballNumber computer;

    public BaseballGameService() {}

    public void gameStart() {
        BaseballGameOutputView.gameStart();
    }

    public void playing() {
        boolean isFinished = false;
        computer = new BaseballNumber();
        while (!isFinished) {
            BallCount ballCount = getCounts();
            BaseballGameOutputView.printBallCount(ballCount);
            isFinished = ballCount.isFinished();
        }
    }

    public boolean replay() {
        return BaseballGameInputView.selectReplay();
    }

    public BallCount getCounts() {
        BaseballNumber player = BaseballGameInputView.getPlayerNumber();
        int strike = 0;
        int ball = 0;
        Set<Integer> computerSet = new HashSet<>(computer.getBaseballNumber());

        for (int idx = 0; idx < 3; idx++) {
            if (player.getBaseballNumber().get(idx) == computer.getBaseballNumber().get(idx)) {
                strike++;
            } else if (computerSet.contains(player.getBaseballNumber().get(idx))) {
                ball++;
            }
        }

        return new BallCount(strike, ball);
    }
}
