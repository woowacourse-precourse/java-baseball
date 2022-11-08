package baseball;

import camp.nextstep.edu.missionutils.Console;
import static baseball.Constants.GAME_INPUT_LENGTH;
import baseball.Constants.Message;

public class BaseballGame {
    public static String requireUserNumber() {
        System.out.print(Message.INPUT_MSG);
        String userNumber = Console.readLine();
        return userNumber;
    }

    public static String requireRestartNumber() {
        System.out.println(Message.RESTART_MSG);
        String restartNumber = Console.readLine();
        return restartNumber;
    }


    public static void exceptionThreeNumber(String Input) {
        if (Input.length() != GAME_INPUT_LENGTH) {
            throw new IllegalArgumentException(Message.ERROR_MSG);
        }
    }

}
