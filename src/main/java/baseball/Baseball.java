package baseball;

import utils.Input;
import utils.Output;
import utils.RandomNumberGenerator;
import java.util.List;

public class Baseball {
    private List<Integer> computer;
    private List<Integer> player;
    private static final int MAX_STRIKE = 3;

    public Baseball() {
        this.computer = RandomNumberGenerator.generate();
    }

    public void run() {
        boolean isOngoing = true;
        Output.startGame();
        while (isOngoing) {
            player = Input.playerNumber();
            int ballCount = getBallCount();
            int strikeCount = getStrikeCount();
            Output.getResult(ballCount, strikeCount);
            isOngoing = isContinue(strikeCount);
        }
        Output.endGame();
    }

    private int getBallCount() {
        Ball ball = new Ball(player, computer);
        return ball.getCount();
    }

    private int getStrikeCount() {
        Strike strike = new Strike(player, computer);
        return strike.getCount();
    }

    private boolean isContinue(int strikeCount) {
        if (!isMaxStrike(strikeCount)) {
            return true;
        }
        Output.doneGame();
        return isRestart();
    }

    private boolean isMaxStrike(int strikeCount) {
        return strikeCount == MAX_STRIKE;
    }

    private boolean isRestart() {
        if (getRestartFlag()) {
            this.computer = RandomNumberGenerator.generate();
            return true;
        }
        return false;
    }

    private boolean getRestartFlag() {
        Output.restart();
        String restartFlag = Input.restartFlag();
        return restartFlag.equals("1");
    }
}
