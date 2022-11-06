package baseball.domain;

import java.util.List;
import java.util.Objects;

public final class SingleNumber {

    private final int position;
    private final int number;

    public SingleNumber(int position, int number) {  // 유효성 검증은 받는 쪽에서.
        validateInputValue(number);
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

    private void validateInputValue(int inputValue) {
        validatePositiveNumber(inputValue);
        validateContainsZero(inputValue);
    }

    private void validatePositiveNumber(int inputValue) {
        if (inputValue < 0) {
            throw new IllegalArgumentException("양수만 입력해 주세요.");
        }
    }

    private void validateContainsZero(int inputValue) {
        if (inputValue == 0) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }
}
