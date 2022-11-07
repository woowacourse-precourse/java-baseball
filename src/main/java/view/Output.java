package view;

import constant.GuideMessage;
import constant.JudgeMessage;

public class Output {

    public static void printExitProgramMessage() {
        System.out.println(GuideMessage.EXIT_PROGRAM);

    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printStartGuideMessage() {
        System.out.println(GuideMessage.START_GUIDE_MESSAGE);
    }

    public static void printStrikeAndBallCount(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(JudgeMessage.NOTHING);
            return;
        }
        if (ballCount == 0) {
            System.out.println(strikeCount + JudgeMessage.STRIKE);
            return;
        }
        if (strikeCount == 0) {
            System.out.println(ballCount + JudgeMessage.BALL);
            return;
        }
        System.out.println(ballCount+JudgeMessage.BALL + strikeCount+JudgeMessage.STRIKE);
    }

    public static void printThreeStrike() {
        System.out.println(GuideMessage.THREE_STRIKE);
    }
}
