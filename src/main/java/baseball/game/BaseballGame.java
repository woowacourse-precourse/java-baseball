package baseball.game;

import baseball.number.PlayerNumber;
import baseball.number.TargetNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    PlayerNumber playerNumber;
    TargetNumber targetNumber;
    List<String> playerList;
    List<String> targetList;
    List<Boolean> numberState = new ArrayList<>();
    int strikeCount;
    int ballCount;

    public BaseballGame(PlayerNumber playerNumberImpl, TargetNumber targetNumberImpl) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        this.playerNumber = playerNumberImpl;
        this.targetNumber = targetNumberImpl;

        start();
    }

    public void init() {
        strikeCount = 0;
        ballCount = 0;
        numberState.clear();
    }

    public void start() {
        init();
        targetList = targetNumber.getNumber();
        System.out.println("targetList = " + targetList);
        playerNumber.setPlayerNumber();
        playerList = playerNumber.getNumber();
        System.out.println("playerList = " + playerList);
        generateNumberState();

        countStrike();
        countBall();
    }

    public void countStrike() {
        for (int idx = 0; idx < targetList.size(); idx++) {
            if (playerList.get(idx).equals(targetList.get(idx))) {
                numberState.set(idx, true);
                strikeCount++;
            }
        }
        System.out.println("numberState = " + numberState);
        System.out.println("strikeCount = " + strikeCount);
    }

    public void countBall() {
        for (int idx = 0; idx< targetList.size(); idx++){
            if (targetList.contains(playerList.get(idx)) && !numberState.get(idx)) {
                numberState.set(idx, true);
                ballCount++;
            }
        }
        System.out.println("ballCount = " + ballCount);
    }

    public void generateNumberState() {
        for (int i = 0; i < targetList.size(); i++) {
            numberState.add(false);
        }
    }



}
