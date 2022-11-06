package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public static String receiveUserInput() {
        Result.printEnterNumberMessage();
        String input = Console.readLine();

        validateInput(input);

        return input;
    }
}
