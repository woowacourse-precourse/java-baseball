package baseball;

import baseball.resource.AskRestartValue;
import baseball.resource.GameMessage;
import baseball.validation.AskValidation;
import baseball.validation.GameValidation;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private String userBaseballNumber = "";
    private String userRestartNumber = "";

    public String getUserBaseballNumber() {
        return this.userBaseballNumber;
    }

    private void setUserBaseballNumber(String userBaseballNumber) {
        this.userBaseballNumber = userBaseballNumber;
    }

    private void setUserRestartNumber(String userRestartNumber) {
        this.userRestartNumber = userRestartNumber;
    }

    public void inputBaseballNumber() {
        String userInput;

        System.out.print(GameMessage.INPUT_NUMBER_MESSAGE);
        userInput = Console.readLine();

        setUserBaseballNumber(userInput);

        isValidInputUserBaseballNumber();
    }

    private void isValidInputUserBaseballNumber() {
        GameValidation gameValidation = new GameValidation();

        gameValidation.setUserInput(this.userBaseballNumber);

        gameValidation.isAllCheck();
    }

    public void inputRestartNumber() {
        String userInput;

        System.out.println(GameMessage.ASK_RESTART_GAME);
        userInput = Console.readLine();

        setUserRestartNumber(userInput);

        isCheckRestart();
    }

    private void isCheckRestart() {
        AskValidation askValidation = new AskValidation();

        askValidation.isCheckRestartInput(this.userRestartNumber);
    }

    public boolean getRestartStatus() {
        if (this.userRestartNumber.equals(AskRestartValue.RESTART_GAME)) {
            return true;
        }

        if (this.userRestartNumber.equals(AskRestartValue.END_GAME)) {
            return false;
        }

        return false;
    }
}
