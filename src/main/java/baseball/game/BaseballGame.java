package baseball.game;

import baseball.number.PlayerNumber;
import baseball.number.TargetNumber;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    PlayerNumber playerNumber;
    TargetNumber targetNumber;

    public BaseballGame(PlayerNumber playerNumberImpl, TargetNumber targetNumberImpl) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.playerNumber = playerNumberImpl;
        this.targetNumber = targetNumberImpl;

        start();
    }

    public void start() {
        playerNumber.setPlayerNumber();
    }



}
