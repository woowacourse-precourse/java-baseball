package baseball.domain;

import baseball.constants.SystemMessage;
import baseball.gamescore.Strike;

import java.util.List;

public class Referee {
    private static final int STANDARD = 1;

    public String resultJudgment(List<Integer> computer, List<Integer> player) {
        NumberComparison numberComparison = new NumberComparison();
        int correctCount = numberComparison.compare(computer, player);

        Strike strike = new Strike();
        int getStrike = strike.score(computer, player);

        if (correctCount == 0) {
            return SystemMessage.NOTHING_MESSAGE;
        }
        int ball = correctCount - getStrike;

        return getResult(getStrike, ball);
    }

    public String getResult(int strike, int ball) {
        if (ball >= STANDARD && strike == 0) {
            return ball + SystemMessage.BALL_MESSAGE;
        }

        if (strike >= STANDARD && ball == 0) {
            return strike + SystemMessage.STRIKE_MESSAGE;
        }

        if (strike >= STANDARD && ball >= STANDARD) {
            return ball + SystemMessage.BALL_MESSAGE +" "+ strike + SystemMessage.STRIKE_MESSAGE;
        }
        return null;
    }
}
