package baseball;

import java.util.List;

public class Referee {

    private int ball = 0;
    private int strike = 0;
    private static final String RESULT_NOTHING = "낫싱";
    private static final String RESULT_STRIKE = "스트라이크";
    private static final String RESULT_BALL = "볼";

    public void setBallandStrike(List<Integer> targetNum, List<Integer> userInput) {
        initBallAndStrike();
        for (int i = 0; i < targetNum.size(); i++) {
            if (targetNum.get(i).equals(userInput.get(i))) {
                strike++;
            }
            else {
                ball++;
            }
        }
    }

    private void initBallAndStrike() {
        this.ball = 0;
        this.strike = 0;
    }

    public int getStrike() {
        return this.strike;
    }
    public String resultMessage() {
        String result = "";
        if (ball == 0 && strike == 0) {
            result += RESULT_NOTHING;
        } else if (ball > 0 && strike > 0) {
            result += ball + RESULT_BALL + " " + strike + RESULT_STRIKE;
        } else if (ball > 0) {
            result += ball + RESULT_BALL;
        } else if (strike > 0) {
            result += strike + RESULT_STRIKE;
        }
        return result;
    }


}
