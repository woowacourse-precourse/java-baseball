package baseball.view;

import baseball.controller.BaseballCountController;
import baseball.model.BaseballRule;

public class SystemOutputView {

    private final int strikecount;
    private final int ballcount;

    public SystemOutputView(BaseballCountController baseballCountController) {
        this.strikecount = baseballCountController.getStrikecount();
        this.ballcount = baseballCountController.getBallcount();
    }

    public void printOutputMessage() {
        baseballCountMessage();
        onlyBallMessage();
        onlyStrikeMessage();
        allNotSameMessage();
    }

    public static void allStrikeMessage() {
        System.out.println(BaseballRule.num_length+"개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void baseballCountMessage() {
        if (strikecount != 0 && ballcount != 0) {
            System.out.println(ballcount + "볼 " + strikecount + "스트라이크");
        }

    }

    private void onlyBallMessage() {
        if (strikecount == 0 && ballcount != 0) {
            System.out.println(ballcount + "볼");
        }

    }

    private void onlyStrikeMessage() {
        if (strikecount != 0 && ballcount == 0) {
            System.out.println(strikecount + "스트라이크");
        }
    }

    private void allNotSameMessage() {
        if (strikecount == 0 && ballcount == 0) {
            System.out.println("낫싱");
        }
    }


}
