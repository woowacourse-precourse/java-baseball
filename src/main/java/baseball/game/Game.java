package baseball.game;

import baseball.game.enums.Result;
import baseball.game.rule.Rule;
import baseball.game.rule.RuleChecker;
import baseball.game.rule.BallCountRule;
import baseball.game.rule.StrikeCountRule;
import baseball.game.util.GameUtil;
import baseball.system.util.SystemUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static baseball.game.message.GameMessage.*;
import static baseball.game.util.GameUtil.STRIKE_OUT_COUNT;

public class Game {

    private static final SystemUtil systemUtil = SystemUtil.getInstance();
    private static final GameUtil gameUtil = GameUtil.getInstance();

    public static void start() {
        Integer answer = gameUtil.getRandomNumber();

        while (true) {
            Integer guess = gameUtil.getUserInput();

            Map<Result, Integer> guessResult = validateGuess(answer, guess);
            printResult(guessResult);

            if (isStrikeOut(guessResult)) {
                return;
            }
        }
    }


    private static boolean isStrikeOut(Map<Result, Integer> guessResult) {
        return guessResult.get(Result.STRIKE) == STRIKE_OUT_COUNT;
    }

    private static void printResult(Map<Result, Integer> guessResult) {
        if (isNothing(guessResult)) {
            systemUtil.print(NOTHING);
            return;
        }

        String resultString = getResultMessage(guessResult);
        systemUtil.print(resultString);
    }

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
