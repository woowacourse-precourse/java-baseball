package controller;

import model.Computer;
import view.Player;

public class BaseballGame {

    public void startGame() {
        while (Computer.getLengthOfNumber() < 3) {
            Computer.generateRandomNumber();
        }
        Player.startPhrase();
    }
}
