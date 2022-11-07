package baseball.game;

import baseball.game.enums.Result;
import baseball.game.rule.Rule;
import baseball.game.rule.RuleChecker;
import baseball.game.rule.BallCountRule;
import baseball.game.rule.StrikeCountRule;

import java.util.List;
import java.util.Map;

public class Game {
    private static boolean isNothing(Map<Result, Integer> guessResult) {
        return guessResult.get(Result.BALL) == 0 && guessResult.get(Result.STRIKE) == 0;
    }


    private static Map<Result, Integer> validateGuess(Integer answer, Integer guess) {
        // should keep this list element order for correct console output
        List<Rule> scoreRules = List.of(
                BallCountRule.getInstance(),
                StrikeCountRule.getInstance()
        );

        Map<Result, Integer> guessResult = RuleChecker.check(scoreRules, answer, guess);

        return guessResult;
    }
}
