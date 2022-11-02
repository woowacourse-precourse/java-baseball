package view;

import constant.GuideMessage;

public class Output {

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printStartGuideMessage() {
        System.out.println(GuideMessage.START_GUIDE_MESSAGE);
    }
}
