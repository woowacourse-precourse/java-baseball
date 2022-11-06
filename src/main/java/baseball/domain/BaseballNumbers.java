package baseball.domain;

import baseball.dto.BaseballGameResult;
import java.util.HashSet;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class BaseballNumbers {
    private static final int BASEBALL_NUMBERS_SIZE = 3;
    private static final int BASEBALL_NUMBERS_START_INDEX = 0;
    private static final int BASEBALL_NUMBERS_END_INDEX = 2;

    List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateSize(baseballNumbers);
        validateDuplicate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validateSize(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != BASEBALL_NUMBERS_SIZE) {
            throw new BaseballGameException();
        }
    }

    private void validateDuplicate(List<BaseballNumber> baseballNumbers) {
        HashSet<BaseballNumber> nonDuplicateBaseballs = new HashSet<>(baseballNumbers);
        if (nonDuplicateBaseballs.size() != BASEBALL_NUMBERS_SIZE) {
            throw new BaseballGameException();
        }
    }

    public BaseballGameResult play(BaseballNumbers opponent) {
        int strike = calculateStrike(opponent);
        int ball = calculateBall(opponent, strike);
        return new BaseballGameResult(strike, ball);
    }

    private int calculateStrike(BaseballNumbers opponent) {
        return (int) IntStream.rangeClosed(BASEBALL_NUMBERS_START_INDEX, BASEBALL_NUMBERS_END_INDEX)
                .filter(isStrike(opponent))
                .count();
    }

    private IntPredicate isStrike(BaseballNumbers opponent) {
        return i -> opponent.baseballNumbers.get(i).equals(this.baseballNumbers.get(i));
    }

    private int calculateBall(BaseballNumbers opponent, int strike) {
        return (int) opponent.baseballNumbers.stream()
                .filter(this::isBall)
                .count() - strike;
    }

    private boolean isBall(BaseballNumber baseballNumber) {
        return this.baseballNumbers.contains(baseballNumber);
    }

}
