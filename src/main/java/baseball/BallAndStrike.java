package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallAndStrike {
    private List<Integer> ballAndStrike;
    public BallAndStrike() {
        ballAndStrike = new ArrayList<>(Arrays.asList(0, 0));
    }
    public List<Integer> getBallAndStrike() {
        return this.getBallAndStrike();
    }
    public void countBallAndStrike(List<Integer> randomNumber, List<Integer> enterNumber) {
        for (int i = 0; i < 3; i++) {
            if (randomNumber.contains(enterNumber.get(i))) {
                ballAndStrike.set(0, ballAndStrike.get(0)+1);
            }
            if (randomNumber.get(i) == enterNumber.get(i)) {
                ballAndStrike.set(1, ballAndStrike.get(1)+1);
                ballAndStrike.set(0, ballAndStrike.get(0)-1);
            }
        }
    }
    public void caseOfAllBallAndStrike(List<Integer> ballAndStrikeNumber) {
        String announceBallAndStrike = "";
        if (ballAndStrikeNumber.get(0) == 0 && ballAndStrikeNumber.get(1) == 0) {
            announceBallAndStrike += "낫싱";
        }
        if (ballAndStrikeNumber.get(0) > 0) {
            announceBallAndStrike += String.valueOf(ballAndStrikeNumber.get(0)) + "볼 ";
        }
        if (ballAndStrikeNumber.get(1) > 0) {
            announceBallAndStrike += String.valueOf(ballAndStrikeNumber.get(1)) + "스트라이크";
        }
        System.out.println(announceBallAndStrike);
    }
}
