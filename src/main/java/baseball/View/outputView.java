package baseball.View;

import baseball.Model.Constant;

public class outputView {

    private final int COUNT_BALL;
    private final int COUNT_STRIKE;

    public outputView(int COUNT_BALL, int COUNT_STRIKE) {
        this.COUNT_BALL = COUNT_BALL;
        this.COUNT_STRIKE = COUNT_STRIKE;
    }

    public void printWinGame() {
        System.out.println(Constant.MAX_NUM_SIZE +"개의 숫자를 모두 맞추셨습니다! 게임 종료");
    }

    public void printGameResult() {
        printGameResult();
        printBall();
        printStrike();
        printBallAndStrike();
        printNothing();
    }

    public void printStrike() {
        if(COUNT_STRIKE !=0 && COUNT_BALL ==0) {
            System.out.println(COUNT_STRIKE+"스트라이크");
        }
    }

    public void printBall() {
        if(COUNT_STRIKE ==0 && COUNT_BALL !=0) {
            System.out.println(COUNT_BALL+"볼");
        }
    }

    public void printBallAndStrike() {
        if(COUNT_STRIKE !=0 && COUNT_BALL != 0) {
            System.out.println(COUNT_STRIKE+"스트라이크"+COUNT_BALL+"볼");
        }
    }

    public void printNothing() {
        if(COUNT_STRIKE ==0 && COUNT_BALL == 0) {
            System.out.println("낫싱");
        }
    }
}
