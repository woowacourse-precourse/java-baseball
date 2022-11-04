package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import validator.InputValidator;

import java.util.ArrayList;
import java.util.List;

import static constant.BaseballConstant.*;

public class BaseballGame {
    private static List<Integer> computerNumbers = new ArrayList<>();
    private static String userNumber;
    private static int strike = 0;
    private static int ball = 0;
    private static boolean gameAvailable = true;

    public static void start() {
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
        }
    }

    private static void makeRandomNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void getUserNumber() {
        printMessage(INPUT_MESSAGE);
        userNumber = Console.readLine();
    }

    public static void checkUserNumber() {
        InputValidator inputValidator = new InputValidator();
        if (!InputValidator.isRightInput(userNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static void compareComputerAndUser() {
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (isStrike(index)) {
                strike++;
            } else if (isBall(index)) {
                ball++;
            }
        }
    }

    private static boolean isStrike(int index) {
        return userNumber.charAt(index) - '0' == computerNumbers.get(index);
    }

    private static boolean isBall(int index) {
        return computerNumbers.contains(userNumber.charAt(index)- '0');
    }

    public static String getResult() {
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

    private static boolean checkCorrect() {
        if (strike == 3) {
            resetResult();
            return true;
        }
        return false;
    }

    private static void resetResult() {
        computerNumbers = new ArrayList<>();
        ball = 0;
        strike = 0;
    }

    private static void askExit() {
        printMessage(CORRECT_MESSAGE + ENTER);
        printMessage(REGAME_MESSAGE + ENTER);
        String exitNumber = Console.readLine();
        if (exitNumber.equals("2")) {
            gameAvailable = false;
        } else if (exitNumber.equals("1")) {
            makeRandomNumber();
        }
    }
}
