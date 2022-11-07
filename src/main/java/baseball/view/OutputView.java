package baseball.view;

import baseball.domain.Constant;

public class OutputView {
    public static void printNumberBaseballResult(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(Constant.NOTHING);
        }
        if (ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + Constant.STRIKE);
        }
        if (ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount + Constant.BALL);
        }
        if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + Constant.BALL + strikeCount + Constant.STRIKE);
        }

    }


}

