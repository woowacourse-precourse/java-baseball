package baseball;

import camp.nextstep.edu.missionutils.Console;
import validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

import static constant.BaseballConstant.*;

public class BaseballGame {
    private List<Integer> computerNumbers = new ArrayList<>();
    private String userNumber;
    private boolean gameAvailable = true;

    public void start() {
        BaseballScore baseballScore = new BaseballScore();
        BaseballNumber baseballNumber = new BaseballNumber();

        computerNumbers = baseballNumber.makeRandomNumber();
        printMessage(START_MESSAGE + ENTER);

        while (gameAvailable) {
            printMessage(INPUT_MESSAGE);
            userNumber = baseballNumber.inputUserNumber();

            baseballScore.compareComputerAndUser(computerNumbers, userNumber);
            printMessage(baseballScore.getResult() + ENTER);

            if (baseballScore.checkCorrect()) {
                askExit();

            }
            baseballScore.resetResult();
        }
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    private void askExit() {
        int exitNumber = inputExit();

        if (exitNumber == STOP) {
            gameAvailable = false;
        } else if (exitNumber == CONTINUE) {
            BaseballNumber baseballNumber = new BaseballNumber();
            computerNumbers = baseballNumber.makeRandomNumber();
        }
    }

    private int inputExit() {
        printMessage(CORRECT_MESSAGE + ENTER);
        printMessage(REGAME_MESSAGE + ENTER);

        String exitNumber = Console.readLine();

        if (!InputValidator.isRightExitInput(exitNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return Integer.parseInt(exitNumber);
    }
}
