package baseball.controller;

import baseball.constant.Constant;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BaseballController {
    private Player player = new Player();
    private Computer computer = new Computer();

    public void run() {
        OutputView.printStartGame();
        startGame();
    }

    private void startGame() {
        List<Integer> randomNumbers = computer.makeRandomNumbers();
        while (!isRightAnswer()) {
            InputView.requestPlayerInput();
            String stringPlayerInput = player.enterPlayerInput();
            List<Integer> playerInputs = integerListOf(stringPlayerInput);
            printResultOf(randomNumbers, playerInputs);
        }
        restartGameIfPlayerWant();
    }

    private boolean isRightAnswer() {
        return computer.isAnswer();
    }

    private List<Integer> integerListOf(String input) {
        List<Integer> playerInputs = new ArrayList<>();
        for (int i = 0; i < Constant.SIZE_NUMBER; i++) {
            playerInputs.add(Character.getNumericValue(input.charAt(i)));
        }
        return playerInputs;
    }

    private void printResultOf(List<Integer> randomNumbers, List<Integer> playerInputs) {
        String hintResult = hintResult(randomNumbers, playerInputs);
        OutputView.printHintResult(hintResult);
    }

    private String hintResult(List<Integer> randomNumbers, List<Integer> playerInputs) {
        return computer.resultOfGame(playerInputs, randomNumbers);
    }

    private void restartGameIfPlayerWant() {
        OutputView.printRightAnswer();
        InputView.requestMoreGame();
        String restartInput = player.enterRestartInput();
        if (restartInput.equals(Constant.RESTART_GAME)) {
            startGame();
        }
    }
}
