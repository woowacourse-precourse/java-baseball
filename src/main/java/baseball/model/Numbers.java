package baseball.model;

import baseball.util.Errors;
import baseball.util.Rules;
import baseball.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private static final int NUMBER_COUNT = 3;

    private final List<BaseballNumber> baseballNumberList = new ArrayList<>();

    private Numbers() {
    }

    public static Numbers createNumbers(int input) {
        Numbers numbers = new Numbers();

        Validator.validateThreeDigits(input);
        Validator.validateDuplicateNumber(input);

        numbers.createNumberList(input);
        return numbers;
    }


    private void createNumberList(int input) {
        for (int exponent = NUMBER_COUNT - 1; exponent >= 0; exponent--) {
            int decimalNumber = (int) Math.pow(10, exponent);
            int number = input / decimalNumber;

            addNumber(number);

            input = input % decimalNumber;
        }
    }

    private void addNumber(int numberInt) {
        BaseballNumber baseballNumber = BaseballNumber.createNumber(numberInt);
        baseballNumberList.add(baseballNumber);
    }

    public BaseballNumber findNumber(int index) {
        return baseballNumberList.get(index);
    }

    public Hint getHint(int index, BaseballNumber userNumber) {
        if (isStrike(index, userNumber)) {
            return Hint.STRIKE;
        }
        if (isBall(index, userNumber)) {
            return Hint.BALL;
        }
        return Hint.NOTHING;
    }


    private boolean isBall(int index, BaseballNumber user) {
        BaseballNumber number = baseballNumberList.get(index);
        return (!number.equals(user)) // 위 If문 순서상 필수적이진 않음
                && baseballNumberList.contains(user);
    }

    private boolean isStrike(int index, BaseballNumber user) {
        BaseballNumber number = baseballNumberList.get(index);
        return number.equals(user);
    }
}
