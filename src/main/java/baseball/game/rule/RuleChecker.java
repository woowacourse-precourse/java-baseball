package baseball.game.rule;

import baseball.game.enums.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleChecker {

    private RuleChecker() {
    }

    public static Map<Result, Integer> check(List<Rule> rules, Integer answer, Integer guess) {
        Map<Result, Integer> guessResult = new HashMap<>();

        for (Rule rule : rules) {
            guessResult.put(rule.getResult(), rule.check(answer, guess));
        }

        return guessResult;
    }
}
