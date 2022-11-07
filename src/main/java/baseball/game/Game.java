package baseball.game;

import baseball.game.enums.Result;
import baseball.game.rule.Rule;
import baseball.game.rule.RuleChecker;
import baseball.game.rule.BallCountRule;
import baseball.game.rule.StrikeCountRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Game {
    private static boolean isNothing(Map<Result, Integer> guessResult) {
        return guessResult.get(Result.BALL) == 0 && guessResult.get(Result.STRIKE) == 0;
    }

    private static String getResultMessage(Map<Result, Integer> guessResult) {
        List<String> results = new ArrayList<>();

        Set<Map.Entry<Result, Integer>> entries = guessResult.entrySet();
        for (Map.Entry<Result, Integer> entry : entries) {
            Result key = entry.getKey();
            Integer value = entry.getValue();

            if (value != 0) {
                results.add(value + key.getValue());
            }
        }

        return String.join(" ", results);
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
