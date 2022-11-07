package baseball;

import utils.Input;
import utils.Output;
import utils.RandomNumberGenerator;

import java.util.List;

public class Baseball {
    private List<Integer> computer;

    public Baseball() {
        this.computer = RandomNumberGenerator.generate();
    }

    public void run() {
        boolean isOngoing = true;
        Output.startGame();
        while (isOngoing) {
            List<Integer> player = Input.playerNumber();
            int ballCount = getBallCount(player);
            int strikeCount = getStrikeCount(player);
            Output.getResult(ballCount, strikeCount);
            isOngoing = isContinue(strikeCount);
        }
        Output.endGame();
    }

    private int getBallCount(List<Integer> player) {
        Ball ball = new Ball(player, computer);
        return ball.getCount();
    }

    private int getStrikeCount(List<Integer> player) {
        Strike strike = new Strike(player, computer);
        return strike.getCount();
    }

    private boolean isContinue(int strikeCount) {
        if (!isCorrect(strikeCount)) {
            return true;
        }
        Output.doneGame();
        return false;
    }

    private boolean isCorrect(int strikeCount) {
        return strikeCount == 3;
    }
}
