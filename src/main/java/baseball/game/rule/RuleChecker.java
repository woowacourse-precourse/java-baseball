package baseball.game.rule;

import baseball.game.enums.GuessTarget;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RuleChecker {

    private RuleChecker() {
    }

    public static Map<GuessTarget, Integer> check(List<Rule> rules, String answer, String guess) {
        Map<GuessTarget, Integer> guessResult = new LinkedHashMap<>();

        for (Rule rule : rules) {
            guessResult.put(rule.getResult(), rule.check(answer, guess));
        }

        return guessResult;
    }
}
