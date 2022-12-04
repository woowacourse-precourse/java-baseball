package baseball.generator;

import java.util.List;

public abstract class RandomNumberGenerator {

    protected static final int RANGE_START_NUMBER = 1;
    protected static final int RANGE_END_NUMBER = 9;

    public List<Integer> generate(int resultSize) {
        validateResultSize(resultSize);
        return generateRandomNumber(resultSize);
    }

    private void validateResultSize(int resultSize) {
        if (resultSize < 0) {
            throw new IllegalArgumentException("잘못된 배열 크기입니다.");
        }
    }

    protected abstract List<Integer> generateRandomNumber(int resultSize);
}
