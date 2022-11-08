package baseball.domain.baseball_number;

import java.util.List;
import java.util.Objects;

public final class BaseballNumber {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private final int position;
    private final int number;

    BaseballNumber(int position, int number) {
        validateNumberRange(number);
        this.position = position;
        this.number = number;
    }

    public boolean equalsOnlyNumber(List<BaseballNumber> baseballNumbers) {
        for (BaseballNumber baseballNumber : baseballNumbers) {
            if ((position != baseballNumber.position) && (number == baseballNumber.number)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return position == that.position && number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

    private void validateNumberRange(int inputValue) {
        if (inputValue < MIN_VALUE || MAX_VALUE < inputValue) {
            throw new IllegalArgumentException("입력 숫자의 범위는 1~9 입니다.");
        }
    }
}
