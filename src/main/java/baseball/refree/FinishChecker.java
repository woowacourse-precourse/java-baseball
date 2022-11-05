package baseball.refree;

import baseball.constant.BallStrikeConstant;

public class FinishChecker {
    public static boolean isFinish(BallStrikeConstant ballStrikeConstant) {
        return ballStrikeConstant.getIsFinish();
    }
}
