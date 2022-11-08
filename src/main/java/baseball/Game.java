package baseball;

import utils.Input;
import utils.Output;
import utils.RandomNumberGenerator;
import java.util.List;

public class Game {
    private List<Integer> computer;
    private List<Integer> player;
    private final Baseball baseball;

    public Game() {
        this.baseball = new Baseball();
        this.computer = RandomNumberGenerator.generate();
    }

    public void run() {
        Output.startGame();
        while (true) {
            player = Input.playerNumber();
            countStrikeAndBall();
            outputResult();
            if(isGameOver()) {
                break;
            }
        }
        Output.endGame();
    }

    private boolean isGameOver() {
        if (baseball.isMaxStrike()) {
            Output.doneGame();
            return isRestartOrGameOver();
        }
        return false;
    }

    private boolean isRestartOrGameOver() {
        if (isRestart()) {
            this.computer = RandomNumberGenerator.generate();
            return false;
        }
        return true;
    }

    private boolean isRestart() {
        Output.restart();
        String restartFlag = Input.restartFlag();
        return restartFlag.equals("1");
    }

    private void countStrikeAndBall() {
        baseball.countStrikeAndBall(computer, player);
    }

    private void outputResult() {
        int ballCount = baseball.getBallCount();
        int strikeCount = baseball.getStrikeCount();
        Output.result(ballCount, strikeCount);
    }
}
