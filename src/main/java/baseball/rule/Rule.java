package baseball.rule;

import java.util.List;

public class Rule {
    private int ball;
    private int strike;

    public Rule() {
        ball = 0;
        strike = 0;
    }

    private void init() {
        ball = 0;
        strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void check(List<Integer> user, List<Integer> computer) {
        for (int userIdx = 0; userIdx < 3; userIdx++) {
            checkStrike(user.get(userIdx), computer.get(userIdx));
            checkBall(user.get(userIdx), computer, userIdx);
        }
    }

    private void checkStrike(Integer userDigit, Integer computerDigit) {
        if (userDigit.equals(computerDigit)) {
            strike++;
        }
    }

    private void checkBall(Integer userDigit, List<Integer> computer, int userIdx) {
        for (int computerIdx = 0; computerIdx < 3; computerIdx++) {
            if ((userDigit.equals(computer.get(computerIdx))) && (userIdx != computerIdx)) {
                ball++;
            }
        }
    }
}
