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
        int nothing = result.getResultByBallCount(BallCount.NOTHING);

        System.out.println(result.getResult());
    }
}
