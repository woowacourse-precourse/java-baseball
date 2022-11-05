package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Baseball {
    private final Computer computer;
    private final Player player;
    private final SystemMessage systemMessage;
    private List<Integer> computerNumbers;
    private String playerNumber;

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
            setPlayerNumber();
            printHintMessage();
        }
    }

    private void setComputerNumbers() {
        computerNumbers = computer.getNumber();
    }

    private void setPlayerNumber() {
        systemMessage.printInputNumber();
        String playerNumber = Console.readLine();
        player.validatePlayerNumber(playerNumber);

        this.playerNumber = playerNumber;
    }

    private void printHintMessage() {
        player.setHintCount(computerNumbers, playerNumber);
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
        return Config.STATE_SHUTDOWN.equals(stateNumber);
    }

    private String getStateNumber() {
        systemMessage.printInputState();
        String stateNumber = Console.readLine();
        player.validateStateNumber(stateNumber);

        return stateNumber;
    }
}