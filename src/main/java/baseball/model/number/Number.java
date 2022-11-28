package baseball.model.number;

import baseball.exception.WrongNumberIndexException;
import baseball.exception.WrongNumberValueException;
import baseball.util.GameNumberConst;

public class Number {
    private final int index;
    private final int value;

    public Number(int index, int value) {
        validateIndex(index);
        this.index = index;

        validateValue(value);
        this.value = value;
    }

    private static void validateIndex(int index) {
        if (index < 0 || index >= GameNumberConst.NUMBER_SIZE) {
            throw new WrongNumberIndexException();
        }
    }

    private static void validateValue(int value) {
        if (value < GameNumberConst.MIN_NUMBER || value > GameNumberConst.MAX_NUMBER) {
            throw new WrongNumberValueException();
        }
    }

    public boolean hasOnlyDifferentIndexWith(Object obj) {
        if (obj instanceof Number) {
            Number other = (Number) obj;
            return (this.index != other.index) && (this.value == other.value);
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Number) {
            Number other = (Number) obj;
            return (this.index == other.index) && (this.value == other.value);
        }
        return false;
    }
}
