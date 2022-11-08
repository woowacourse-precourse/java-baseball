package baseball.controller;

import baseball.State;
import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Baseball {
    private final Computer computer;
    private final Player player;
    private final Hint hint;

    public Baseball() {
        computer = new Computer();
        player = new Player();
        hint = new Hint();
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
        player.setNumbers(playerNumber);
    }

    private void printHintMessage() {
        hint.setCount(computer.getNumbers(), player.getNumbers());
        OutputView.printHintMessage(hint.getMessage());
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

        return State.getState(stateNumber);
    }
}