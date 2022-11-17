package baseball.refree;

import baseball.constant.BallStrikeConstant;
import baseball.constant.GameProcedureConstantString;
import baseball.output.Print;

public class ResultPrinter {
    public static void printThisTurnResult(BallStrikeConstant ballStrikeConstant) {
        Print.printEndsWithEnter(ballStrikeConstant.getBallStrikeMessage());
        if (ballStrikeConstant.getIsFinish()) {
            Print.printEndsWithEnter(GameProcedureConstantString.THIS_TURN_FINISH_GAME_MESSAGE.getStringMessage());
        }
    }
}
