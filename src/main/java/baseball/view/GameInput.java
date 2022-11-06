package baseball.view;

import baseball.mainframe.User;
import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    public static void getUserInput() {
        GameOutput.printUserInputMessage();
        String userInput = Console.readLine();
        User.setUserInputValue(userInput);
    }

    public static void getUserRestartInput() {
        GameOutput.printRestartGame();
        String userRestartInput = Console.readLine();
        User.setUserRestartInputValue(userRestartInput);
    }
}
