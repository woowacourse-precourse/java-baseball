package baseball.domain;

import baseball.constants.SystemMessage;
import baseball.gamescore.Ball;
import baseball.gamescore.Strike;

import java.util.List;

public class Referee {
    private static final int STANDARD = 1;

    private final Ball ball;
    private final Strike strike;
    private final TotalIncludedNumbers totalIncludedNumbers;

    public Referee(Ball ball, Strike strike, TotalIncludedNumbers totalIncludedNumbers) {
        this.ball = ball;
        this.strike = strike;
        this.totalIncludedNumbers = totalIncludedNumbers;
    }

    public String resultJudgment(List<Integer> computer, List<Integer> player) {
        int getCorrectCount = totalIncludedNumbers.compare(computer, player);
        int getStrike = strike.score(computer, player);
        int getBall = ball.score(getCorrectCount, getStrike);
        return getResult(getStrike, getBall, getCorrectCount);
    }

    private String getResult(int strike, int ball, int correctCount) {
        if (ball >= STANDARD && strike == 0) {
            return ball + SystemMessage.BALL_MESSAGE;
        }

        if (strike >= STANDARD && ball == 0) {
            return strike + SystemMessage.STRIKE_MESSAGE;
        }

        if (strike >= STANDARD && ball >= STANDARD) {
            return ball + SystemMessage.BALL_MESSAGE + " " + strike + SystemMessage.STRIKE_MESSAGE;
        }

        return getNothing(correctCount);
    }

    private String getNothing(int correctCount) {
        if (correctCount == 0) {
            return SystemMessage.NOTHING_MESSAGE;
        }
        return null;
    }
}