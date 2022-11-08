package baseball;

import camp.nextstep.edu.missionutils.Console;
import baseball.Constants.Message;

public class BaseballGame {
    public static String requireUserNumber() {
        System.out.print(Message.INPUT_MSG);
        String userNumber = Console.readLine();
        return userNumber;
    }


}
