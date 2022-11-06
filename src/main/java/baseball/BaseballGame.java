package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

import static constant.BaseballConstant.*;

public class BaseballGame {
    private List<Integer> computerNumbers = new ArrayList<>();
    private String userNumber;
    private int strike = 0;
    private int ball = 0;
    private boolean gameAvailable = true;

    public void start() {
        computerNumbers = makeRandomNumber();
        printMessage(START_MESSAGE + ENTER);

        while (gameAvailable) {
            userNumber = inputUserNumber();
            compareComputerAndUser();
            printMessage(getResult() + ENTER);
            if (checkCorrect()) {
                askExit();
            }
            resetResult();
        }
    }

    private List<Integer> makeRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    private String inputUserNumber() {
        printMessage(INPUT_MESSAGE);
        String userInput = Console.readLine();

        if (!InputValidator.isRightInput(userInput)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return userInput;
    }

    private void compareComputerAndUser() {
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (isStrike(index)) {
                strike++;
            } else if (isBall(index)) {
                ball++;
            }
        }
    }

    private boolean isStrike(int index) {
        return userNumber.charAt(index) - '0' == computerNumbers.get(index);
    }

    private boolean isBall(int index) {
        return computerNumbers.contains(userNumber.charAt(index)- '0');
    }

    public String getResult() {
        String resultMessage = "";
        if (ball == 0 && strike == 0) {
            return NOTHING_MESSAGE;
        }
        if (ball > 0) {
            resultMessage += ball + BALL_MESSAGE + SPACE;
        }
        if (strike > 0) {
            resultMessage += strike + STRIKE_MESSAGE + SPACE;
        }
        return resultMessage;
    }

    private boolean checkCorrect() {
        return strike == NUMBER_LENGTH;
    }

    private void resetResult() {
        ball = 0;
        strike = 0;
    }

    private void askExit() {
        int exitNumber = inputExit();

        if (exitNumber == STOP) {
            gameAvailable = false;
        } else if (exitNumber == CONTINUE) {
            computerNumbers = makeRandomNumber();
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
