package baseball.view;

import baseball.controller.ExceptionProcessor;
import camp.nextstep.edu.missionutils.Console;

public class Session {
    public static String getThreeNumbers() {
        String userData = Console.readLine();
        ExceptionProcessor.checkThreeNumbersValid(userData);
        return userData;
    }

    public static String getRestartCondition() {
        String command = Console.readLine();
        ExceptionProcessor.checkRestartCondition(command);
        return command;
    }
}
