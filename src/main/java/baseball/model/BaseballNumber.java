package baseball.model;

import baseball.util.Errors;



public class BaseballNumber {

    private final int number;

    private BaseballNumber(int number) {
        validateSize(number);
        this.number = number;
    }

    public static BaseballNumber createNumber(int number) {
        return new BaseballNumber(number);
    }

    private void validateSize(int number) {
        if ((number < 1) || (number > 9)) {
            throw new IllegalArgumentException(Errors.NUMBER_RANGE.getValue());
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object obj) {
        return this.number == ((BaseballNumber)obj).getNumber();
    }

}
