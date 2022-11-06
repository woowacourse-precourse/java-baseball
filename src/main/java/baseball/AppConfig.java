package baseball;

import baseball.game.BallCounter;
import baseball.game.BaseballGame;
import baseball.number.PlayerNumber;
import baseball.number.TargetNumber;

public class AppConfig {

    public PlayerNumber playerNumber() {
        return new PlayerNumber();
    }

    public TargetNumber targetNumber() {
        return new TargetNumber();
    }

    public BallCounter ballCounter() {
        return new BallCounter();
    }

    public BaseballGame baseballGame() {
        return new BaseballGame(playerNumber(), targetNumber(), ballCounter());
    }
}
