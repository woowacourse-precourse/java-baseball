package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class BaseballNumbers {
    public static final int BASEBALL_NUMBERS_SIZE = 3;
    private static final int BASEBALL_NUMBERS_START_INDEX = 0;
    private static final int BASEBALL_NUMBERS_END_INDEX = 2;

    private List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateSize(baseballNumbers);
        validateDuplicate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    @Override
    public String toString() {
        return baseballNumbers.toString();
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
        int strikeCount = calculateStrikeCount(opponent);
        int ballCount = calculateBallCount(opponent, strikeCount);
        return BaseballGameResult.toEnum(Strike.valueOf(strikeCount), Ball.valueOf(ballCount));
    }

    private int calculateStrikeCount(BaseballNumbers opponent) {
        return (int) IntStream.rangeClosed(BASEBALL_NUMBERS_START_INDEX, BASEBALL_NUMBERS_END_INDEX)
                .filter(isStrike(opponent))
                .count();
    }

    private IntPredicate isStrike(BaseballNumbers opponent) {
        return i -> opponent.baseballNumbers.get(i).equals(this.baseballNumbers.get(i));
    }

    private int calculateBallCount(BaseballNumbers opponent, int strikeCount) {
        return (int) opponent.baseballNumbers.stream()
                .filter(this::isBall)
                .count() - strikeCount;
    }

    private boolean isBall(BaseballNumber baseballNumber) {
        return this.baseballNumbers.contains(baseballNumber);
    }

}
