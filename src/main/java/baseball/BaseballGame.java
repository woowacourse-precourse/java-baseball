package baseball;

import java.util.Arrays;
import java.util.List;

import static constants.GameConstant.*;
public class BaseballGame {
    private final Player player;
    private final Computer computer;

    public BaseballGame() {
        player = new Player();
        computer = new Computer();
    }

    public void initializeGame() {
        computer.makeComputerNumber();
        playGame();
        checkRestart();
    }

    private void playGame() {
        List<String> playerNumber = Arrays.asList(player.getPlayerNumber().split(""));
        while(computer.isNotThreeStrike(playerNumber)) {
            computer.checkNumber(playerNumber);
            playerNumber = Arrays.asList(player.getPlayerNumber().split(""));;
        }
        printClearMessage();
    }

    private void printClearMessage() {
        System.out.printf("%d%s%n", GAME_NUMBER_LENGTH, STRIKE_MESSAGE);
        System.out.println(CLEAR_GAME_MESSAGE);
    }

    private void checkRestart() {
        int restartOrEndNumber = player.getRestartOrEndNumber();
        if (restartOrEndNumber == RESTART_NUMBER) {
            initializeGame();
        }
    }
}