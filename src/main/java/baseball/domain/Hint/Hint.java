package baseball.domain.Hint;

import baseball.domain.BaseballGame.Ball;
import java.util.List;

public class Hint {
    private int ball;
    private int strike;

    public Hint(List<Integer> playerBalls, List<Integer> computerBalls) {
        this.ball = 0;
        this.strike = 0;
        determineBallStrike(playerBalls, computerBalls);
    }

    public String printHint() {
        String hint = getPrintStatement();
        System.out.println(hint);
        return hint;
    }

    private void determineBallStrike(List<Integer> playerBalls, List<Integer> computerBalls) {
        for (int playerIdx = 0; playerIdx < Ball.COUNT.getValue(); playerIdx++) {
            int playerBall = playerBalls.get(playerIdx);
            compareWithComputerBalls(computerBalls, playerBall, playerIdx);
        }
    }

    private void compareWithComputerBalls(List<Integer> computerBalls, int playerBall, int playerIdx) {
        for (int computerIdx = 0; computerIdx < Ball.COUNT.getValue(); computerIdx++) {
            int computerBall = computerBalls.get(computerIdx);
            updateBallCount(computerBall, playerBall, computerIdx, playerIdx);
        }
    }

    private void updateBallCount(int computerBall, int playerBall, int computerIdx, int playerIdx) {
        if (computerBall == playerBall) {
            ball++;
            updateStrikeCount(computerIdx, playerIdx);
        }
    }

    private void updateStrikeCount(int computerIdx, int playerIdx) {
        if (computerIdx == playerIdx) {
            strike++;
            ball--;
        }
    }

    private String getPrintStatement() {
        StringBuilder sb = new StringBuilder();

        if (ball == 0 && strike == 0) {
            sb.append(HintString.NOTHING.print());
            return sb.toString();
        }

        if (ball > 0) {
            sb.append(HintString.BALL.print(ball));
        }

        if (strike > 0) {
            sb.append(HintString.STRIKE.print(strike));
        }

        return sb.toString();
    }
}
