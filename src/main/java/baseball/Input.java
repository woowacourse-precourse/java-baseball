package baseball;

import static constant.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String receiveInput() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        Validation.checkInput(input);
        return input;
    }

    public static String restartOrEnd() {
        System.out.println(RESTART_OR_END_MESSAGE);
        String input = Console.readLine();
        Validation.isRestartOrEnd(input);
        return input;
    }
}
