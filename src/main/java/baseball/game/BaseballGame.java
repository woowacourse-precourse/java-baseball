package baseball.game;

import baseball.board.NumberBoard;
import baseball.compare.ComparisonResultType;
import baseball.util.InputController;
import baseball.util.Logger;
import baseball.util.RandomGenerator;
import java.util.HashMap;
import java.util.List;

public class BaseballGame {

    private final InputController inputController;
    private final Integer boardSize;
    private final List<Integer> opponentNumbers;

    public BaseballGame(InputController inputController, Integer size) {
        this.inputController = inputController;
        this.boardSize = size;
        this.opponentNumbers = new RandomGenerator().genNumberList(size);
    }

    public void play() {
        start();

        while (true) {
            boolean isSuccess = tryGuess();

            if (isSuccess) {
                break;
            }
        }

        end();
    }

    private void start() {
        Logger.log(BaseballConstants.START_MESSAGE);
    }

    private void end() {
        Logger.log(BaseballConstants.END_MESSAGE);
    }

    private boolean tryGuess() {
        Logger.log(BaseballConstants.INPUT_MESSAGE);

        List<Integer> userNumbers = inputController.getEachNumber(boardSize);
        validateNumberInput(userNumbers);

        NumberBoard numberBoard = new NumberBoard();

        if (checkSuccess(numberBoard.compareNumbers(userNumbers, opponentNumbers))) {
            Logger.log(boardSize + BaseballConstants.SUCCESS_MESSAGE);
            return true;
        }

        return false;
    }

    private boolean checkSuccess(HashMap<ComparisonResultType, Integer> resultFrequencyCounter) {
        return resultFrequencyCounter.containsKey(ComparisonResultType.STRIKE) && resultFrequencyCounter.get(
                ComparisonResultType.STRIKE).equals(boardSize);
    }

    private void validateNumberInput(List<Integer> inputNumbers) throws IllegalArgumentException {
        for (Integer number : inputNumbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException();
            }
        }
    }
}
