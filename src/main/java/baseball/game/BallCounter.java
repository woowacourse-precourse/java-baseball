package baseball.game;

import baseball.number.PlayerNumber;
import baseball.number.TargetNumber;

import java.util.ArrayList;
import java.util.List;

public class BallCounter {

    final int MATCH_NUM = 3;

    String result;
    List<String> playerNumber;
    List<String> targetNumber;
    List<Boolean> numberState = new ArrayList<>();


    public String countScore(PlayerNumber playerNumber, TargetNumber targetNumber) {
        this.playerNumber = playerNumber.getNumber();
        this.targetNumber = targetNumber.getNumber();

        initNumberState();
        countStrike();
        countBall();

        generateResult(countStrike(), countBall());

        return "";
    }

    public int countStrike() {
        int strikeCount = 0;

        for (int idx = 0; idx < targetNumber.size(); idx++) {
            if (playerNumber
                    .get(idx).equals(targetNumber.get(idx))) {
                numberState.set(idx, true);
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall() {
        int ballCount = 0;

        for (int idx = 0; idx< targetNumber.size(); idx++){
            if (targetNumber.contains(playerNumber.get(idx)) && !numberState.get(idx)) {
                numberState.set(idx, true);
                ballCount++;
            }
        }
        return ballCount;
    }

    public void initNumberState() {
        for (int i = 0; i < targetNumber.size(); i++) {
            numberState.add(false);
        }
    }

    public boolean generateResult(int strikeCount, int ballCount) {
        if (ballCount == 0 && strikeCount == 0) {
            result = "낫싱";
            return false;
        }
        if (strikeCount == MATCH_NUM) {
            result = strikeCount + "스트라이크" +"\n" + MATCH_NUM + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
            return true;
        }
        if (ballCount == 0) {
            result = strikeCount + "스트라이크";
            return false;
        }
        if (strikeCount == 0) {
            result = ballCount + "볼";
            return false;
        }
        result = ballCount + "볼 " + strikeCount + "스트라이크";
        return false;
    }


}
