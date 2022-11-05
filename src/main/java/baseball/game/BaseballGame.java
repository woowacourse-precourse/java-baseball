package baseball.game;

import baseball.board.NumberBoard;
import baseball.compare.ComparisonResultType;
import baseball.util.InputController;
import baseball.util.Logger;
import java.util.HashMap;
import java.util.List;

public class BaseballGame {

    private final List<Integer> opponentNumbers;

    public BaseballGame(List<Integer> opponentNumbers) {
        this.opponentNumbers = opponentNumbers;
    }

    private Integer getBoardSize() {
        return this.opponentNumbers.size();
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

        List<Integer> userNumbers = InputController.getEachNumber(getBoardSize());
        validateNumberInput(userNumbers);

        NumberBoard numberBoard = new NumberBoard();
        HashMap<ComparisonResultType, Integer> resultFrequencyCounter =
                numberBoard.compareNumbers(userNumbers, opponentNumbers);

        Logger.log(numberBoard.getResultMessage());

        if (checkSuccess(resultFrequencyCounter)) {
            Logger.log(getBoardSize() + BaseballConstants.SUCCESS_MESSAGE);
            return true;
        }

        return false;
    }

    private boolean checkSuccess(HashMap<ComparisonResultType, Integer> resultFrequencyCounter) {
        return resultFrequencyCounter.containsKey(ComparisonResultType.STRIKE) && resultFrequencyCounter.get(
                ComparisonResultType.STRIKE).equals(getBoardSize());
    }

    private void validateNumberInput(List<Integer> inputNumbers) throws IllegalArgumentException {
        for (Integer number : inputNumbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException();
            }
        }
    }
}
