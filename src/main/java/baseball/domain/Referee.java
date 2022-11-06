package baseball.domain;

import baseball.constants.SystemMessage;
import baseball.gamescore.Ball;
import baseball.gamescore.Strike;

import java.util.List;

public class Referee {
    private static final int STANDARD = 1;

    public String resultJudgment(List<Integer> computer, List<Integer> player) {
        CorrectCount definiteNumber = new CorrectCount();
        Strike strike = new Strike();
        Ball ball = new Ball();

        int correctCount = definiteNumber.compare(computer, player);
        int getStrike = strike.score(computer, player);
        int getBall = ball.score(correctCount, getStrike);

        if (correctCount == 0) {
            return SystemMessage.NOTHING_MESSAGE;
        }
        return getResult(getStrike, getBall);
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
