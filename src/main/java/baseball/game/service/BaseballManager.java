package baseball.game.service;

import baseball.game.io.BaseballGameOutput;

import java.util.List;

public class BaseballManager {

    public static void startGame() {
        BaseballGameOutput.printGameStart();
        while (true) {
            List<Integer> computerNumber = ComputerNumber.generate();
            InningManager.play(computerNumber);
        }
    }


}
