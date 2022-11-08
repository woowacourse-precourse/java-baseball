package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class ComputerController {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final int BASEBALL_SUCCESS_STRIKE_COUNT = 3;
    private static final int INIT_ZERO = 0;
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String NULL_MESSAGE = "";
    private static final String SPACING_MESSAGE = " ";
    private int strikeCount;
    private int ballCount;
    OutputView outputView = new OutputView();

    public void startGame(GameNumber gameNumber) {
        gameNumber.setComputerNumbers();
    }

    public void compareNumbers(GameNumber gameNumber) {
        int[] playerNumbers = gameNumber.getPlayerNumbers();
        int[] computerNumbers = gameNumber.getComputerNumbers();
        initCount();
        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            countStrike(computerNumbers, playerNumbers[i], i);
            countBall(computerNumbers, playerNumbers[i], i);
        }
    }

    private void initCount() {
        strikeCount = INIT_ZERO;
        ballCount = INIT_ZERO;
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

        hintMessage += getBallHintMessage();
        hintMessage += getStrikeHintMessage();
        hintMessage += getNotingHintMessage();

        outputView.printBaseballHint(hintMessage);
    }

    private String getBallHintMessage() {
        if (ballCount > 0) {
            return ballCount + BALL_MESSAGE + SPACING_MESSAGE;
        }

        return NULL_MESSAGE;
    }

    private String getStrikeHintMessage() {
        if (strikeCount > 0) {
            return strikeCount + STRIKE_MESSAGE + SPACING_MESSAGE;
        }

        return NULL_MESSAGE;
    }

    private String getNotingHintMessage() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING_MESSAGE;
        }

        return NULL_MESSAGE;
    }

    public boolean isThreeStrike() {
        return strikeCount == BASEBALL_SUCCESS_STRIKE_COUNT;
    }
}
