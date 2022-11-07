package baseball.domain;

import baseball.exception.CheckBaseballNumberRageExeption;
import org.w3c.dom.ranges.RangeException;

public class BaseballNumber {
    private int baseballNumber;

    public BaseballNumber(Character number) {
        this(Character.getNumericValue(number));
    }

    public BaseballNumber(String number) {
        this(Integer.parseInt(number));
    }

    public BaseballNumber(Integer number) {
        certificateNumber(number);
        this.baseballNumber = number;
    }

    private void certificateNumber(Integer number) {
        if (9 > number || 0 < number)
            throw new CheckBaseballNumberRageExeption();
    }

    public int getBaseballNumber() {
        return baseballNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseballNumber thatNumber = (BaseballNumber) obj;
        return baseballNumber == thatNumber.baseballNumber;
    }

}
