package baseball.game;

import baseball.number.PlayerNumber;
import baseball.number.TargetNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    PlayerNumber playerNumber;
    TargetNumber targetNumber;
    BallCounter ballCounter;
    List<String> playerList;
    List<String> targetList;


    public BaseballGame(PlayerNumber playerNumberImpl, TargetNumber targetNumberImpl, BallCounter ballCounter) {
        this.playerNumber = playerNumberImpl;
        this.targetNumber = targetNumberImpl;
        this.ballCounter = ballCounter;

        start();
    }

    public void start() {
        String result;
        playerNumber.setPlayerNumber();
        result = ballCounter.count(playerNumber.getNumber(), targetNumber.getNumber());
        System.out.println(result);
    }
}
