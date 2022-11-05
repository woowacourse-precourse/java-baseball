package baseball.game;

import baseball.computer.Computer;
import java.util.List;

public class GameController {

    public static void gameStart() {
        List<Integer> computerRandomNonDuplicateThreeLengthIntegerList = Computer.createThreeLengthIntegerList();
        GameLogic.doGameLogicUntilGameFinish(computerRandomNonDuplicateThreeLengthIntegerList);
    }
}
