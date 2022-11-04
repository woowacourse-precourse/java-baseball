package baseball.model;

import java.util.List;

public class GameResult {

    private final int ballCount;
    private final int strikeCount;

    public GameResult(List<Integer> answerNums, List<Integer> playerNums) {
        ballCount = 0;
        strikeCount = 0;
    }

    public boolean isSameStrikeCount(int strikeCount) {
        return this.strikeCount == strikeCount;
    }
}
