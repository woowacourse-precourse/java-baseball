package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Baseball {
    private final Computer computer;
    private final Player player;
    private final SystemMessage systemMessage;
    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;

    Baseball() {
        computer = new Computer();
        player = new Player();
        systemMessage = new SystemMessage();
    }

    public void startGame() {
        systemMessage.printStart();
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
        systemMessage.printInputNumber();
        String playerNumber = Console.readLine();
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
        System.out.println(hintMessage);
    }

    private boolean isGameOver() {
        if(player.isMaxStrike()) {
            if (isStateShutDown()) {
                systemMessage.printGameOver();
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
        systemMessage.printInputState();
        String stateNumber = Console.readLine();
        player.validateStateNumber(stateNumber);

        return stateNumber;
    }
}