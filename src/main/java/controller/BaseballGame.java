package controller;

import model.Computer;
import model.PlayerRepository;
import view.Player;

public class BaseballGame {

    public static void startGame() {
        PlayerRepository playerRepository = new PlayerRepository();

        while (Computer.getLengthOfNumber() < 3) {
            Computer.generateRandomNumber();
        }
        Player.startPhrase();
        playerRepository.setPlayerNumber(Player.numberInput());
    }
}
