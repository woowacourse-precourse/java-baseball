package baseball.game.view;

import baseball.game.dto.BallCount;

public class OutputView {
    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printBallCount(BallCount ballCount) {
        if (isNothing(ballCount)) {
            System.out.println("낫싱");
            return;
        }

        if (hasStrikeAndBall(ballCount)) {
            System.out.println(ballCount.getBall()+"볼 "+ ballCount.getStrike()+"스트라이크");
            return;
        }

        if(hasStrike(ballCount)){
            System.out.println(ballCount.getStrike()+"스트라이크");
            return;
        }

        System.out.println(ballCount.getBall()+"볼");
    }

    private boolean hasStrike(BallCount ballCount) {
        if(ballCount.getStrike()!=0){
            return true;
        }
        return false;
    }

    private boolean hasStrikeAndBall(BallCount ballCount) {
        if (ballCount.getStrike() != 0 && ballCount.getBall() != 0){
            return true;
        }
        return false;
    }

    private boolean isNothing(BallCount ballCount) {
        if (ballCount.getStrike() == 0 && ballCount.getBall() == 0) {
            return true;
        }
        return false;
    }
}
