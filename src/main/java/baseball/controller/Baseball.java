package baseball.controller;

import baseball.State;
import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.Player;
import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Baseball {
    private final Computer computer;
    private final Player player;
    private final Hint hint;
    private final InputValidator inputValidator;

    public Baseball() {
        computer = new Computer();
        player = new Player();
        hint = new Hint();
        inputValidator = new InputValidator();
    }

    public void startGame() {
        OutputView.printStart();

        do {
            setComputerNumbers();
            playGame();
            OutputView.printGameOver();
        } while (!isShutdown());
    }

    private void playGame() {
        do {
            setPlayerNumbers();
            printHintMessage();
        } while (!hint.isMaxStrike());
    }

    private void setComputerNumbers() {
        computer.setNumbers();
    }

    private void setPlayerNumbers() {
        String playerNumber = InputView.inputPlayerNumber();
        inputValidator.validatePlayerNumber(playerNumber);
        player.setNumbers(playerNumber);
    }

    private void printHintMessage() {
        hint.setCount(computer.getNumbers(), player.getNumbers());
        String hintMessage = hint.getMessage();
        OutputView.printHintMessage(hintMessage);
    }

    private boolean isShutdown() {
        if (getState().isStart()) {
            return false;
        }

        OutputView.printShutdown();
        return true;
    }

    private State getState() {
        String stateNumber = InputView.inputStateNumber();
        inputValidator.validateStateNumber(stateNumber);

        return State.getState(stateNumber);
    }
}