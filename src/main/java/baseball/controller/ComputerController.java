package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class ComputerController {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final int BASEBALL_SUCCESS_STRIKE_COUNT = 3;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private int strikeCount;
    private int ballCount;

    public void startGame(GameNumber gameNumber) {
        gameNumber.setComputerNumbers();
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

    public void provideHint() {
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

    public boolean isThreeStrike() {
        return strikeCount == BASEBALL_SUCCESS_STRIKE_COUNT;
    }
}
