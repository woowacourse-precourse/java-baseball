package baseball.refree;

import baseball.constant.BallStrikeConstant;
import baseball.constant.GameProcedureConstantInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ResultHandler {

    public static BallStrikeConstant createBallStrikeResult(List<Integer> computerRandomNonDuplicateIntegerList, List<Integer> userNonDuplicateIntegerList) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < GameProcedureConstantInteger.BASEBALL_GAME_NUMBER_LENGTH.getIntegerValue(); i++) {
            ballCount += ballCountCollector(i, computerRandomNonDuplicateIntegerList, userNonDuplicateIntegerList);
            strikeCount += strikeCountCollector(i, computerRandomNonDuplicateIntegerList, userNonDuplicateIntegerList);
        }

        return BallStrikeConstant.getResult(ballCount, strikeCount);
    }

    private static int strikeCountCollector(int index, List<Integer> computerRandomNonDuplicateIntegerList,
                                            List<Integer> userNonDuplicateIntegerList) {
        int resultCount = 0;
        if (Objects.equals(computerRandomNonDuplicateIntegerList.get(index), userNonDuplicateIntegerList.get(index))) {
            resultCount += 1;
        }
        return resultCount;
    }

    private static int ballCountCollector(int index, List<Integer> computerRandomNonDuplicateIntegerList,
                                          List<Integer> userNonDuplicateIntegerList) {
        List<Integer> exceptForIndex = new ArrayList<>();

        for (int i = 0; i < GameProcedureConstantInteger.BASEBALL_GAME_NUMBER_LENGTH.getIntegerValue(); i++) {
            exceptForIndex.add(i);
        }
        int resultCount = 0;

        exceptForIndex.remove(index);

        for (Integer idx :
                exceptForIndex) {
            if (Objects.equals(computerRandomNonDuplicateIntegerList.get(index), userNonDuplicateIntegerList.get(idx))) {
                resultCount += 1;
            }
        }
        return resultCount;

    }
}
