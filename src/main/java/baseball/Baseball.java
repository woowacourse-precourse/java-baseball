package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Baseball {
    private final Computer computer;
    private final Player player;
    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;

    Baseball() {
        computer = new Computer();
        player = new Player();
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
        this.computerNumbers = computer.getNumber();
    }

    private void setPlayerNumbers() {
        String playerNumber = InputView.inputPlayerNumber();
        player.validatePlayerNumber(playerNumber);

        this.playerNumbers = toIntegerList(playerNumber);
    }

    private List<Integer> toIntegerList(String playerNumber) {
        return Arrays.stream(playerNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void printHintMessage() {
        player.setHintCount(computerNumbers, playerNumbers);
        String hintMessage = player.getHintMessage();
        OutputView.printHintMessage(hintMessage);
    }

    private boolean isGameOver() {
        if (player.isMaxStrike()) {
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
        player.validateStateNumber(stateNumber);

        return stateNumber;
    }
}