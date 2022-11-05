package baseball.domain.number;

import java.util.List;
import java.util.Objects;

public final class SingleNumber {

    private final int position;
    private final int number;

    public SingleNumber(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public int countBall(List<SingleNumber> singleNumbers) {
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
}
