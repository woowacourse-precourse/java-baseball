package baseball;

import baseball.resource.AskRestartValue;
import baseball.resource.GameMessage;
import baseball.validation.AskValidation;
import baseball.validation.GameValidation;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {

    public boolean askNewGame() {
        AskValidation askValidation = new AskValidation();

        System.out.println(GameMessage.ASK_RESTART_GAME);
        String newGameResult = Console.readLine();

        if (askValidation.isCheckRestartInput(newGameResult)) {
            if (newGameResult.equals(AskRestartValue.RESTART_GAME)) {
                return true;
            }

            if (newGameResult.equals(AskRestartValue.END_GAME)) {
                return false;
            }
        }

        throw new IllegalArgumentException();
    }

    public void playGame() {
        GameValidation gameValidation = new GameValidation();

        System.out.print(GameMessage.INPUT_NUMBER_MESSAGE);
        String userInput = Console.readLine();

        gameValidation.setUserInput(userInput);
        gameValidation.isAllCheck();
    }
}
