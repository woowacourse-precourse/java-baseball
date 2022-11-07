package baseball.input;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String RESTART_APPLICATION = "1";
    private static final String END_APPLICATION = "2";

    public static boolean isRestart() {
        System.out.print(InputMessage.ASK_APPLICATION_RESTART);
        String inputMessage = Console.readLine();
        if (inputMessage == RESTART_APPLICATION) {
            return true;
        }
        if (inputMessage == END_APPLICATION) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
