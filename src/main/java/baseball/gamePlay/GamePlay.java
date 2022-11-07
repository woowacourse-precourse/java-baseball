package baseball.gamePlay;

import baseball.domain.BallCount;
import baseball.rule.EndRule;
import baseball.view.PrintResult;

public class GamePlay {
    private static boolean checkGetAnswer(boolean isGameEnd, BallCount ballCount) {
        if (EndRule.isGameEnd(ballCount)) {
            PrintResult.gameClearMent(EndRule.isGameEnd(ballCount));
            isGameEnd = EndRule.isGameEnd(ballCount);
        }
        return isGameEnd;
    }
}
