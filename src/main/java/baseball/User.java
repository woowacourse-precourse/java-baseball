package baseball;

import baseball.resource.GameMessage;
import baseball.validation.GameValidation;
import camp.nextstep.edu.missionutils.Console;

public class User {

    public String inputUserBaseballNumber() {
        GameValidation gameValidation = new GameValidation();

        System.out.print(GameMessage.INPUT_NUMBER_MESSAGE);
        String userInput = Console.readLine();

        gameValidation.setUserInput(userInput);
        gameValidation.isAllCheck();

        return userInput;
    }
}
