package baseball.game;

import baseball.compare.ComparisonResultType;
import baseball.util.InputController;
import java.util.HashMap;

public class BaseballGame {

    private final InputController inputController;
    private final Integer boardSize;

    public BaseballGame(InputController inputController, Integer size) {
        this.inputController = inputController;
        this.boardSize = size;
    }

    private boolean checkSuccess(HashMap<ComparisonResultType, Integer> resultFrequencyCounter) {
        return resultFrequencyCounter.get(ComparisonResultType.STRIKE).equals(boardSize);
    }
}
