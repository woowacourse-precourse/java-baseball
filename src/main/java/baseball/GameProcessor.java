package baseball;

import java.util.List;
import java.util.stream.IntStream;

public class GameProcessor {

    private int strikeCount;
    private int ballCount;

    public boolean isThreeStrike(List<Integer> computerNumbers, List<Integer> userInputNumbers) {
        getStrikeCount(computerNumbers, userInputNumbers);
        getBallCount(computerNumbers, userInputNumbers);
        return isGameOver();
    }

    private boolean isGameOver() {
        if (strikeCount == 3) {
            return true;
        }
        return false;
    }

    private int getStrikeCount(List<Integer> computerNumbers, List<Integer> userInputNumbers) {
        return strikeCount = (int) IntStream.range(0, 3)
                .filter(i -> computerNumbers.get(i) == userInputNumbers.get(i))
                .count();
    }

    private int getBallCount(List<Integer> computerNumbers, List<Integer> userInputNumbers) {
        return ballCount = (int) IntStream.range(0, 3)
                .filter(i -> computerNumbers.get(i) != userInputNumbers.get(i)
                        && computerNumbers.contains(userInputNumbers.get(i)))
                .count();
    }
}
