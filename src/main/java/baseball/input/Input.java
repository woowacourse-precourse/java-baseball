package baseball.input;

import baseball.exception.ExceptionMessage;
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
        throw new IllegalArgumentException(ExceptionMessage.NOT_RESTART_FORMAT.toString());
    }

    public static int getInputInteger() {
        System.out.print(InputMessage.ASK_INPUT_INTEGER);
        String inputMessage = Console.readLine();

        try {
            return Integer.parseInt(inputMessage);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_INTEGER_FORMAT.toString());
        }
    }
}
