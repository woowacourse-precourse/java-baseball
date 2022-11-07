package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class ComputerController {
    GameNumber gameNumber = new GameNumber();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private int strikeCount;
    private int ballCount;

    public void startGame() {
        outputView.printStartGame();
        gameNumber.setComputerNumbers();
        String inputNumber = Console.readLine();
        gameNumber.setInputString(inputNumber);
        int[] playerNumbers = gameNumber.getPlayerNumbers();
        System.out.println("playerNumbers : " + Arrays.toString(gameNumber.getPlayerNumbers()));
        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            countStrike(playerNumbers[i], i);
            countBall(playerNumbers[i], i);
        }

        System.out.println("strick : " + strikeCount + ", ball : " + ballCount);
    }

    private void countStrike(int playerNumber, int numberIndex) {
        if (gameNumber.getComputerNumbers()[numberIndex] == playerNumber) {
            strikeCount++;
        }
    }

    private void countBall(int playerNumber, int numberIndex) {
        int[] computerNumbers = gameNumber.getComputerNumbers();
        if ((computerNumbers[numberIndex] != playerNumber) && Arrays.stream(computerNumbers).anyMatch(number -> number == playerNumber)) {
            ballCount++;
        }
    }
}
