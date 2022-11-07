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

        public static void printMissionCompleteMessage() {
            System.out.println(Constant.MISSION_COMPLETE_MESSAGE);
        }

        public static void printExitMessage() {
            System.out.println(Constant.GAME_END_MESSAGE);
        }

}




