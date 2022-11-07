package baseball;

import java.util.ArrayList;
import java.util.List;

public class ScoreCalculator {

    public static List<Integer> calScore(List<Integer> numComputer, List<Integer> input) {
        ArrayList<Integer> result = new ArrayList<>();

        result.add(calBallCount(numComputer, input));
        result.add(calStrikeCount(numComputer, input));

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
