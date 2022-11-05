package baseball.game;

import baseball.computer.Computer;
import baseball.constant.GameProcedureConstantString;
import baseball.output.Print;
import baseball.user.User;
import java.util.List;

public class GameController {

    public static void gameStart() {
        Print.printEndsWithEnter(GameProcedureConstantString.GAME_START_MESSAGE.getStringMessage());
        boolean isFinish = false;
        do {
            List<Integer> computerRandomNonDuplicateIntegerList = Computer.createNonDuplicateIntegerList();
            GameLogic.doGameLogicUntilGameFinish(computerRandomNonDuplicateIntegerList);
            isFinish = User.isGameFinish();
        } while (!isFinish);

    }
}
