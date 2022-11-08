package baseball;

import java.util.EnumMap;
import java.util.List;

public class ScoreCalculator {

    public enum BallOrStrike {
        BALL,
        STRIKE
    }

    public static EnumMap<BallOrStrike, Integer> calScore(List<Integer> numComputer, List<Integer> input) {
        EnumMap<BallOrStrike, Integer> result = new EnumMap<>(BallOrStrike.class);

        result.put(BallOrStrike.BALL, calBallCount(numComputer, input));
        result.put(BallOrStrike.STRIKE, calStrikeCount(numComputer, input));

        return result;
    }

    private static int calBallCount(List<Integer> numComputer, List<Integer> input) {
        int ballCount = 0;
        for (int i = 0; i < input.size(); i++) {
            int curInputDigit = input.get(i);
            int curComputerDigit = numComputer.get(i);

            if (numComputer.contains(curInputDigit) && (curInputDigit != curComputerDigit)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private static int calStrikeCount(List<Integer> numComputer, List<Integer> input) {
        int strikeCount = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == numComputer.get(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

}
