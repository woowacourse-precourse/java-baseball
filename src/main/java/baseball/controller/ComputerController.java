package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.OutputView;

import java.util.Arrays;
import java.util.List;

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
    RandomUtility randomUtility = new RandomUtility();
    OutputView outputView = new OutputView();

    public void startGame(GameNumber gameNumber) {
        List<Integer> computerNumbers = randomUtility.generateRandomNumbers();
        gameNumber.setComputerNumbers(computerNumbers);
    }

    public boolean proceedComputerToDo(GameNumber gameNumber) {
        List<Integer> playerNumbers = gameNumber.getPlayerNumbers();
        List<Integer> computerNumbers = gameNumber.getComputerNumbers();

        compareNumbers(playerNumbers, computerNumbers);

        return isThreeStrike();
    }

    public void compareNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        initCount();
        checkStrikeAndBall(playerNumbers, computerNumbers);
        provideHint();
    }

    private void initCount() {
        strikeCount = INIT_ZERO;
        ballCount = INIT_ZERO;
    }

    private void checkStrikeAndBall(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            countStrike(computerNumbers.get(i), playerNumbers.get(i));
            countBall(computerNumbers, playerNumbers.get(i), i);
        }
    }

    private void countStrike(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            strikeCount++;
        }
    }

    private void countBall(List<Integer> computerNumbers, int playerNumber, int numberIndex) {
        if (computerNumbers.get(numberIndex) != playerNumber && computerNumbers.contains(playerNumber)) {
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
