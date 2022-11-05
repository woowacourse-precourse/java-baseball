package baseball.game;

import baseball.constant.BallStrikeConstant;
import baseball.constant.GameProcedureConstantString;
import baseball.output.Print;
import baseball.refree.ResultHandler;
import baseball.refree.ResultPrinter;
import baseball.user.User;
import java.util.List;

public class GameLogic {

    public static void doGameLogicUntilGameFinish(List<Integer> computerRandomNonDuplicateIntegerList) {
        List<Integer> userNonDuplicateIntegerList = User.createUserNonDuplicateIntegerList();
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(computerRandomNonDuplicateIntegerList,
                userNonDuplicateIntegerList);
        ResultPrinter.printThisTurnResult(ballStrikeResult);
    }
}
