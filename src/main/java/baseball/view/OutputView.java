package baseball.view;

import baseball.model.BallCount;
import baseball.model.Result;

public class OutputView {
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResult(Result result) {
        int strike = result.getResultByBallCount(BallCount.STRIKE);
        int ball = result.getResultByBallCount(BallCount.BALL);

        if (strike == 0 && ball == 0) {
            System.out.println(BallCount.NOTHING.getDisplay());
            return;
        }
        StringBuilder gameResult = new StringBuilder();
        if (ball > 0) {
            gameResult.append("" + ball + BallCount.BALL.getDisplay());
        }
        if (strike > 0) {
            gameResult.append(" " + strike + BallCount.STRIKE.getDisplay());
        }
        System.out.println(gameResult);

    }
}
