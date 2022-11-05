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
        makeRandomNumber();
        printMessage(START_MESSAGE + ENTER);

        while (gameAvailable) {
            getUserNumber();
            checkUserNumber();
            compareComputerAndUser();
            printMessage(getResult() + ENTER);
            if (checkCorrect()) {
                askExit();
            }
            resetResult();
        }
    }

    private void makeRandomNumber() {
        while (computerNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    private void getUserNumber() {
        printMessage(INPUT_MESSAGE);
        userNumber = Console.readLine();
    }

    private void checkUserNumber() {
        if (!InputValidator.isRightInput(userNumber)) {
            throw new IllegalArgumentException();
        }
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
        printMessage(CORRECT_MESSAGE + ENTER);
        printMessage(REGAME_MESSAGE + ENTER);
        String exitNumber = Console.readLine();

        if (!InputValidator.isRightExitInput(exitNumber)) {
            throw new IllegalArgumentException();
        }

        if (Integer.parseInt(exitNumber) == STOP) {
            gameAvailable = false;
        } else if (Integer.parseInt(exitNumber) == CONTINUE) {
            computerNumbers = new ArrayList<>();
            makeRandomNumber();
        }
    }
}
