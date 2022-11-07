package baseball.game;

import baseball.numbers.BallTypes;
import baseball.numbers.Numbers;
import baseball.numbers.NumbersGenerationStrategy;
import baseball.ui.InputView;
import baseball.ui.Result;

import java.util.EnumMap;
import java.util.Map;

import static baseball.ui.OutputView.*;

public class BaseballGame {
    private static final int GAME_OVER_STRIKE_COUNT = 3;

    private final NumbersGenerationStrategy strategy;

    public BaseballGame(NumbersGenerationStrategy strategy) {
        this.strategy = strategy;
    }

    public void start() {
        printGameStartMessage();
        Numbers answer = new Numbers(strategy);
        Map<BallTypes, Integer> result = new EnumMap<>(BallTypes.class);

        game(answer, result);
        decideRestartOrEnd();
    }

    private void game(Numbers answer, Map<BallTypes, Integer> result) {
        while (inProgress(result)) {
            Numbers numbers = new Numbers(InputView.numbers());
            result = answer.compare(numbers);
            printCompareResult(new Result(result));
        }
    }

    private boolean inProgress(Map<BallTypes, Integer> result) {
        int strike = result.getOrDefault(BallTypes.STRIKE, 0);
        return strike != GAME_OVER_STRIKE_COUNT;
    }

    private void decideRestartOrEnd() {
        if (isGameOver()) {
            printGameOverMessage();
            return;
        }
        start();
    }

    private boolean isGameOver() {
        return InputView.decision() == Decision.END;
    }
}
