package controller;

import model.Computer;

public class BaseballGame {

    public void startGame() {
        while (Computer.getLengthOfNumber() < 3) {
            Computer.generateRandomNumber();
        }
    }
}
