package baseball.view;

import baseball.mainframe.User;
import baseball.exception.UserInputException;
import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    public static void getUserInput() {
        GameOutput.printUserInputMessage();
        String userInput = Console.readLine();
        UserInputException.checkUserInputException(userInput);
        User.setUserInputValue(userInput);
    }

    public static void getUserRestartInput() {
        GameOutput.printRestartGame();
        String userRestartInput = Console.readLine();
        UserInputException.checkUserRestartInputException(userRestartInput);
        User.setUserRestartInputValue(userRestartInput);
    }
}
