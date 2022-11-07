package baseball.game.service;

import java.util.List;

public class BaseballManager {

    public static void startGame() {
        while (true) {
            List<Integer> computerNumber = ComputerNumber.generate();
            InningManager.play(computerNumber);
        }
    }


}
