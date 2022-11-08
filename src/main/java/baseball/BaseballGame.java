package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

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

    public static void validateInputNumber(String playerNumber) throws IllegalArgumentException {
        validateNumberOrNotNumber(playerNumber, PATTERN);
        validateNumberLength(playerNumber, constants.GameConstant.GAME_NUMBER_LENGTH);
        validateNumberRepeat(playerNumber);
    }

    public static void validateNumberOrNotNumber(String playerNumber, String regexPattern) {
        boolean regex = Pattern.matches(regexPattern, playerNumber);
        if (!regex) {
            throw new IllegalArgumentException();
        }
    }


    public static void validateNumberLength(String playerNumber, int numberLength) {
        if (playerNumber.length() != numberLength) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberRepeat(String playerNumber) {
        HashSet<String> setNumber = new HashSet<>(
                Arrays.asList(playerNumber.split(""))
        );
        if (setNumber.size() != playerNumber.length()) {
            throw new IllegalArgumentException();
        }
    }

}