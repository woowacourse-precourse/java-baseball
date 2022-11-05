package baseball;

import baseball.game.BaseballGame;
import baseball.number.PlayerNumber;
import baseball.number.TargetNumber;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayerNumber playerNumber = new PlayerNumber();
        TargetNumber targetNumber = new TargetNumber();
        BaseballGame baseballGame = new BaseballGame(playerNumber, targetNumber);
    }
}
