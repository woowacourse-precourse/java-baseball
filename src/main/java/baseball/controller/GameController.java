package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private static final String WRONG_ANSWER_INPUT_MESSAGE = "1 혹은 2만 입력 가능합니다.";
    private static final String BASEBALL_GAME_RESTART_ANSWER = "1";
    private static final String BASEBALL_GAME_END_ANSWER = "2";
    GameNumber gameNumber = new GameNumber();
    ComputerController computerController = new ComputerController();
    NumberValidator numberValidator = new NumberValidator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void proceedGame() {
        boolean gameState = true;

        while (gameState) {
            outputView.printStartGame();
            computerController.startGame(gameNumber);
            repeatGuessingAnswer();
            gameState = askRestartGame();
        }
    }

    private void repeatGuessingAnswer() {
        boolean correctAnswer = false;

        while (!correctAnswer) {
            setAndSavePlayerNumbers();
            correctAnswer = computerController.proceedComputerToDo(gameNumber);
            sendEndMessageIfTrue(correctAnswer);
        }
    }

    private void setAndSavePlayerNumbers() {
        gameNumber.setPlayerInput(inputView.enterGameNumber());
        List<Integer> playerNumbers = numberValidator.toValidateData(gameNumber.getPlayerInput());
        gameNumber.setPlayerNumbers(playerNumbers);
    }

    private void sendEndMessageIfTrue(boolean correctAnswer) {
        if (correctAnswer) {
            outputView.printEndGame();
        }
    }

    private boolean askRestartGame() {
        String answer = inputView.enterAnswerRestartGame();
        return wantRestartGame(answer);
    }

    public boolean wantRestartGame(String answer) {
        if (answer.equals(BASEBALL_GAME_RESTART_ANSWER)) {
            return true;
        } else if (answer.equals(BASEBALL_GAME_END_ANSWER)) {
            return false;
        }

        throw new IllegalArgumentException(WRONG_ANSWER_INPUT_MESSAGE);
    }
}
