package baseball.domain;

import java.util.List;
import java.util.Objects;

public final class SingleNumber {

    private final int position;
    private final int number;

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public SingleNumber(int position, int number) {  // 유효성 검증은 받는 쪽에서.
        validateNumberRange(number);
        this.position = position;
        this.number = number;
    }

    public int judgeBall(List<SingleNumber> singleNumbers) {
        for (SingleNumber singleNumber : singleNumbers) {
            if ((position != singleNumber.position) && (number == singleNumber.number)) {
                return 1;
            }
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleNumber that = (SingleNumber) o;
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
