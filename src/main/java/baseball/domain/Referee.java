package baseball.domain;

import baseball.constants.SystemMessage;

import java.util.List;

public class Referee {
    private static final int STANDARD = 1;

    public String resultJudgment(List<Integer> computer, List<Integer> player) {
        NumberComparison numberComparison = new NumberComparison();
        int correctCount = numberComparison.compare(computer, player);

        int strike = getStrike(computer, player);

        if (correctCount == 0) {
            return SystemMessage.NOTHING_MESSAGE;
        }
        int ball = correctCount - strike;
        return getResult(strike, ball);
    }

    private int getStrike(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        for (int playerIndex = 0; playerIndex < player.size(); playerIndex++) {
            int playerNumber = player.get(playerIndex);
            if (computer.get(playerIndex) == playerNumber) {
                strike++;
            }
        }
        return strike;
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
