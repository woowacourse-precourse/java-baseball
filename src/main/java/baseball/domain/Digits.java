package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Digits {
    private final List<Digit> digitList;

    Digits() {
        this.digitList = new ArrayList<>();
    }

    public static Digits create() {
        return new Digits();
    }

    public int size() {
        return digitList.size();
    }

    public Digit getDigitInIndex(int index) {
        if (isOutsideOfTheRange(index)) {
            throw new IllegalArgumentException();
        }
        return digitList.get(index);
    }

    private boolean isOutsideOfTheRange(int index) {
        if (index < 0) {
            return true;
        }
        return index >= digitList.size();
    }

    public void append(Digit digit) {
        digitList.add(digit);
    }

    public void appendToLeft(Digit digit) {
        digitList.add(0, digit);
    }

    public boolean contains(Digit digit) {
        return digitList.contains(digit);
    }
}
