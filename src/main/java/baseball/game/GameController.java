package baseball.game;

import baseball.computer.Computer;
import baseball.constant.GameProcedureConstantString;
import baseball.output.Print;
import java.util.List;

public class GameController {

    public static void gameStart() {
        Print.printEndsWithEnter(GameProcedureConstantString.GAME_START_MESSAGE.getStringMessage());
        List<Integer> computerRandomNonDuplicateThreeLengthIntegerList = Computer.createThreeLengthIntegerList();
        GameLogic.doGameLogicUntilGameFinish(computerRandomNonDuplicateThreeLengthIntegerList);
    }
}
