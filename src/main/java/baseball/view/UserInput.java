package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.utils.UserInputValidator.validateUserInput;
import static baseball.utils.UserInputValidator.validateUserInputForNewGame;

public class UserInput {

    public static String getUserInputNumber(){
        String userInput = Console.readLine();
        validateUserInput(userInput);

        return userInput;
    }

    public static String getUserInputForNewGame(){
        String userInput = Console.readLine();
        validateUserInputForNewGame(userInput);

        return userInput;
    }
}
