package view;

import constant.GuideMessage;
import constant.JudgeMessage;

public class Output {

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printStartGuideMessage() {
        System.out.println(GuideMessage.START_GUIDE_MESSAGE);
    }

    public static void printStrikeAndBallCount(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(JudgeMessage.NOTHING);
        } else if (ballCount == 0) {
            System.out.println(strikeCount+JudgeMessage.STRIKE);
        } else if (strikeCount == 0) {
            System.out.println(ballCount+JudgeMessage.BALL);
        } else {
            System.out.println(ballCount+JudgeMessage.BALL + strikeCount+JudgeMessage.STRIKE);
        }
    }

    public static void printThreeStrike() {
        System.out.println(GuideMessage.THREE_STRIKE);
    }
}
