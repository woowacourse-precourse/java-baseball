package baseball.model;

import java.util.List;

public class Umpire {

    private int strike = 0;

    private int ball = 0;

    public String gameResult(List<Integer> computerNum, List<Integer> playerNum) {
        checkStrike(computerNum, playerNum);

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        else if (ball == 0) {
            return this.strike + "스트라이크";
        }
        else if (strike == 0) {
            return this.ball + "볼";
        }
        else {
            return this.ball + "볼 " + this.strike + "스트라이크";
        }
    }

    public void checkStrike(List<Integer> computerNum, List<Integer> playerNum) {
        checkBall(computerNum, playerNum);

        for (int i = 0; i < computerNum.size(); i++) {
            if (computerNum.get(i) == playerNum.get(i)) {
                this.strike++;
                this.ball--;
            }
        }
    }

    public void checkBall(List<Integer> computerNum, List<Integer> playerNum) {
        for (int num : playerNum) {
            if (computerNum.contains(playerNum)) {
                this.ball++;
            }
        }
    }

    public int getStrike() {
        return this.strike;
    }
}
