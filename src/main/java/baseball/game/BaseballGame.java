package baseball.game;

import baseball.number.PlayerNumber;
import baseball.number.TargetNumber;

public class BaseballGame {

    PlayerNumber playerNumber;
    TargetNumber targetNumber;
    BallCounter ballCounter;

    public BaseballGame(TargetNumber targetNumber, BallCounter ballCounter) {
        //this.playerNumber = playerNumberImpl;
        this.targetNumber = targetNumber;
        this.ballCounter = ballCounter;

    }

    public void start() {
        String result;
        targetNumber.generateTargetNumber();
        playerNumber.setPlayerNumber();
        result = ballCounter.countScore(playerNumber, targetNumber);
        System.out.println(result);
    }

    public boolean isNextGame() {

    }
}
