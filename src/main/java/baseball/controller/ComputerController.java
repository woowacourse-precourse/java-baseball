package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class ComputerController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private int strikeCount;
    private int ballCount;

    public void startGame(GameNumber gameNumber) {
        outputView.printStartGame();
        gameNumber.setComputerNumbers();
        String inputNumber = Console.readLine();
        gameNumber.setInputString(inputNumber);

        compareNumbers(gameNumber);
        provideHint();
    }

    public void compareNumbers(GameNumber gameNumber) {
        int[] playerNumbers = gameNumber.getPlayerNumbers();
        int[] computerNumbers = gameNumber.getComputerNumbers();
        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            countStrike(computerNumbers, playerNumbers[i], i);
            countBall(computerNumbers, playerNumbers[i], i);
        }
    }

    private void countStrike(int[] computerNumbers, int playerNumber, int numberIndex) {
        if (computerNumbers[numberIndex] == playerNumber) {
            strikeCount++;
        }
    }

    private void countBall(int[] computerNumbers, int playerNumber, int numberIndex) {
        if ((computerNumbers[numberIndex] != playerNumber) && Arrays.stream(computerNumbers).anyMatch(number -> number == playerNumber)) {
            ballCount++;
        }
    }

    private void provideHint() {
        String hintMessage = "";

        if (ballCount > 0) {
            hintMessage = hintMessage + ballCount + BALL_MESSAGE + ' ';
        }

        if (strikeCount > 0) {
            hintMessage = hintMessage + strikeCount + STRIKE_MESSAGE + ' ';
        }

        if (ballCount == 0 && strikeCount == 0) {
            hintMessage += NOTHING_MESSAGE;
        }

        System.out.println(hintMessage);
    }
}
