package domain;

import constant.Messages;

import java.util.List;

public class Number {
    private int number;

    public Number(int number) {
        isValidNumber(number);
        this.number = number;
    }

    private void isValidNumber(int number) {
        if(number < 1 || 9 < number) throw new IllegalArgumentException(Messages.rangeOut);
    }
}
