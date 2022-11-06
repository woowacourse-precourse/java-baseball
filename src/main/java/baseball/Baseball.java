package baseball;

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

    Baseball() {
        computer = new Computer();
        player = new Player();
        hint = new Hint();
        inputValidator = new InputValidator();
    }

    public void startGame() {
        OutputView.printStart();
        playGame();
    }

    private void playGame() {
        setComputerNumbers();

        while (!isGameOver()) {
            setPlayerNumbers();
            printHintMessage();
        }
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

    private boolean isGameOver() {
        if (hint.isMaxStrike()) {
            if (isStateShutDown()) {
                OutputView.printGameOver();
                return true;
            }

            setComputerNumbers();
            return false;
        }
        return false;
    }

    private boolean isStateShutDown() {
        String stateNumber = getStateNumber();
        return State.SHUTDOWN.getNumber().equals(stateNumber);
    }

    private String getStateNumber() {
        String stateNumber = InputView.inputStateNumber();
        inputValidator.validateStateNumber(stateNumber);

        return stateNumber;
    }
}