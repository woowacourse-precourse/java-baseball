package view;

import camp.nextstep.edu.missionutils.Console;
import constant.GuideMessage;

public class Input {

    public static String scanStartOrEndNumber() {
        System.out.println(GuideMessage.INPUT_START_OR_END);
        return Console.readLine();
    }
}
