package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number from(int value) {
        validate(value);
        return new Number(value);
    }

    public static Number from(String value) {
        return from(Integer.parseInt(value));
    }

    private static void validate(int value) {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new IllegalArgumentException("Number must be between " + MIN_NUMBER + " and " + MAX_NUMBER);
        }
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public int value() {
        return number;
    }
}
