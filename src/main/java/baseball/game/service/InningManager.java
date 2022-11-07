package baseball.game.service;

import baseball.game.io.BaseballGameInput;

import java.util.List;

public class InningManager {

    public static void play(List<Integer> computerNumber) {
        boolean isCorrect = false;

        while (!isCorrect) {
            List<Integer> userNumber = UserNumber.generate(BaseballGameInput.getUserNumber());
        }
    }


}

