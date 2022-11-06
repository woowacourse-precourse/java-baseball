package baseball.game;

import java.util.ArrayList;
import java.util.List;

public class BallCounter {

    final int MATCH_NUM = 3;

    int strikeCount = 0;
    int ballCount = 0;
    List<String> playerNumber;
    List<String> targetNumber;
    List<Boolean> numberState = new ArrayList<>();


    public String count(List<String> playerNumber, List<String> targetNumber) {
        this.playerNumber = playerNumber;
        this.targetNumber = targetNumber;

        generateNumberState();
        countStrike();
        countBall();

        return generateResult();
    }

    public void countStrike() {
        for (int idx = 0; idx < targetNumber.size(); idx++) {
            if (playerNumber
                    .get(idx).equals(targetNumber.get(idx))) {
                numberState.set(idx, true);
                strikeCount++;
            }
        }
    }

    public void countBall() {
        for (int idx = 0; idx< targetNumber.size(); idx++){
            if (targetNumber.contains(playerNumber.get(idx)) && !numberState.get(idx)) {
                numberState.set(idx, true);
                ballCount++;
            }
        }
    }

    public void generateNumberState() {
        for (int i = 0; i < targetNumber.size(); i++) {
            numberState.add(false);
        }
    }

    public String generateResult() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }
        if (strikeCount == MATCH_NUM) {
            return strikeCount + "스트라이크" +"\n" + MATCH_NUM + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }
        if (strikeCount == 0) {
            return ballCount + "볼";
        }
        return ballCount + "볼 " + strikeCount + "스트라이크";
    }


}
