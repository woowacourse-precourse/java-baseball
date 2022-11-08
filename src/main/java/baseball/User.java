package baseball;

import baseball.resource.GameMessage;
import baseball.validation.GameValidation;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private String userBaseballNumber = "";

    public void setUserBaseballNumber(String userBaseballNumber) {
        this.userBaseballNumber = userBaseballNumber;
    }

    public boolean inputUserNumber() {
        String userInput;

        System.out.print(GameMessage.INPUT_NUMBER_MESSAGE);
        userInput = Console.readLine();

        setUserBaseballNumber(userInput);

        return isValidInputUserBaseballNumber();
    }

    private boolean isValidInputUserBaseballNumber() {
        GameValidation gameValidation = new GameValidation();

        gameValidation.setUserInput(this.userBaseballNumber);

        return gameValidation.isAllCheck();
    }
}
