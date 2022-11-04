package controller;

import model.Computer;
import model.PlayerRepository;
import view.Player;

public class BaseballGame {

    public static void startGame() {
        PlayerRepository playerRepository = new PlayerRepository();
        Computer computer = new Computer();

        while (computer.getLengthOfNumber() < 3) {
            computer.generateRandomNumber();
        }

        Player.startPhrase();

        while (!isCorrect(playerRepository, computer)) {
            playerRepository.setPlayerNumber(Player.numberInput());

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


}
