package baseball.gamePlay;

import baseball.domain.BallCount;
import baseball.domain.Numbers;
import baseball.rule.EndRule;
import baseball.rule.JudgementRule;
import baseball.view.PrintResult;

public class GamePlay {

    private static boolean continuegameUntilGetAnswer(Numbers computerNumbers, boolean isGameEnd,
        Numbers userNumbers) {
        BallCount ballCount = JudgementRule.makeBallCounts(computerNumbers, userNumbers);
        PrintResult.printBallCount(ballCount);
        return checkGetAnswer(isGameEnd, ballCount);
    }

    private static boolean checkGetAnswer(boolean isGameEnd, BallCount ballCount) {
        if (EndRule.isGameEnd(ballCount)) {
            PrintResult.gameClearMent(EndRule.isGameEnd(ballCount));
            isGameEnd = EndRule.isGameEnd(ballCount);
        }
        return isGameEnd;
    }
}
