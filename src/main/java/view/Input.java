package view;

import camp.nextstep.edu.missionutils.Console;
import constant.GuideMessage;

public class Input {

    public static String scanStartOrEndNumber() {
        System.out.println(GuideMessage.INPUT_START_OR_END);
        return Console.readLine();
    }

    public static String scanInputNumber() {
        System.out.print(GuideMessage.NUMBER_INPUT_GUIDE);
        return Console.readLine();
    }
}
