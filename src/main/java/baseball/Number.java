package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {

    private final static int RANDOM_NUMBER_MIN = 1;
    private final static int RANDOM_NUMBER_MAX = 9;

    private int number;

    private Number(int number) {
        validateSize(number);
        this.number = number;
    }

    public static Number createNumber(int number) {
        return new Number(number);
    }

    public static Number createRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        return new Number(randomNumber);
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
        return this.number == ((Number)obj).getNumber();
    }

}
