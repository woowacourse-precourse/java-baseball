package baseball.controller;

import baseball.model.ComputerNumberGenerator;

import java.util.List;

public class BaseballGame {

    public void playTheGame() {
        do {
            startGame();
        } while (!exit());
    }

    private static void startGame() {
//        List<Integer> numberGeneratedByComputer = new ComputerNumberGenerator();


    }

    private static boolean exit() {
        return true;
    }
}
