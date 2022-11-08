package baseball.core;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

import static baseball.core.GameStatus.*;
import static baseball.display.OutputStatement.*;

public class GameFlow {

    public static GameStatus playGame(BaseballGame baseballGame) {

        System.out.println(gameStart);
        GameStatus currentStatus = ONGOING;
        baseballGame.setCurrentStatus(currentStatus);
        currentStatus = executeGame(baseballGame);
        baseballGame.setCurrentStatus(currentStatus);
        return currentStatus;
    }

    private static GameStatus executeGame(BaseballGame baseballGame) {
        GameStatus currentStatus = baseballGame.getCurrentStatus();
        String targetNumber = baseballGame.getTargetNumber();
        while (currentStatus == ONGOING) {
            System.out.print(enterNumber);
            String inputNumber = Console.readLine();
            InputException.validateInputNumber(inputNumber);
            Integer numberOfBall = baseballGame.countTheNumberOfBall(targetNumber, inputNumber);
            Integer numberOfStrike = baseballGame.countTheNumberOfStrike(targetNumber, inputNumber);

            if (numberOfStrike == 3) {
                System.out.println(correctNumber);
                String selectGameStatus = Console.readLine();
                InputException.validateInputNumber(inputNumber);
                currentStatus = changeGameStatus(currentStatus, selectGameStatus);
            } else {
                printBallAndStrike(numberOfBall, numberOfStrike);
            }
        }
        return currentStatus;
    }

    private static GameStatus changeGameStatus(GameStatus currentStatus, String selectGameStatus) {
        if (selectGameStatus.equals("1")) currentStatus = START;
        if (selectGameStatus.equals("2")) currentStatus = QUIT;
        return currentStatus;
    }

    private static void printBallAndStrike(Integer numberOfBall, Integer numberOfStrike) {
        if (numberOfBall == 0 && numberOfStrike == 0) {
            System.out.println(nothing);
        } else if (numberOfBall > 0 && numberOfStrike == 0) {
            System.out.println(numberOfBall + ball);
        } else if (numberOfBall == 0 && numberOfStrike > 0) {
            System.out.println(numberOfStrike + strike);
        } else {
            System.out.println(numberOfBall + ball + " " + numberOfStrike + strike);
        }
    }
}
