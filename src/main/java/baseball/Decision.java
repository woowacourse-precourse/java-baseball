package baseball;

import java.util.HashMap;

import static baseball.Constant.*;

public class Decision {
    public static void call() {
        HashMap<String, Integer> result = Score.getTotal();
        if (result.get(STRIKE) == 3) {
            PrintMessage.onlyStrikeCount();
            PrintMessage.gameEnd();
            return;
        }
        if (result.get(STRIKE) != 0 && result.get(BALL) != 0) {
            PrintMessage.ballAndStrikeCount();
            return;
        }

        if (result.get(STRIKE) == 0 && result.get(BALL) != 0) {
            PrintMessage.onlyBallCount();
            return;
        }
        if (result.get(STRIKE) != 0 && result.get(BALL) == 0) {
            PrintMessage.onlyStrikeCount();
            return;
        }
        PrintMessage.notThing();
    }


}
