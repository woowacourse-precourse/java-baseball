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
    private static final int TOTAL_BASEBALL_COUNT = 3;

    private final NumbersGenerationStrategy strategy;

    public BaseballGame(NumbersGenerationStrategy strategy) {
        printGameStartMessage();
        this.strategy = strategy;
    }

    public void start() {
        Numbers answer = new Numbers(strategy);
        game(answer);
        restartOrEnd();
    }

    private void game(Numbers answer) {
        Map<BallTypes, Integer> compareResult = new EnumMap<>(BallTypes.class);

        while (inProgress(compareResult)) {
            Numbers userNumbers = new Numbers(InputView.numbers());
            compareResult = answer.compare(userNumbers);
            printCompareResult(new Result(compareResult));
        }
        printGameOverMessage();
    }

    private boolean inProgress(Map<BallTypes, Integer> compareResult) {
        int strike = compareResult.getOrDefault(BallTypes.STRIKE, 0);
        return strike != TOTAL_BASEBALL_COUNT;
    }

    private void restartOrEnd() {
        if (InputView.decision() == Decision.RE_GAME) {
            start();
        }
    }
}
