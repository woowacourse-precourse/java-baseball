package baseball.gamePlay;

import baseball.domain.BallCount;
import baseball.domain.Numbers;
import baseball.rule.EndRule;
import baseball.rule.JudgementRule;
import baseball.strategy.NumberProducingStrategy;
import baseball.view.PrintResult;
import baseball.view.UserInput;

public class GamePlay {

    public static void play(NumberProducingStrategy numberProducingStrategy) {
        PrintResult.printStartMent();
        endProgramWhenPress2(numberProducingStrategy);
    }

    private static void endProgramWhenPress2(NumberProducingStrategy numberProducingStrategy) {
        while (true) {
            startGame(numberProducingStrategy);
            if (EndRule.isProgramEnd(UserInput.SelectRestartOrExit())) {
                return;
            }
        }
    }

    private static void startGame(NumberProducingStrategy numberProducingStrategy) {
        Numbers computerNumbers = new Numbers(numberProducingStrategy.produceNumbers());
        while (true) {
            Numbers userNumbers = new Numbers(UserInput.InputUserNumbers());
            if (continuegameUntilGetAnswer(computerNumbers, userNumbers)){
                return;
            }
        }
    }

    private static boolean continuegameUntilGetAnswer(Numbers computerNumbers,
        Numbers userNumbers) {
        BallCount ballCount = JudgementRule.makeBallCounts(computerNumbers, userNumbers);
        PrintResult.printBallCount(ballCount);
        return checkGetAnswer(ballCount);
    }

    private static boolean checkGetAnswer(BallCount ballCount) {
        if (EndRule.isGameEnd(ballCount)) {
            PrintResult.gameClearMent(EndRule.isGameEnd(ballCount));
            return true;
        }
        return false;
    }
}
