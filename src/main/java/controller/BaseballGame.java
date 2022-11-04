package controller;

import baseball.BaseballException;
import model.Computer;
import model.PlayerRepository;
import view.Player;

public class BaseballGame {

    public static void startGame() {
        PlayerRepository playerRepository = new PlayerRepository();
        Computer computer = new Computer();
        boolean checkExit = false;
        String playerNumber;

        while (computer.getLengthOfNumber() < 3) {
            computer.generateRandomNumber();
        }

        Player.startPhrase();

        while (!checkExit) {
            playerNumber = Player.numberInput();
            if (checkException(playerNumber)) {
                break;
            }
            playerRepository.setPlayerNumber(playerNumber);
            checkExit = isCorrect(playerRepository, computer);
        }
    }

    public static boolean isCorrect(PlayerRepository playerRepository, Computer computer) {
        int userInput;
        int computerNumber;

        if (playerRepository.getPlayerNumber().equals("")) {
            return false;
        }

        userInput = Integer.parseInt(playerRepository.getPlayerNumber());

        computerNumber = computer.getComputerNumber();

        return userInput == computerNumber;
    }

    public static boolean checkException(String playerNumber) {
        try {
            BaseballException.InputLengthException(playerNumber);
            BaseballException.InputTypeBoundaryException(playerNumber);
            BaseballException.InputRepeatException(playerNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return true;
        }
        return false;
    }
}
