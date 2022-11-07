package baseball.game.service;

import baseball.game.io.BaseballGameInput;
import baseball.game.model.Count;

import java.util.List;

public class InningManager {

    public static void play(List<Integer> computerNumber) {
        boolean isCorrect = false;

        while (!isCorrect) {
            List<Integer> userNumber = UserNumber.generate(BaseballGameInput.getUserNumber());
            Count count = new Count(computerNumber, userNumber);
        }
    }


}

