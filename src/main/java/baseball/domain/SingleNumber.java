package baseball.domain;

import java.util.List;
import java.util.Objects;

public final class SingleNumber {

    private final int position;  // TODO position이랑 number를 따로 써볼까..?
    private final int number;    // TODO position 객체화 이점 > 0, 1, 2 세개만 캐싱 가능.

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public SingleNumber(int position, int number) {
        validateNumberRange(number);
        this.position = position;
        this.number = number;
    }

    public boolean isBall(List<SingleNumber> singleNumbers) {
        for (SingleNumber singleNumber : singleNumbers) {
            if ((position != singleNumber.position) && (number == singleNumber.number)) {
                return true;
            }
        }
        return false;
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
