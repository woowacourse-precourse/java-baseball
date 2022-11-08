package baseball.domain;

import baseball.constants.SystemMessage;
import baseball.gamescore.Ball;
import baseball.gamescore.Strike;

import java.util.List;

public class Referee {
    private static final int STANDARD = 1;

    private final Ball ball;
    private final Strike strike;
    private final CorrectCount correctCount;

    public Referee(Ball ball, Strike strike, CorrectCount correctCount) {
        this.ball = ball;
        this.strike = strike;
        this.correctCount = correctCount;
    }

    public String resultJudgment(List<Integer> computer, List<Integer> player) {
        int getCorrectCount = correctCount.compare(computer, player);
        int getStrike = strike.score(computer, player);
        int getBall = ball.score(getCorrectCount, getStrike);
        return getResult(getStrike, getBall, getCorrectCount);
    }

    public String getResult(int strike, int ball, int CorrectCount) {
        if (ball >= STANDARD && strike == 0) {
            return ball + SystemMessage.BALL_MESSAGE;
        }

        if (strike >= STANDARD && ball == 0) {
            return strike + SystemMessage.STRIKE_MESSAGE;
        }

        if (strike >= STANDARD && ball >= STANDARD) {
            return ball + SystemMessage.BALL_MESSAGE + " " + strike + SystemMessage.STRIKE_MESSAGE;
        }

        return getNothing(CorrectCount);
    }

    public String getNothing(int CorrectCount) {
        if (CorrectCount == 0) {
            return SystemMessage.NOTHING_MESSAGE;
        }
        return null;
    }
}